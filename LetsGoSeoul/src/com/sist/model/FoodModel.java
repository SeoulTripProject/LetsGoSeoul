package com.sist.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class FoodModel {
	@RequestMapping("food/food_main.do")
	public String food_main(HttpServletRequest request, HttpServletResponse response)
	{
		FoodDAO dao=FoodDAO.newInstance();
		List<FoodVO> list=dao.foodMainData();
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../food/food_main.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("food/food_list.do")
	public String food_list(HttpServletRequest request, HttpServletResponse response)
	{
		FoodDAO dao=FoodDAO.newInstance();
		String page=request.getParameter("page");
		
		if(page==null) 
			page="1";
		
		int curpage=Integer.parseInt(page);
		List<FoodVO> list=dao.foodListData(curpage);
		int totalpage=dao.foodTotalPage();
		
		final int BLOCK=5;
		int startPage=(((curpage-1)/BLOCK)*BLOCK)+1;
		int endPage=(((curpage-1)/BLOCK)*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("BLOCK", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../food/food_list.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("food/food_detail.do")
	public String food_detail(HttpServletRequest request, HttpServletResponse response)
	{
		String no=request.getParameter("no");
		FoodDAO dao=FoodDAO.newInstance();
		FoodVO vo=dao.foodDetailData(Integer.parseInt(no));
		
		String address=vo.getAddress();
		String addr1=address.substring(0,address.lastIndexOf("지"));
		String addr2=address.substring(address.lastIndexOf("지"));
		String temp=address.substring(address.indexOf(" ")+1);
		temp=temp.substring(0,address.indexOf(" "));
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		
		// 근처 추천
		List<AttraVO> aList=dao.LocationData(temp);
		request.setAttribute("aList", aList);
		List<StayVO> sList=dao.HotelData(temp);
		request.setAttribute("sList", sList);
		List<NatureVO> nList=dao.NatureData(temp);
		request.setAttribute("nList", nList);
		List<ExbitVO> eList=dao.ExbitData(temp);
		request.setAttribute("eList", eList);
		
		// 댓글
		String type=request.getParameter("type");
		type="3";
		List<ReplyVO> list=dao.replyListData(Integer.parseInt(no), Integer.parseInt(type));
		request.setAttribute("list", list);
		
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../food/food_detail.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("food/food_detail_before.do")
	public String food_detail_before(HttpServletRequest request, HttpServletResponse response)
	{
		String no=request.getParameter("no");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		Cookie cookie=new Cookie(id+"f"+no, no);
		
		cookie.setMaxAge(60*60*24);  
		cookie.setPath("/");
		response.addCookie(cookie);
		
		return "redirect:../food/food_detail.do?no="+no; 
	}
	
	@RequestMapping("food/reply_insert.do") 
	public String reply_insert(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		
		String bno=request.getParameter("bno");
		String type=request.getParameter("type");
		String msg=request.getParameter("msg");
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		String name=(String)session.getAttribute("name");
		
		ReplyVO vo=new ReplyVO();
		vo.setBno(Integer.parseInt(bno));
		vo.setId(id);
		vo.setName(name);
		vo.setType(Integer.parseInt(type));
		vo.setMsg(msg);
		
		FoodDAO dao=FoodDAO.newInstance();
		
		dao.foodReplyInsert(vo);
		
		return "redirect:../food/food_detail.do?no="+bno;
	}
	
	@RequestMapping("food/reply_delete.do")
	public String reply_delete(HttpServletRequest request, HttpServletResponse response)
	{
		String no=request.getParameter("no"); 
		String bno=request.getParameter("bno"); 
		
		FoodDAO dao=FoodDAO.newInstance();
		
		dao.foodReplyDelete(Integer.parseInt(no));
		
		return "redirect:../food/food_detail.do?no="+bno; 
	}
	
	@RequestMapping("food/reply_update.do")
	public String reply_update(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		
		String no=request.getParameter("no");
		String bno=request.getParameter("bno"); 
		String msg=request.getParameter("msg");
		
		FoodDAO dao=FoodDAO.newInstance();
		
		dao.foodReplyUpdate(Integer.parseInt(no), msg);
		
		return "redirect:../food/food_detail.do?no="+bno; 
	}
	
	@RequestMapping("food/food_area.do")
	public String food_area(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("main_jsp", "../food/food_area.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("food/location_result.do")
	public String location_result(HttpServletRequest request, HttpServletResponse response)
	{
		String no=request.getParameter("no");
		FoodDAO dao=FoodDAO.newInstance();
		FoodVO vo=dao.foodDetailData(Integer.parseInt(no));
		request.setAttribute("vo", vo);
	    String[] guList_1 = { "전체", "강서구", "양천구", "구로구", "마포구", "영등포구", "금천구",
		    "은평구", "서대문구", "동작구", "관악구", "종로구", "중구", "용산구", "서초구", "강북구",
		    "성북구", "도봉구", "동대문구", "성동구", "강남구", "노원구", "중랑구", "광진구", "송파구",
		    "강동구" };
	    ArrayList<FoodVO> list=dao.locationData(guList_1[Integer.parseInt(no)]);
	    request.setAttribute("list", list);
		
		return "redirect:../food/food_area.do";
	}
	
}
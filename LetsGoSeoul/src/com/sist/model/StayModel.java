package com.sist.model;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class StayModel {
	@RequestMapping("stay/stay_main.do")
	public String stay_main(HttpServletRequest request,HttpServletResponse response)
	{
		
		//String no=request.getParameter("no"); 
		//DAO
		StayDAO dao=StayDAO.newInstance(); 
		List<StayVO> list=dao.stayMainData();
		List<StayVO> list2=dao.stayMainData2();
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);

		request.setAttribute("main_jsp","../stay/stay_main.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("stay/hotel.do")
	public String stay_hotel(HttpServletRequest request,HttpServletResponse response)
	{
		StayDAO dao=StayDAO.newInstance(); 
		
		String page=request.getParameter("page");
		if(page==null)
		{
			page="1";
		}
		int curpage=Integer.parseInt(page);
		List<StayVO> list=dao.HotelData(curpage);
		int totalpage=dao.HotelTotalPage();
		
		final int BLOCK=5;
		int startPage=(((curpage-1)/BLOCK)*BLOCK)+1;
		int endPage=(((curpage-1)/BLOCK)*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("list", list);
		request.setAttribute("BLOCK", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		request.setAttribute("main_jsp","../stay/hotel.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("stay/ghouse.do")
	public String stay_ghouse(HttpServletRequest request,HttpServletResponse response)
	{
		StayDAO dao=StayDAO.newInstance(); 
		
		String page=request.getParameter("page");
		if(page==null)
		{
			page="1";
		}
		int curpage=Integer.parseInt(page);
		List<StayVO> list=dao.GhouseData(curpage);
		int totalpage=dao.GhouseTotalPage();
		
		final int BLOCK=5;
		int startPage=(((curpage-1)/BLOCK)*BLOCK)+1;
		int endPage=(((curpage-1)/BLOCK)*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("list", list);
		request.setAttribute("BLOCK", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		
		request.setAttribute("main_jsp","../stay/ghouse.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("stay/hdetail.do")
	public String hotel_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");
		//String bno=request.getParameter("bno");

		StayDAO dao=StayDAO.newInstance();
		StayVO vo=dao.HotelDetailData(Integer.parseInt(no));
		//BoardDAO bdao=BoardDAO.newInstance();
		//List<ReplyVO> list=bdao.replyListData(Integer.parseInt(bno), 2);
		
		String addr=vo.getAddr();
		//서울 중구 을지로 30
		addr=addr.substring(addr.indexOf(" "));
		// 중구 을지로 30
		addr=addr.trim();
		//중구 을지로 30
		  
		String gu=addr;
		//중구 을지로 30
		gu=gu.substring(0,gu.indexOf(" "));
		//중구
		System.out.println("gu="+gu);
		  
		List<FoodVO> fList=dao.seoulFoodListData(gu);
		List<NatureVO> nList=dao.natureListData(gu);
		
		request.setAttribute("fList", fList);
		request.setAttribute("nList", nList);
		
		//request.setAttribute("addr", addr);
		 
		request.setAttribute("vo", vo);
		//request.setAttribute("list", "list");
		
		request.setAttribute("main_jsp", "../stay/hdetail.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("stay/gdetail.do")
	public String ghouse_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");

		StayDAO dao=StayDAO.newInstance();
		StayVO vo=dao.GhouseDetailData(Integer.parseInt(no));
		
		String addr=vo.getAddr();
		//서울 중구 을지로 30
		addr=addr.substring(addr.indexOf(" "));
		// 중구 을지로 30
		addr=addr.trim();
		//중구 을지로 30
		  
		String gu=addr;
		//중구 을지로 30
		gu=gu.substring(0,gu.indexOf(" "));
		//중구
		System.out.println("gu="+gu);
		  
		List<FoodVO> fList=dao.seoulFoodListData(gu);
		List<NatureVO> nList=dao.natureListData(gu);
		
		request.setAttribute("fList", fList);
		request.setAttribute("nList", nList);
		
		//request.setAttribute("addr", addr);
		 
		//request.setAttribute("list", "list");

		request.setAttribute("vo", vo);
		

		request.setAttribute("main_jsp", "../stay/gdetail.jsp");
		return "../main/main.jsp";
	}
	
	/*
	 * @RequestMapping("stay/hdetail_reply_insert.do") public String
	 * reply_insert(HttpServletRequest request,HttpServletResponse response) { try {
	 * request.setCharacterEncoding("UTF-8"); }catch(Exception ex) {}
	 * 
	 * //����ڰ� ������ ���� �޴´� String bno=request.getParameter("bno"); String
	 * type=request.getParameter("type"); String msg=request.getParameter("msg");
	 * 
	 * HttpSession session=request.getSession(); String
	 * id=(String)session.getAttribute("id"); String
	 * name=(String)session.getAttribute("name");
	 * 
	 * //��� DAO���� ReplyVO vo=new ReplyVO(); vo.setBno(Integer.parseInt(bno));
	 * vo.setId(id); vo.setName(name); vo.setType(Integer.parseInt(type));
	 * vo.setMsg(msg); //�̵� ����� �ö󰣴� BoardDAO dao=BoardDAO.newInstance(); //��� �߰�
	 * �޼ҵ� dao.replyInsert(vo);
	 * 
	 * return "redirect:../stay/hdetail.do?no="+bno;
	 * 
	 * }
	 */
	  
	/*
	 * @RequestMapping("fstay/hdetail_reply_delete.do") public String
	 * reply_delete(HttpServletRequest request,HttpServletResponse response) { //��û
	 * ������ �ޱ� String no=request.getParameter("no"); // ��۹�ȣ (���� ����) String
	 * bno=request.getParameter("bno");// �Խù� ��ȣ(�ش� �������� �̵�)
	 * 
	 * //DAO BoardDAO dao=BoardDAO.newInstance(); //���� �޼ҵ� ȣ��
	 * dao.replyDelete(Integer.parseInt(no));
	 * 
	 * return "redirect:../stay/hdetail.do?no="+bno; }
	 */
	  
	/*
	 * @RequestMapping("stay/hdetail_reply_update.do") public String
	 * reply_update(HttpServletRequest request,HttpServletResponse response) { //��û
	 * (�ѱ�) try { request.setCharacterEncoding("UTF-8"); }catch(Exception ex) {}
	 * 
	 * String no=request.getParameter("no"); String bno=request.getParameter("bno");
	 * String msg=request.getParameter("msg");
	 * 
	 * //DAO BoardDAO dao=BoardDAO.newInstance(); //������ �޼ҵ�
	 * dao.replyUpdate(Integer.parseInt(no), msg);
	 * 
	 * return "redirect:../stay/hdetail.do?no="+bno; }
	 */
}































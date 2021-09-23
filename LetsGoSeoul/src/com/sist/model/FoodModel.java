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
		
	    String[] guList_1 = { "전체", "강서구", "양천구", "구로구", "마포구", "영등포구", "금천구",
		    "은평구", "서대문구", "동작구", "관악구", "종로구", "중구", "용산구", "서초구", "강북구",
		    "성북구", "도봉구", "동대문구", "성동구", "강남구", "노원구", "중랑구", "광진구", "송파구",
		    "강동구" };
	    
	    ArrayList<FoodVO> list=dao.locationData(guList_1[Integer.parseInt(no)]);
	    System.out.println(list);
	    request.setAttribute("list", list);

		return "../food/location_result.jsp";
	}
	
	@RequestMapping("food/food_recommend.do")
	public String food_recommend(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("main_jsp", "../food/food_recommend.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("food/sub_menu.do")
	public String sub_menu(HttpServletRequest request, HttpServletResponse response)
	{
		// Ajax
		String[] menu1={"#휴식", "#퇴근길", "#휴가", "#여행", "#술집", "#이자카야", "#2020망고플레이트인기맛집",
						"#채식메뉴", "#강남", "#일식", "#홍대", "#상수", "#연남동", "#한강", "#시청", "#이태원", "#송리단길", "#가로수길",
		        		"#거리" , "#고백"
						};
		String[] menu2={"#외로움", "#기분전환", "#슬픔" ,"#이별","#지침","#설렘",
				             "#위로", "#스트레스","#짜증", "#그리움" ,"#우울" ,
				             "#불안","#기쁨"
						};
		String[] menu3={"#신나는","#따뜻한", "#편안한", "#부드러운",  "#달콤한",
				        "#시원한"
						};
		String[] menu4={"#봄", "#여름", "#가을", "#겨울", "#맑은날", "#추운날", "#흐린날", 
				              "#비오는날", "#더운날", "#안개낀날", "#눈오는날"};
		
		String no=request.getParameter("no");
		List<String> list=new ArrayList<String>();
		
		if(no.equals("1"))
		{
			list.clear();
			for(String m:menu1)
			{
				list.add(m);
			}
		}
		else if(no.equals("2"))
		{
			list.clear();
			for(String m:menu2)
			{
				list.add(m);
			}
		}
		else if(no.equals("3"))
		{
			list.clear();
			for(String m:menu3)
			{
				list.add(m);
			}
		}
		else if(no.equals("4"))
		{
			list.clear();
			for(String m:menu4)
			{
				list.add(m);
			}
		}
		request.setAttribute("list", list);
		return "../food/sub_menu.jsp";
	}	
	
	@RequestMapping("food/recommand_result.do")
	public String recommend_result(HttpServletRequest request, HttpServletResponse response)
	{
		String menu=request.getParameter("menu");
		System.out.println(menu);
		FoodDAO dao=FoodDAO.newInstance();
		
		for(int i=0;i<=12;i++)
		{
			int a=(int)(Math.random()*100)+1;
			//List list=new ArrayList();
			//List<FoodVO> toList=new ArrayList<FoodVO>();
			//toList(dao.foodrecommandData(a),list);
			//request.setAttribute("toList", toList);
			List<FoodVO> list=dao.foodrecommandData(a);
			request.setAttribute("list", list);
		}
		
		request.setAttribute("menu", menu);
		return "../food/food_result.jsp";
	}

	private void toList(List<FoodVO> foodrecommandData, List list) {
		// TODO Auto-generated method stub
		
	}
	
}
package com.sist.model;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.StayDAO;
import com.sist.vo.StayVO;

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
		
		request.setAttribute("main_jsp","../stay/ghouse.jsp");
		return "../main/main.jsp";
	}
}
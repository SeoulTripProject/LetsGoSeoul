package com.sist.model;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class NatureModel {
	@RequestMapping("nature/main.do")
	public String nature_main(HttpServletRequest request,HttpServletResponse response)
	{
		NatureDAO dao=NatureDAO.newInstance(); 
		
		String page=request.getParameter("page");
		if(page==null)
		{
			page="1";
		}
		int curpage=Integer.parseInt(page);
		List<NatureVO> list=dao.NatureData(curpage);
		int totalpage=dao.NatureTotalPage();
		
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
		
		request.setAttribute("main_jsp","../nature/main.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("nature/detail.do")
	public String nature_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");

		NatureDAO dao=NatureDAO.newInstance();
		NatureVO vo=dao.NatureDetailData(Integer.parseInt(no));
		
		String addr=vo.getAddr();
		//서울 종로구 무교로 37 (서린동)
		addr=addr.substring(addr.indexOf(" "));
		addr=addr.trim();
		//종로구 무교로 37 (서린동)
		
		String gu=addr;
		//중구 을지로 30
		gu=gu.substring(0,gu.indexOf(" "));
		//중구
		System.out.println("gu="+gu);
		  
		List<FoodVO> fList=dao.seoulFoodListData(gu);
		
		request.setAttribute("fList", fList);
		
		//request.setAttribute("addr", addr);
		 
		//request.setAttribute("list", "list");

		request.setAttribute("vo", vo);

		request.setAttribute("main_jsp", "../nature/detail.jsp");
		return "../main/main.jsp";
	}
	
	
	
	
	
	
	
	
}




















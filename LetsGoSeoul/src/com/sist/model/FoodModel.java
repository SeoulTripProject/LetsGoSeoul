package com.sist.model;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		int curpage=Integer.parseInt(page);
		List<FoodVO> list=dao.foodListData(curpage);
		if(page==null)
			page="1";
		
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
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../food/food_detail.jsp");
		return "../main/main.jsp";
	}
}

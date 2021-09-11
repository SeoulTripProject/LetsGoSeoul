package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller
public class StayModel {
	@RequestMapping("stay/stay_main.do")
	public String stay_main(HttpServletRequest request,HttpServletResponse response)
	{
		
		request.setAttribute("main_jsp","../stay/stay_main.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("stay/hotel.do")
	public String stay_hotel(HttpServletRequest request,HttpServletResponse response)
	{
		
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
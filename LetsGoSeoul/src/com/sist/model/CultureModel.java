package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller
public class CultureModel {
	@RequestMapping("culture/culture_main.do")
	public String main_main(HttpServletRequest request,HttpServletResponse response)
	{
		request.setAttribute("main_jsp", "../culture/culture_main.jsp");
		return "../main/main.jsp";
	}
}

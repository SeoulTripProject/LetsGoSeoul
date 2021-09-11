package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.xml.SeoulWeatherManager;

@Controller
public class BoardModel {
	@RequestMapping("board/board_main.do")
	public String main_main(HttpServletRequest request,HttpServletResponse response)
	{
		
		return "../main/main.jsp";
	}
	@RequestMapping("board/weather.do")
	public String weather_main(HttpServletRequest request,HttpServletResponse response)
	{
		SeoulWeatherManager sm=new SeoulWeatherManager();
		String data=sm.seoulWeather();
		request.setAttribute("data", data);
		request.setAttribute("main_jsp", "../board/weather.jsp");
		return "../main/main.jsp";
	}
}

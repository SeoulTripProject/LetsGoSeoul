package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.util.*;
import com.sist.xml.*;
@Controller
public class NewsModel {
	@RequestMapping("news/news.do")
	public String news_news(HttpServletRequest request, HttpServletResponse response)
	{
		// 사용자에게 검색어를 받는다
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		String fd=request.getParameter("fd");
		// 실행하자마자 맛집이 나올 수 있도록
		if(fd==null)
			fd="서울관광";
		
		// 실시간 뉴스를 읽는다
		NewsManager nm=new NewsManager();
		List<Item> nlist=nm.newsFindData(fd);
		request.setAttribute("nlist", nlist);
		
		request.setAttribute("main_jsp", "../news/news.jsp");
		return "../main/home.jsp";
	}
}

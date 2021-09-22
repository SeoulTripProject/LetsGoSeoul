package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;
@Controller
public class CultureModel {
	@RequestMapping("culture/culture_main.do")
	public String main_main(HttpServletRequest request,HttpServletResponse response)
	{
		CultureDAO dao=CultureDAO.newInstance();
		List<ExbitVO> eList=dao.exbitData();
		List<CultureVO> list=dao.playData();
		request.setAttribute("eList", eList);
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../culture/culture_main.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("culture/exhibition.do")
	public String culture_exhibition(HttpServletRequest request,HttpServletResponse response)
	{
		CultureDAO dao=CultureDAO.newInstance();
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		List<ExbitVO> list=dao.exbitData(curpage);
		int totalpage=dao.exbitTotalPage();
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../culture/exhibition.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("culture/exhibition_detail.do")
	public String exhibition_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");
		CultureDAO dao=CultureDAO.newInstance();
		ExbitVO vo=dao.exbitDetailData(Integer.parseInt(no));
		
		String addr=vo.getAddr();
		addr=addr.substring(addr.indexOf(" "));
		addr=addr.trim();
		
		System.out.println("addr="+addr);
		
		String gu=addr;
		gu=gu.substring(gu.indexOf(" "));
		gu=gu.trim();
		System.out.println("gu="+gu);
		
		gu=gu.substring(0,gu.lastIndexOf("구")+1);
		System.out.println("gu="+gu);
		
		List<FoodVO> fList=dao.seoulFoodListData(gu);
		request.setAttribute("fList", fList);
		
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../culture/exhibition_detail.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("culture/play.do")
	public String culutre_play(HttpServletRequest request,HttpServletResponse response)
	{
		CultureDAO dao=CultureDAO.newInstance();
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		List<CultureVO> list=dao.playData(curpage);
		int totalpage=dao.exbitTotalPage();
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("list", list);
		request.setAttribute("main_jsp", "../culture/play.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("culture/play_detail.do")
	public String play_detail(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");
		CultureDAO dao=CultureDAO.newInstance();
		CultureVO vo=dao.playDetailData(Integer.parseInt(no));
		
		String addr=vo.getAddr();
		addr=addr.substring(addr.indexOf(" "));
		addr=addr.trim();
		
		System.out.println("addr="+addr);
		
		String gu=addr;
		gu=gu.substring(gu.indexOf(" "));
		gu=gu.trim();
		System.out.println("gu="+gu);
		
		gu=gu.substring(0,gu.lastIndexOf("구")+1);
		System.out.println("gu="+gu);
		
		List<FoodVO> fList=dao.seoulFoodListData(gu);
		request.setAttribute("fList", fList);
		
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../culture/play_detail.jsp");
		return "../main/main.jsp";
	}
}

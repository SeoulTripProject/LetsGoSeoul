package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.AttraDAO;
import com.sist.vo.AttraVO;


@Controller
public class AttraModel {
	@RequestMapping("attraction/attraction_main.do")
	public String Attra_main(HttpServletRequest request,HttpServletResponse response)
	{
		AttraDAO dao=AttraDAO.newInstance(); 
		List<AttraVO> Llist=dao.LandmarkMainData();
		List<AttraVO> Plist=dao.PalaceMainData();
		List<AttraVO> Hlist=dao.HistoricMainData();
		List<AttraVO> Olist=dao.OldMainData();
		List<AttraVO> Mlist=dao.MuseumMainData();
		request.setAttribute("Llist", Llist);
		request.setAttribute("Plist", Plist);
		request.setAttribute("Hlist", Hlist);
		request.setAttribute("Olist", Olist);
		request.setAttribute("Mlist", Mlist);

		request.setAttribute("main_jsp","../attraction/attraction_main.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("attraction/landmark.do")
	public String AttraLandmark(HttpServletRequest request,HttpServletResponse response)
	{
		AttraDAO dao=AttraDAO.newInstance(); 
		
		String page=request.getParameter("page");
		if(page==null)
		{
			page="1";
		}
		int curpage=Integer.parseInt(page);
		List<AttraVO> list=dao.LandmarkData(curpage);
		int totalpage=dao.LandmarkTotalPage();
		
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
		
		request.setAttribute("main_jsp","../attraction/landmark.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("attraction/landmark.do")
	public String AttraPalace(HttpServletRequest request,HttpServletResponse response)
	{
		AttraDAO dao=AttraDAO.newInstance(); 
		
		String page=request.getParameter("page");
		if(page==null)
		{
			page="1";
		}
		int curpage=Integer.parseInt(page);
		List<AttraVO> list=dao.LandmarkData(curpage);
		int totalpage=dao.LandmarkTotalPage();
		
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
		
		request.setAttribute("main_jsp","../attraction/landmark.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("attraction/landmark.do")
	public String AttraHistoric(HttpServletRequest request,HttpServletResponse response)
	{
		AttraDAO dao=AttraDAO.newInstance(); 
		
		String page=request.getParameter("page");
		if(page==null)
		{
			page="1";
		}
		int curpage=Integer.parseInt(page);
		List<AttraVO> list=dao.LandmarkData(curpage);
		int totalpage=dao.LandmarkTotalPage();
		
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
		
		request.setAttribute("main_jsp","../attraction/landmark.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("attraction/landmark.do")
	public String AttraOld(HttpServletRequest request,HttpServletResponse response)
	{
		AttraDAO dao=AttraDAO.newInstance(); 
		
		String page=request.getParameter("page");
		if(page==null)
		{
			page="1";
		}
		int curpage=Integer.parseInt(page);
		List<AttraVO> list=dao.LandmarkData(curpage);
		int totalpage=dao.LandmarkTotalPage();
		
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
		
		request.setAttribute("main_jsp","../attraction/landmark.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("attraction/landmark.do")
	public String AttraMuseum(HttpServletRequest request,HttpServletResponse response)
	{
		AttraDAO dao=AttraDAO.newInstance(); 
		
		String page=request.getParameter("page");
		if(page==null)
		{
			page="1";
		}
		int curpage=Integer.parseInt(page);
		List<AttraVO> list=dao.LandmarkData(curpage);
		int totalpage=dao.LandmarkTotalPage();
		
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
		
		request.setAttribute("main_jsp","../attraction/landmark.jsp");
		return "../main/main.jsp";
	}
	
}

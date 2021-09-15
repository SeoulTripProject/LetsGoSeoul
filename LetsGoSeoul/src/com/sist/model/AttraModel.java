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
	// attraction main
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
	
	// 랜드마크
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
		List<AttraVO> Llist=dao.LandmarkData(curpage);
		int totalpage=dao.LandmarkTotalPage();
		
		final int BLOCK=5;
		int startPage=(((curpage-1)/BLOCK)*BLOCK)+1;
		int endPage=(((curpage-1)/BLOCK)*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("Llist", Llist);
		request.setAttribute("BLOCK", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		request.setAttribute("main_jsp","../attraction/landmark.jsp");
		return "../main/main.jsp";
	}
	
	//고궁
	@RequestMapping("attraction/palace.do")
	public String AttraPalace(HttpServletRequest request,HttpServletResponse response)
	{
		AttraDAO dao=AttraDAO.newInstance(); 
		
		String page=request.getParameter("page");
		if(page==null)
		{
			page="1";
		}
		int curpage=Integer.parseInt(page);
		List<AttraVO> Plist=dao.PalaceData(curpage);
		int totalpage=dao.PalaceTotalPage();
		
		final int BLOCK=5;
		int startPage=(((curpage-1)/BLOCK)*BLOCK)+1;
		int endPage=(((curpage-1)/BLOCK)*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("Plist", Plist);
		request.setAttribute("BLOCK", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		request.setAttribute("main_jsp","../attraction/palace.jsp");
		return "../main/main.jsp";
	}
	
	// 역사적장소
	@RequestMapping("attraction/historic.do")
	public String AttraHistoric(HttpServletRequest request,HttpServletResponse response)
	{
		AttraDAO dao=AttraDAO.newInstance(); 
		
		String page=request.getParameter("page");
		if(page==null)
		{
			page="1";
		}
		int curpage=Integer.parseInt(page);
		List<AttraVO> Hlist=dao.HistoricData(curpage);
		int totalpage=dao.HistoricTotalPage();
		
		final int BLOCK=5;
		int startPage=(((curpage-1)/BLOCK)*BLOCK)+1;
		int endPage=(((curpage-1)/BLOCK)*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("Hlist", Hlist);
		request.setAttribute("BLOCK", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		request.setAttribute("main_jsp","../attraction/historic.jsp");
		return "../main/main.jsp";
	}
	
	
	// 오래된 가게
	@RequestMapping("attraction/old.do")
	public String AttraOld(HttpServletRequest request,HttpServletResponse response)
	{
		AttraDAO dao=AttraDAO.newInstance(); 
		
		String page=request.getParameter("page");
		if(page==null)
		{
			page="1";
		}
		int curpage=Integer.parseInt(page);
		List<AttraVO> Olist=dao.OldData(curpage);
		int totalpage=dao.OldTotalPage();
		
		final int BLOCK=5;
		int startPage=(((curpage-1)/BLOCK)*BLOCK)+1;
		int endPage=(((curpage-1)/BLOCK)*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("Olist", Olist);
		request.setAttribute("BLOCK", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		request.setAttribute("main_jsp","../attraction/old.jsp");
		return "../main/main.jsp";
	}
	
	//박물관
	@RequestMapping("attraction/museum.do")
	public String AttraMuseum(HttpServletRequest request,HttpServletResponse response)
	{
		AttraDAO dao=AttraDAO.newInstance(); 
		
		String page=request.getParameter("page");
		if(page==null)
		{
			page="1";
		}
		int curpage=Integer.parseInt(page);
		List<AttraVO> Mlist=dao.MuseumData(curpage);
		int totalpage=dao.MuseumTotalPage();
		
		final int BLOCK=5;
		int startPage=(((curpage-1)/BLOCK)*BLOCK)+1;
		int endPage=(((curpage-1)/BLOCK)*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("Mlist", Mlist);
		request.setAttribute("BLOCK", BLOCK);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		request.setAttribute("main_jsp","../attraction/museum.jsp");
		return "../main/main.jsp";
	}
	
}

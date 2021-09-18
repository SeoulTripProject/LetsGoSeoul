package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.AttraDAO;
import com.sist.dao.CultureDAO;
import com.sist.dao.FoodDAO;
import com.sist.vo.AttraVO;
import com.sist.vo.ExbitVO;
import com.sist.vo.FoodVO;


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
	@RequestMapping("attraction/landmark_detail.do")
	   public String landmark_detail(HttpServletRequest request,HttpServletResponse response)
	   {
		   String no=request.getParameter("no");
		   AttraDAO dao=AttraDAO.newInstance();
		   AttraVO vo=dao.LandmarkDetailData(Integer.parseInt(no));
		   String address=vo.getAddr();
		   String addr1=address.substring(address.indexOf("서"));
		   // 서울특별시 송파구 백제고분로41길 43-21 SANDONG빌딩
		   String addr2=addr1.replace("일대"," ");
		      
		   // 결과값 보내기
		   
		   vo.setAddr2(addr2);
		   request.setAttribute("vo", vo);
		   
		   request.setAttribute("main_jsp","../attraction/landmark_detail.jsp");
		   return "../main/main.jsp";
	   }
	
	
	///////////////////////////////////////////////////////////////////////고궁
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
	@RequestMapping("attraction/palace_detail.do")
	   public String palace_detail(HttpServletRequest request,HttpServletResponse response)
	   {
		   String no=request.getParameter("no");
		   AttraDAO dao=AttraDAO.newInstance();
		   AttraVO vo=dao.PalaceDetailData(Integer.parseInt(no));
		   String address=vo.getAddr();
		   String addr3=address.substring(address.indexOf("서"));
		   // 서울특별시 송파구 백제고분로41길 43-21 SANDONG빌딩
		   String addr4=addr3.replace("일대"," ");
		      
		   // 결과값 보내기
		   
		   vo.setAddr2(addr4);
		   request.setAttribute("vo", vo);
		   
		   request.setAttribute("main_jsp","../attraction/palace_detail.jsp");
		   return "../main/main.jsp";
	   }
	
	/////////////////////////////////////////////// 역사적장소//////////////////////////////////////////////////////////////////
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
	@RequestMapping("attraction/historic_detail.do")
	   public String historic_detail(HttpServletRequest request,HttpServletResponse response)
	   {
		   String no=request.getParameter("no");
		   AttraDAO dao=AttraDAO.newInstance();
		   AttraVO vo=dao.HistoricDetailData(Integer.parseInt(no));
		   String address=vo.getAddr();
		   String addr5=address.substring(address.indexOf("서"));
		   // 서울특별시 송파구 백제고분로41길 43-21 SANDONG빌딩
		   String addr6=addr5.replace("일대"," ");
		      
		   // 결과값 보내기
		   
		   vo.setAddr2(addr6);
		   request.setAttribute("vo", vo);
		   
		   request.setAttribute("main_jsp","../attraction/historic_detail.jsp");
		   return "../main/main.jsp";
	   }
	
	
	// ////////////////////////////////오래된 가게///////////////////////////////////
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
	@RequestMapping("attraction/old_detail.do")
	   public String Old_detail(HttpServletRequest request,HttpServletResponse response)
	   {
		   String no=request.getParameter("no");
		   AttraDAO dao=AttraDAO.newInstance();
		   AttraVO vo=dao.OldDetailData(Integer.parseInt(no));
		   String address=vo.getAddr();
		   String addr7=address.substring(address.indexOf("서"));
		   // 서울특별시 송파구 백제고분로41길 43-21 SANDONG빌딩
		   String addr8=addr7.replace("일대"," ");
		      
		   // 결과값 보내기
		   
		   vo.setAddr2(addr8);
		   request.setAttribute("vo", vo);
		   
		   request.setAttribute("main_jsp","../attraction/old_detail.jsp");
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
	@RequestMapping("attraction/museum_detail.do")
	   public String Museum_detail(HttpServletRequest request,HttpServletResponse response)
	   {
		   String no=request.getParameter("no");
		   AttraDAO dao=AttraDAO.newInstance();
		   AttraVO vo=dao.MuseumDetailData(Integer.parseInt(no));
		   String address=vo.getAddr();
		   String addr9=address.substring(address.indexOf("서"));
		   // 서울특별시 송파구 백제고분로41길 43-21 SANDONG빌딩
		   String addr10=addr9.replace("일대"," ");
		      
		   // 결과값 보내기
		   
		   vo.setAddr2(addr10);
		   request.setAttribute("vo", vo);
		   
		   request.setAttribute("main_jsp","../attraction/museum_detail.jsp");
		   return "../main/main.jsp";
	   }
	
}

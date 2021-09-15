package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.sist.dao.*;
@Controller
public class NoticeModel {
	@RequestMapping("notice/notice_list.do")
	public String notice_list(HttpServletRequest request,HttpServletResponse response)
	{
		NoticeDAO dao=NoticeDAO.newInstance();
		String page=request.getParameter("page");
		
		if(page==null) 
			page="1";
		
		int curpage=Integer.parseInt(page);
		List<NoticeVO> list=dao.noticeListDate(curpage);
		int totalpage=dao.noticeTotalPage();
		
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
		request.setAttribute("main_jsp", "../notice/notice_list.jsp");
		
		return "../main/main.jsp";
	}

	@RequestMapping("notice/notice_detail.do")
	public String notice_detail(HttpServletRequest request,HttpServletResponse response)
	{

		NoticeDAO dao=NoticeDAO.newInstance();
		
		String no=request.getParameter("no");
		NoticeVO vo=dao.noticeDetailDate(Integer.parseInt(no));
		
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../notice/notice_detail.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("notice/notice_insert.do")
	public String notice_insert(HttpServletRequest request,HttpServletResponse response)
	{
		
		request.setAttribute("main_jsp", "../notice/notice_insert.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("notice/notice_insert_ok.do")
	public String notice_insert_ok(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("name");

		NoticeVO vo=new NoticeVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		

		NoticeDAO dao=NoticeDAO.newInstance();

		dao.noticeInsert(vo);
		
		return "redirect:../notice/notice_list.do";
	}
	
	@RequestMapping("notice/notice_delete.do")
	public String notice_delete(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");

		NoticeDAO dao=NoticeDAO.newInstance();

		dao.noticeDelete(Integer.parseInt(no));
		
		return "redirect:../notice/notice_list.do";
	}
	
	@RequestMapping("notice/notice_update.do")
	public String notice_update(HttpServletRequest request,HttpServletResponse response)
	{
		String no=request.getParameter("no");
		
		NoticeDAO dao=NoticeDAO.newInstance();

		NoticeVO vo=dao.noticeUpdateData(Integer.parseInt(no));
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../notice/notice_update.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("notice/notice_update_ok.do")
	public String notice_update_ok(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		String no=request.getParameter("no");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");

		NoticeVO vo=new NoticeVO();
		vo.setNo(Integer.parseInt(no));
		vo.setSubject(subject);
		vo.setContent(content);
		NoticeDAO dao=NoticeDAO.newInstance();

		dao.noticeUpdate(vo);
		return "redirect:../notice/notice_detail.do?no="+no;
	}
}

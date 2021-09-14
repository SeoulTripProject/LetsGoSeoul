package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.xml.SeoulWeatherManager;
import java.util.*;
import com.sist.vo.*;
import java.net.*;
@Controller
public class BoardModel {
	@RequestMapping("board/board_main.do")
	public String main_main(HttpServletRequest request,HttpServletResponse response)
	{
		
		return "../main/main.jsp";
	}
	@RequestMapping("board/freeboard.do")
	  public String freeboard_list(HttpServletRequest request,HttpServletResponse response)
	  {

		  String page=request.getParameter("page");
		  
		  if(page==null) 
		  {
			  page="1";
		  }

		  BoardDAO dao=BoardDAO.newInstance();
		  int curpage=Integer.parseInt(page);
		  List<BoardVO> list=dao.freeboardListData(curpage);
		  int totalpage=dao.freeboardTotalPage();

		  request.setAttribute("curpage", curpage);// �쁽�옱 �럹�씠吏�
		  request.setAttribute("totalpage", totalpage);
		  request.setAttribute("list", list);

		  request.setAttribute("main_jsp", "../board/freeboard.jsp");
		  return "../main/main.jsp";
	  }
	@RequestMapping("board/freeboard_insert.do")
	  public String freeboard_insert(HttpServletRequest request,HttpServletResponse response)
	  {
		  // �엯�젰李쎈쭔 蹂댁뿬以��떎 
		  request.setAttribute("main_jsp", "../board/freeboard_insert.jsp");
		  return "../main/main.jsp";
	  }
	@RequestMapping("board/freeboard_insert_ok.do")
	  public String freeboard_insert_ok(HttpServletRequest request,HttpServletResponse response)
	  {
	
		  try
		  {
			  
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex) {}

		  String name=request.getParameter("name");
		  String subject=request.getParameter("subject");
		  String content=request.getParameter("content");
		  String pwd=request.getParameter("pwd");
		  
		  
		  BoardVO vo=new BoardVO();
		  vo.setName(name);
		  vo.setSubject(subject);
		  vo.setContent(content);
		  vo.setPwd(pwd);
		  

		  BoardDAO dao=BoardDAO.newInstance();
	
		  dao.freeboardInsert(vo);
		  return "redirect:../board/freeboard.do";// 泥섎━�썑�뿉 => 紐⑸줉�쓣 蹂댁뿬以��떎 
	  }

	  @RequestMapping("board/freeboard_detail.do")
	  public String freeboardDetail(HttpServletRequest request,HttpServletResponse response)
	  {

		  String no=request.getParameter("no");

		  BoardDAO dao=BoardDAO.newInstance();

		  BoardVO vo=dao.freeboardDetailData(Integer.parseInt(no));

		  List<ReplyVO> list=dao.replyListData(Integer.parseInt(no), 1);
		  request.setAttribute("list", list);
		  request.setAttribute("vo", vo);
		  request.setAttribute("main_jsp", "../freeboard/detail.jsp");
		  
		  return "../main/main.jsp";
	  }
	  @RequestMapping("board/freeboard_update.do")
	  public String freeboard_update(HttpServletRequest request,HttpServletResponse response)
	  {
		  
		  String no=request.getParameter("no");

		  BoardDAO dao=BoardDAO.newInstance();
	
		  BoardVO vo=dao.freeboardUpdateData(Integer.parseInt(no));
	
		  request.setAttribute("vo", vo);
		  request.setAttribute("main_jsp", "../board/freeboard_update.jsp");
		  return "../main/main.jsp";
	  }
	  @RequestMapping("board/freeboard_upok.do")
	  public String freeboard_update_ok(HttpServletRequest request,HttpServletResponse response)
	  {

		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex) {}
		  
		  String name=request.getParameter("name");
		  String subject=request.getParameter("subject");
		  String content=request.getParameter("content");
		  String pwd=request.getParameter("pwd");
		  String no=request.getParameter("no");
		  
		  BoardVO vo=new BoardVO();
		  vo.setNo(Integer.parseInt(no));
		  vo.setName(name);
		  vo.setSubject(subject);
		  vo.setContent(content);
		  vo.setPwd(pwd);
		  
		  BoardDAO dao=BoardDAO.newInstance();

		  boolean bCheck=dao.freeboardUpdate(vo);

		  request.setAttribute("bCheck", bCheck);
		  request.setAttribute("no", no);
		  return "../board/freeboard_upok.jsp";
	  }
	  @RequestMapping("board/freeboard_delete.do")
	  public String freeboard_delete(HttpServletRequest request,HttpServletResponse response)
	  {
		  
		  String no=request.getParameter("no");
		  request.setAttribute("no", no);
		  request.setAttribute("main_jsp", "../board/freeboard_delete.jsp");
		  
		  return "../main/main.jsp"; 
	  }
	  @RequestMapping("board/freeboard_delok.do")
	  public String freeboard_delete_ok(HttpServletRequest request,HttpServletResponse response)
	  {
		  
		  String pwd=request.getParameter("pwd");
		  String no=request.getParameter("no");
		  
		  
		  BoardDAO dao=BoardDAO.newInstance();
		  
		  boolean bCheck=dao.freeboardDelete(Integer.parseInt(no), pwd);
		  
		  request.setAttribute("bCheck", bCheck);
		  return "../board/freeboard_delok.jsp";// list.jsp , history.back()
	  }
	  
	  @RequestMapping("freeboard/reply_insert.do")
	  public String reply_insert(HttpServletRequest request,HttpServletResponse response)
	  {
		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex) {}
		  
		  //사용자가 보내준 값을 받는다
		  String bno=request.getParameter("bno");
		  String type=request.getParameter("type");
		  String msg=request.getParameter("msg");
		  
		  HttpSession session=request.getSession();
		  String id=(String)session.getAttribute("id");
		  String name=(String)session.getAttribute("name");
		  
		  //묶어서 DAO전송
		  ReplyVO vo=new ReplyVO();
		  vo.setBno(Integer.parseInt(bno));
		  vo.setId(id);
		  vo.setName(name);
		  vo.setType(Integer.parseInt(type));
		  vo.setMsg(msg);
		  //이동 댓글이 올라간다
		  BoardDAO dao=BoardDAO.newInstance();
		  //댓글 추가 메소드
		  dao.replyInsert(vo);
		  
		  return "redirect:../freeboard/detail.do?no="+bno;

	  }
	  
	  @RequestMapping("freeboard/reply_delete.do")
	  public String reply_delete(HttpServletRequest request,HttpServletResponse response)
	  {
		  //요청 데이터 받기
		  String no=request.getParameter("no"); // 댓글번호 (삭제 목적)
		  String bno=request.getParameter("bno");// 게시물 번호(해당 페이지로 이동)
		  
		  //DAO
		  BoardDAO dao=BoardDAO.newInstance();
		  //삭제 메소드 호출
		  dao.replyDelete(Integer.parseInt(no));
		  
		  return "redirect:../freeboard/detail.do?no="+bno;
	  }
	  
	  @RequestMapping("freeboard/reply_update.do")
	  public String reply_update(HttpServletRequest request,HttpServletResponse response)
	  {
		  
		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex) {}
		  
		  String no=request.getParameter("no");
		  String bno=request.getParameter("bno");
		  String msg=request.getParameter("msg");
		  
		  
		  BoardDAO dao=BoardDAO.newInstance();
		  
		  dao.replyUpdate(Integer.parseInt(no), msg);
		  
		  return "redirect:../freeboard/detail.do?no="+bno;
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

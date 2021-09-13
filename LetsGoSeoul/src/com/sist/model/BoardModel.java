package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		  // main으로 이동하지 않는 경우 (해당 JSP에서 결과값을 읽어 온다 : Ajax,다운로드) 
		  // 사용자가 보내주는 요청값 (페이지 번호)
		  String page=request.getParameter("page");
		  // 첫화면에서는 페이지를 선택할 수 없다 (디폴트)
		  /*
		   *    list.do?page= ==> page.equals("")
		   *    list.do       ==> page==null
		   *    list.do?page= 1 ==> page.eqauls("1")
		   */
		  if(page==null) // 첫페이지일 경우 
		  {
			  page="1";
		  }
		  // 해당페이지의 데이터를 가지고 온다(DAO)
		  BoardDAO dao=BoardDAO.newInstance();
		  int curpage=Integer.parseInt(page);
		  List<BoardVO> list=dao.freeboardListData(curpage);
		  int totalpage=dao.freeboardTotalPage();
		  // list.jsp로 전송 
		  request.setAttribute("curpage", curpage);// 현재 페이지
		  request.setAttribute("totalpage", totalpage);
		  request.setAttribute("list", list);
		  // 화면 출력 => include 대상 
		  request.setAttribute("main_jsp", "../board/freeboard.jsp");
		  return "../main/main.jsp";//메뉴/footer유지 
	  }
	@RequestMapping("board/freeboard_insert.do")
	  public String freeboard_insert(HttpServletRequest request,HttpServletResponse response)
	  {
		  // 입력창만 보여준다 
		  request.setAttribute("main_jsp", "../board/freeboard_insert.jsp");
		  return "../main/main.jsp";
	  }
	@RequestMapping("board/freeboard_insert_ok.do")
	  public String freeboard_insert_ok(HttpServletRequest request,HttpServletResponse response)
	  {
		  // 처리 
		  try
		  {
			  // 한글 변환 (디코딩)
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex) {}
		  // 데이터를 모아서 => DAO전송 (오라클에 추가한다)
		  String name=request.getParameter("name");
		  String subject=request.getParameter("subject");
		  String content=request.getParameter("content");
		  String pwd=request.getParameter("pwd");
		  
		  
		  BoardVO vo=new BoardVO();
		  vo.setName(name);
		  vo.setSubject(subject);
		  vo.setContent(content);
		  vo.setPwd(pwd);
		  
		  // DAO로 전송 
		  BoardDAO dao=BoardDAO.newInstance();
		  // 추가하는 메소드 호출 
		  dao.freeboardInsert(vo);
		  return "redirect:../board/freeboard.do";// 처리후에 => 목록을 보여준다 
	  }
	// 게시판 상세보기 
	  @RequestMapping("board/freeboard_detail.do")
	  public String freeboardDetail(HttpServletRequest request,HttpServletResponse response)
	  {
		  // 요청한 데이터 받기 (no)
		  String no=request.getParameter("no");
		  // FreeBoardDAO연결 => 데이터 얻기를 한다 
		  BoardDAO dao=BoardDAO.newInstance();
		  // 메소드 호출 
		  BoardVO vo=dao.freeboardDetailData(Integer.parseInt(no));
		  // 댓글 받기
		  List<ReplyVO> list=dao.replyListData(Integer.parseInt(no), 1);
		  request.setAttribute("list", list);
		  request.setAttribute("vo", vo);
		  request.setAttribute("main_jsp", "../freeboard/detail.jsp");
		  /*
		   *   ======================
		   *     고정 (메뉴) header
		   *   ======================
		   *   
		   *       사용자 요청에 따라 변경되는 영역 ==> 출력할 JSP를 넘겨준다 
		   *       request.setAttribute("main_jsp", "../freeboard/detail.jsp");
		   *   
		   *   ======================
		   *     고정 (footer)
		   *   ======================
		   */
		  return "../main/main.jsp";
	  }
	  @RequestMapping("board/freeboard_update.do")
	  public String freeboard_update(HttpServletRequest request,HttpServletResponse response)
	  {
		  // Model => Model(요청 => 응답:비지니스로직) => DAO,VO,Manager(포함) 
		  // 자바 코딩은 모두 Model이다 
		  // 데이터 읽기
		  String no=request.getParameter("no");
		  // DAO=>연결 
		  BoardDAO dao=BoardDAO.newInstance();
		  // FreeBoardVO값을 얻어온다 
		  BoardVO vo=dao.freeboardUpdateData(Integer.parseInt(no));
		  // update.jsp전송 
		  request.setAttribute("vo", vo);
		  request.setAttribute("main_jsp", "../board/freeboard_update.jsp");
		  return "../main/main.jsp";
	  }
	  @RequestMapping("board/freeboard_upok.do")
	  public String freeboard_update_ok(HttpServletRequest request,HttpServletResponse response)
	  {
		  // 스프링에서는 @RestController => 자바스크립트 전송이 가능 (자바스크립트 전송 불가능)
		  // 수정하는 데이터를 받는다 
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
		  // 메소드 호출 
		  boolean bCheck=dao.freeboardUpdate(vo);
		  // 답변 , 수정 , 추가 => 오라클에 있는 데이터 조절 
		  request.setAttribute("bCheck", bCheck);
		  request.setAttribute("no", no);
		  return "../board/freeboard_upok.jsp";//이동 2개 (비밀번호 틀릴경우/비밀번호 맞는 경우) 
	  }
	  @RequestMapping("board/freeboard_delete.do")
	  public String freeboard_delete(HttpServletRequest request,HttpServletResponse response)
	  {
		  // request => 사용자 요청정보를 가지고 있다 => 톰캣이 설정을 한다 
		  // response => 서버의 응답 정보                => 톰캣이 아이피를 찾아서 =.> 해당 브라우저로 전송
		  // 요청 : 어떤 데이터를 보낼 것인지?   delete.do?no=${}
		  String no=request.getParameter("no");
		  request.setAttribute("no", no);
		  request.setAttribute("main_jsp", "../board/freeboard_delete.jsp");
		  // include => delete.jsp,main.jsp가 request를 공유할 수 있다 (필요한 JSP에서 request를 사용한다)
		  return "../main/main.jsp"; // 메뉴/footer가 없어진다 
	  }
	  @RequestMapping("board/freeboard_delok.do")
	  public String freeboard_delete_ok(HttpServletRequest request,HttpServletResponse response)
	  {
		  // 보여주는 화면 => list
		  
		  // 리다이렉트는 이미 화면이 만들어져있다면 
		  // 새로운 화면 => forward
		  // Ajax => 해당 jsp만 실행 
		  // _ok (처리) => 처리만 한다 (화면에 출력하지 않는다) => redirect
		  
		  // 요청값을 받는다 
		  String pwd=request.getParameter("pwd");
		  String no=request.getParameter("no");
		  
		  // pwd,no => 삭제 요청( DAO )
		  BoardDAO dao=BoardDAO.newInstance();
		  // 메소드 호출 
		  boolean bCheck=dao.freeboardDelete(Integer.parseInt(no), pwd);
		  // 결과값을 delete_ok.jsp 
		  request.setAttribute("bCheck", bCheck);
		  return "../board/freeboard_delok.jsp";// list.jsp , history.back()
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

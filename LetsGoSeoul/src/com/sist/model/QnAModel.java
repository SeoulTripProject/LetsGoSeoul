/*package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.QnADAO;
import com.sist.vo.QnAVO;

@Controller
public class QnAModel {
	@RequestMapping("qna/qna_main.do")
	public String main_main(HttpServletRequest request,HttpServletResponse response)
	{
		
		return "../main/main.jsp";
	}
	@RequestMapping("qna/qna.do")
	  public String qna_list(HttpServletRequest request,HttpServletResponse response)
	  {
		QnADAO dao=new QnADAO();

		String page=request.getParameter("page");
		if(page==null)
		{
			page="1";
		}
		int curpage=Integer.parseInt(page);
		List<QnAVO> list=dao.qnaListData(curpage);
		int totalpage=dao.qnaTotalPage();
		
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

		  request.setAttribute("main_jsp", "../qna/qna.jsp");
		  return "../main/main.jsp";
	  }
	@RequestMapping("qna/qna_insert.do")
	  public String qna_insert(HttpServletRequest request,HttpServletResponse response)
	  {

		  request.setAttribute("main_jsp", "../qna/qna_insert.jsp");
		  return "../main/main.jsp";
	  }
	@RequestMapping("qna/qna_insert_ok.do")
	  public String qna_insert_ok(HttpServletRequest request,HttpServletResponse response)
	  {
	
		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex) {}

		  String name=request.getParameter("name");
		  String subject=request.getParameter("subject");
		  String content=request.getParameter("content");
		  String pwd=request.getParameter("pwd");
		  String group_no=request.getParameter("group_no");
		  String type=request.getParameter("type");
		  
		  
		  QnAVO vo=new QnAVO();
		  vo.setName(name);
		  vo.setSubject(subject);
		  vo.setContent(content);
		  vo.setPwd(pwd);
		  

		  QnADAO dao=QnADAO.newInstance();
	
		  dao.qnaInsert(vo);
		  return "redirect:../qna/qna.do";
	  }

	  @RequestMapping("qna/qna_detail.do")
	  public String qnaDetail(HttpServletRequest request,HttpServletResponse response)
	  {

		  String no=request.getParameter("no");

		  QnADAO dao=QnADAO.newInstance();

		  QnAVO vo=dao.qnaDetailData(Integer.parseInt(no));

		  //List<QReplyVO> list=dao.QReplyListData(Integer.parseInt(no));
		  //request.setAttribute("list", list);
		  request.setAttribute("vo", vo);
		  request.setAttribute("main_jsp", "../qna/qna_detail.jsp");
		  
		  return "../main/main.jsp";
	  }
	  @RequestMapping("qna/qna_update.do")
	  public String qna_update(HttpServletRequest request,HttpServletResponse response)
	  {
		  
		  String no=request.getParameter("no");

		  QnADAO dao=QnADAO.newInstance();
	
		  QnAVO vo=dao.qnaUpdateData(Integer.parseInt(no));
	
		  request.setAttribute("vo", vo);
		  request.setAttribute("main_jsp", "../qna/qna_update.jsp");
		  return "../main/main.jsp";
	  }
	  @RequestMapping("qna/qna_upok.do")
	  public String qna_update_ok(HttpServletRequest request,HttpServletResponse response)
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
		  
		  QnAVO vo=new QnAVO();
		  vo.setNo(Integer.parseInt(no));
		  vo.setName(name);
		  vo.setSubject(subject);
		  vo.setContent(content);
		  vo.setPwd(pwd);
		  
		  QnADAO dao=QnADAO.newInstance();

		  boolean bCheck=dao.qnaUpdate(vo);

		  request.setAttribute("bCheck", bCheck);
		  request.setAttribute("no", no);
		  return "../qna/qna_upok.jsp";
	  }
	  @RequestMapping("qna/qna_delete.do")
	  public String qna_delete(HttpServletRequest request,HttpServletResponse response)
	  {
		  
		  String no=request.getParameter("no");
		  request.setAttribute("no", no);
		  request.setAttribute("main_jsp", "../qna/qna_delete.jsp");
		  
		  return "../main/main.jsp"; 
	  }
	  @RequestMapping("qna/qna_delok.do")
	  public String qna_delete_ok(HttpServletRequest request,HttpServletResponse response)
	  {
		  
		  String pwd=request.getParameter("pwd");
		  String no=request.getParameter("no");
		  
		  
		  QnADAO dao=QnADAO.newInstance();
		  
		  boolean bCheck=dao.qnaDelete(Integer.parseInt(no), pwd);
		  
		  request.setAttribute("bCheck", bCheck);
		  return "../qna/qna_delok.jsp";// list.jsp , history.back()
	  }
	  
	/*  @RequestMapping("qna/qna_reply_insert.do")
	  public String reply_insert(HttpServletRequest request,HttpServletResponse response)
	  {
		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex) {}
		  

		  String qno=request.getParameter("qno");
		  String msg=request.getParameter("msg");
		  
		  HttpSession session=request.getSession();
		  String id=(String)session.getAttribute("id");
		  String name=(String)session.getAttribute("name");
		  

		  QReplyVO vo=new QReplyVO();
		  vo.setQno(Integer.parseInt(qno));
		  vo.setId(id);
		  vo.setName(name);
		  vo.setMsg(msg);

		  QnADAO dao=QnADAO.newInstance();

		  dao.QReplyInsert(vo);
		  
		  return "redirect:../qna/qna_detail.do?no="+qno;

	  }
	  
	  @RequestMapping("qna/qna_reply_delete.do")
	  public String reply_delete(HttpServletRequest request,HttpServletResponse response)
	  {

		  String no=request.getParameter("no"); 
		  String qno=request.getParameter("qno");
		  

		  QnADAO dao=QnADAO.newInstance();

		  dao.QReplyDelete(Integer.parseInt(no));
		  
		  return "redirect:../qna/qna_detail.do?no="+qno;
	  }
	  
	  @RequestMapping("qna/qna_reply_update.do")
	  public String reply_update(HttpServletRequest request,HttpServletResponse response)
	  {
		  
		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex) {}
		  
		  String no=request.getParameter("no");
		  String qno=request.getParameter("qno");
		  String msg=request.getParameter("msg");
		  
		  
		  QnADAO dao=QnADAO.newInstance();
		  
		  dao.QReplyUpdate(Integer.parseInt(no), msg);
		  
		  return "redirect:../qna/qna_detail.do?no="+qno;
	  }
}*/

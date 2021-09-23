package com.sist.model;

import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;
import com.sist.vo.ZipcodeVO;

@Controller
public class MemberModel {
	  
	  @RequestMapping("member/join.do")
	  public String member_join(HttpServletRequest request,HttpServletResponse response)
	  {
		  request.setAttribute("main_jsp", "../member/join.jsp");
		  return "../main/main.jsp";
	  }

	  @RequestMapping("member/idcheck.do")
	  public String member_idcheck(HttpServletRequest request,HttpServletResponse response)
	  {
		  
		  String id=request.getParameter("id"); 	 
		  MemberDAO dao=MemberDAO.newInstance();
		  int count=dao.memberidCheck(id);
		  request.setAttribute("count", count);
		  return "../member/idcheck_result.jsp";
	  }
	  @RequestMapping("member/postfind.do")
	  public String member_postfind(HttpServletRequest request,HttpServletResponse response)
	  {

		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex) {}

		  String dong=request.getParameter("dong");

		  MemberDAO dao=MemberDAO.newInstance(); 
		  List<ZipcodeVO> list=dao.postfind(dong);
		  int count=dao.postfindCount(dong);

		  request.setAttribute("list", list);
		  request.setAttribute("count", count);
		  return "../member/postfind_result.jsp";
	  }

	  @RequestMapping("member/join_ok.do")
	  public String member_join_ok(HttpServletRequest request,HttpServletResponse response)
	  {
		  System.out.println("OK");

		  try
		  {
			  request.setCharacterEncoding("UTF-8");
		  }catch(Exception ex) {}
		  String id=request.getParameter("id");
		  String pwd=request.getParameter("pwd");
		  String name=request.getParameter("name");
		  String sex=request.getParameter("sex");
		  String birthday=request.getParameter("birthday");
		  String email=request.getParameter("email");
		  String post1=request.getParameter("post1");
		  String post2=request.getParameter("post2");
		  String addr1=request.getParameter("addr1");
		  String addr2=request.getParameter("addr2");
		  String tel1=request.getParameter("tel1");
		  String tel2=request.getParameter("tel2");
		  String type=request.getParameter("type");
		  
		  MemberVO vo=new MemberVO();
		  vo.setId(id);
		  vo.setPwd(pwd);
		  vo.setName(name);
		  vo.setSex(sex);
		  vo.setBirthday(birthday);
		  vo.setPost(post1+"-"+post2);
		  vo.setEmail(email);
		  vo.setAddr1(addr1);
		  vo.setAddr2(addr2);
		  vo.setTel(tel1+"-"+tel2);
		  vo.setType(type);

		  MemberDAO dao=MemberDAO.newInstance();
		  dao.memberJoinInsert(vo);
		  return "redirect:../main/main.do";

	  }
	  @RequestMapping("member/login.do")
	  public String member_login(HttpServletRequest request,HttpServletResponse response)
	  {
		  request.setAttribute("main_jsp", "../member/login.jsp");
		  return "../main/main.jsp";
	  }
	  @RequestMapping("member/login_result.do")
	  public String member_login_result(HttpServletRequest request,HttpServletResponse response)
	  {

		  String id=request.getParameter("id");
		  String pwd=request.getParameter("pwd");

		  MemberDAO dao=MemberDAO.newInstance();

		  String result=dao.isLogin(id, pwd);
		  if(!(result.equals("NOID")|| result.equals("NOPWD")))
		  {
			  HttpSession session=request.getSession(); 

			  StringTokenizer st=new StringTokenizer(result,"|");
			  String name=st.nextToken();
			  String admin=st.nextToken();
			  
			  session.setAttribute("id", id);
			  session.setAttribute("admin", admin);
			  session.setAttribute("name", name);
			  result="OK";
		  }
		  request.setAttribute("result", result);
		  return "../member/login_result.jsp";
	  }

	  @RequestMapping("member/logout.do")
	  public String member_logout(HttpServletRequest request,HttpServletResponse response)
	  {
		  HttpSession session=request.getSession();
		  session.invalidate(); 
		  return "redirect:../main/main.do";
	  }
	}









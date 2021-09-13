<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
	try
	{
		request.setCharacterEncoding("UTF-8");	
	}catch(Exception ex){}
	String fno=request.getParameter("fno");
	String msg=request.getParameter("msg");
	// id, name=> session
	// 이동 -> food_detail로 이동
%>
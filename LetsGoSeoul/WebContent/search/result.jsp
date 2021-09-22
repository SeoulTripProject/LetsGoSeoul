<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.sist.dao.*, com.sist.vo.*, com.sist.model.*"%>
<%
    try
    {
    	request.setCharacterEncoding("UTF-8");
    }catch(Exception ex){}
    String cfd=request.getParameter("cfd");
    if(cfd==null)
    	cfd="all";
    CultureDAO dao=new CultureDAO();
    ArrayList<CultureVO> list=dao.cultureFindData(cfd);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
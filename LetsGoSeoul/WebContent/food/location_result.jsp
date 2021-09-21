<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="col-md-4">
	<div class="single-defination">
		<c:forEach var="vo" items="${list }">
			 <div class="location-img">
			       <img src="${vo.poster }" alt="">
			 </div>
			 <div class="location-details">
			 <a href="../food/food_main.jsp?no=${vo.no }" class="location-btn"><p>${vo.rname }</p></a>
			 </div>
		</c:forEach>
	</div>
</div> 
</body>
</html>
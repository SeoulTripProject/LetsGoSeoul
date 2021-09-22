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
		<%-- <c:forEach var="vo" items="${list }">
<div class="row">
	<div class="single-defination">
			 <div class="location-img">
			       <img src="${vo.poster }" alt="">
			 </div>
			 <div class="location-details">
			 <a href="../food/food_detail.do?no=${vo.no }" class="location-btn"><p>${vo.rname }</p></a>
			 </div>
	</div>
</div> 
		</c:forEach> --%>
  <c:forEach var="vo" items="${list }" varStatus="s">
   <div style="width:120px; height:120px; border:1px solid white; float:left;">
        <a href="../food/food_detail.do?no=${vo.no }">
          <img src="${vo.poster }" style="width:100px;height:95px">
        </a>
        <p class="text-left">${vo.rname }</p>
   </div>
  </c:forEach>
</body>
</html>
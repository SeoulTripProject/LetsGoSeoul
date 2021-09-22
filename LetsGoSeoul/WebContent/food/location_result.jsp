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
   <c:if test="${s.index%3==0 }">
    <div style="width:160px;height:160px float:left" class="inline">
      <td>
        <img src="${vo.poster }" alt="" style="width:160px;height:150px">
      </td>
      <td>
        <a href="../food/food_detail.do?no=${vo.no }" class="location-btn"><p>${vo.rname }</p></a>
      </td>
    </div>
   </c:if>
   <c:if test="${s.index%3!=0 }">
    <div style="width:160px;height:160px; float:left" class="inline">
      <td style="">
        <img src="${vo.poster }" alt="" style="width:160px;height:150px">
      </td>
      <td>
        <a href="../food/food_detail.do?no=${vo.no }" class="location-btn"><p>${vo.rname }</p></a>
      </td>
    </div>
   </c:if>
  </c:forEach>
</body>
</html>
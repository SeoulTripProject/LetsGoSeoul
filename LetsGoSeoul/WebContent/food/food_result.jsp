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
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <!-- Section Tittle -->
                        <div class="section-tittle text-center mb-80">
                            <h2>Recommend By ${menu }</h2>
                        </div>
                    </div>
                </div>
             <div class="row">
                <c:forEach var="vo" items="${list }" varStatus="s">
                    <div class="col-3 inline">

             				<c:if test="${s.index%4==0 }">
	                            <div class="location-img inline">
	                                <img src="${vo.poster }" style="width:250px;height:176px;">
	                            </div>
	                            <div class="location-details">
	                                <p>${vo.rname }</p>
	                                <a href="../food/food_detail.do?no=${vo.no }" class="location-btn"><i class="ti-plus"></i>Detail</a>
	                            </div>
             				</c:if>
             				<c:if test="${s.index%4!=0 }">
	                            <div class="location-img inline">
	                                <img src="${vo.poster }" style="width:250px;height:176px;">
	                            </div>
	                            <div class="location-details">
	                                <p>${vo.rname }</p>
	                                <a href="../food/food_detail.do?no=${vo.no }" class="location-btn"><i class="ti-plus"></i>Detail</a>
	                            </div>
             				</c:if>

                    </div>
                  </c:forEach>
             </div>
        </div>
</body>
</html>
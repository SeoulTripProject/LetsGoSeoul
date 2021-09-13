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
        <!-- Hero Start-->
        <div class="hero-area3 hero-overly2 d-flex align-items-center ">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-xl-8 col-lg-9">
                        <div class="hero-cap text-center pt-50 pb-20">
                            <h2>Restaurant List</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Hero End -->
        <!-- listing Area Start -->
        <div class="listing-area pt-120 pb-120">
            <div class="container">
                <div class="row">
                    <!-- Right content -->
                    <div class="col-xl-9 col-lg-9 col-md-6">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="count mb-35">
                                    <span> Seoul Restaurants </span>
                                </div>
                            </div>
                        </div>
                        <!-- listing Details Stat-->
                        <div class="listing-details-area">
                            <div class="container">
                                <div class="row">
                                  <c:forEach var="vo" items="${list }" varStatus="s">
                                    <div class="col-lg-6 ">
                                        <div class="single-listing mb-30">
                                            <div class="list-img">
                                                <img src="${vo.poster }" style="width:360px;height:251px">
                                                <!-- <span>Open</span> -->
                                            </div>
                                            <div class="list-caption">
                                                <span>Open</span>
                                                <h3><a href="../stay/food_list.do?no=${no}">${vo.sname }</a></h3>
                                                <p>700/D, Kings road, Green lane, 85/ London</p>
                                                <div class="list-footer">
                                                    <ul>
                                                        <li>+10 278 367 9823</li>
                                                        <li>contact@midnight.com</li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                  </c:forEach>
                                </div>
                            </div>
                        </div>
                        <!-- listing Details End -->
                        <!--Pagination Start  -->
                        <div class="pagination-area pt-70 text-center">
                            <div class="container">
                                <div class="row">
                                    <div class="col-xl-12">
                                        <div class="single-wrap d-flex justify-content-center">
                                            <nav aria-label="Page navigation example">
                                                <ul class="pagination justify-content-start">
                                                         <c:if test="${curpage>BLOCK }">
												          <li class="page-item active"><a class="page-link" href="../recipe/list.do?page=${startPage-1 }">&laquo; Previous</a></li>
												         </c:if>
												           <c:forEach var="i" begin="${startPage }" end="${endPage }">
												           	<c:if test="${curpage==i }">
													           <c:set var="ss" value="class=current"/>
												           	</c:if>
												           	<c:if test="${curpage!=i }">
													           <c:set var="ss" value=""/>
												           	</c:if>
												          	<li class="page-item active" ${ss }><a class="page-link" href="../recipe/list.do?page=${i }">${i }</a></li>
												           </c:forEach>
												           <c:if test="${endPage<totalpage }">
												          <li class="page-item active"><a class="page-link" href="../recipe/list.do?page=${endPage+1 }">Next &raquo;</a></li>
												           </c:if>
                                                <li class="page-item"><a class="page-link" href="#"><span class="ti-angle-right"></span></a></li>
                                                </ul>
                                            </nav>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--Pagination End  -->
                    </div>
                </div>
            </div>
        </div>
        <!-- listing-area Area End -->
</body>
</html>
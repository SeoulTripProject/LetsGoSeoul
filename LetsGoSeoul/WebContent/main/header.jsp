<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	// 로그아웃 처리
	$('#logoutBtn').click(function(){
		location.href="../member/logout.do";
	})
})
</script>
</head>
<body>
		<div class="header-area header-transparent">
            <div class="main-header">
               <div class="header-bottom  header-sticky">
                    <div class="container-fluid">
                        <div class="row align-items-center">
                            <!-- Logo -->
                            <div class="col-xl-1 col-lg-1 col-md-1">
                                <div class="logo">
                                  <a href="../main/main.do"><img src="../assets/img/logo/tLogo.png" alt=""></a>
                                </div>
                            </div>
                            <div class="col-xl-11 col-lg-11 col-md-8">
                                <!-- Main-menu -->
                                <div class="main-menu f-right d-none d-lg-block">
                                    <nav>
                                        <ul id="navigation">                                                                                                                                     
                                            <li><a href="../attraction/attraction_main.do">Attractions</a>
                                            	<ul class="submenu">
                                                    <li><a href="../attraction/landmark.do">Landmark</a></li>
                                                    <li><a href="../attraction/palace.do">Palace</a></li>
                                                    <li><a href="../attraction/historic.do">historic Place</a></li>
                                                    <li><a href="../attraction/old.do">Old Store</a></li>
                                                    <li><a href="../attraction/museum.do">Museum</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="../nature/main.do">Nature</a></li>
                                            <li><a href="../culture/culture_main.do">Culture</a>
                                                <ul class="submenu">
                                                    <li><a href="../culture/exhibition.do">Exhibition</a></li>
                                                    <li><a href="../culture/play.do">Play</a></li>
                                                </ul>
                                            </li><li><a href="../stay/stay_main.do">Stay</a>
                                                <ul class="submenu">
                                                    <li><a href="../stay/hotel.do">Hotel</a></li>
                                                    <li><a href="../stay/ghouse.do">GuestHouse</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="../food/food_main.do">Restaurants</a>
                                                <ul class="submenu">
                                                    <li><a href="../food/food_list.do">Restaurant List</a></li>
                                                    <li><a href="../food/food_area.do">Explore By Area</a></li>
                                                    <li><a href="../food/food_recommend.do">Recommendation</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="#">Board</a>
                                                <ul class="submenu">
                                                    <li><a href="../notice/notice_list.do">Notice</a></li>
                                                    <li><a href="../board/freeboard.do">FreeBoard</a></li>
                                                    <li><a href="../board/weather.do">Weather</a></li>
                                                    <li><a href="../qna/qna.do">Q&A</a></li>
                                                </ul>
                                            </li>
                                            
                                            <c:if test="${sessionScope.id!=null }"> <%--로그인이 된 상태 --%>
                                            <c:if test="${admin=='n' }">
                                            <li><a href="#">My Page</a>
                                                <ul class="submenu">
                                                    <li><a href="blog.html">Unregister</a></li>
                                                    <li><a href="blog.html">WishList</a></li>
                                                </ul>
                                            </li>
                                            </c:if>
                                            <c:if test="${admin=='y' }">
                                            <li><a href="#">Admin Page</a>
                                                <ul class="submenu">
                                                    <li><a href="blog.html">Reservation</a></li>
                                                    <li><a href="blog.html">WishList</a></li>
                                                </ul>
                                            </li>
                                            </c:if>
                                            </c:if>
                                            <c:if test="${sessionScope.id==null }"> <%-- 로그인이 안된 상태 --%>
                                            <li class="login"><a href="../member/login.do">
                                              <i class="ti-user"></i>Sign in</a>
                                            </li>
                                            <li class="join"><a href="../member/join.do">
                                                <i class="ti-user"></i>Register</a>
                                            </li>
                                            </c:if>
                                            <c:if test="${sessionScope.id!=null }"> <%-- 로그인이 된 상태 --%>
										      <li class="login">
										        <i class="ti-user"></i><a>
										           ${sessionScope.name } (${sessionScope.admin=='y'?"ADMIN":"USER" }) 
										          	 is now logging in!!
										        </a>
										        </li>
										          <li class="join">
										            <input type=button id="logoutBtn" value="logout" class="btn btn-sm btn-danger">
										       </li>
									      </c:if>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                            <!-- Mobile Menu -->
                            <div class="col-12">
                                <div class="mobile_menu d-block d-lg-none"></div>
                            </div>
                        </div>
                    </div>
               </div>
            </div>
       </div>
</body>
</html>
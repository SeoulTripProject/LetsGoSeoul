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
        <div class="hero-area2  slider-height2 hero-overly2 d-flex align-items-center ">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center pt-50">
                            <h2>Culture</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Hero End -->
        <div class="popular-location section-padding30">
            <div class="container">
            	<div class="row">
                    <div class="col-lg-12">
                        <div class="section-tittle text-center mb-80">
                            <h2>Exhibition</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                   <c:forEach var="evo" items="${eList }">
                    <div class="col-4">
                        <div class="single-location mb-30 inline">
                            <div class="location-img inline">
                                <img src="${evo.poster }" style="width:360px;height:286px">
                            </div>
                            <div class="location-details">
                                <p>${evo.title }</p>
                                <a href="../culture/exhibition_detail.do?no=${evo.no }" class="location-btn"><i class="ti-plus"></i>Location</a>
                            </div>
                        </div>
                    </div>
                  </c:forEach>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-tittle text-center mb-80">
                            <h2>Play</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                   <c:forEach var="vo" items="${list }">
                    <div class="col-4">
                        <div class="single-location mb-30 inline">
                            <div class="location-img inline">
                                <img src="${vo.poster }" style="width:360px;height:286px">
                            </div>
                            <div class="location-details">
                                <p>${vo.title }</p>
                                <a href="../culture/play_detail.do?no=${vo.no }" class="location-btn"><i class="ti-plus"></i>Location</a>
                            </div>
                        </div>
                    </div>
                  </c:forEach>
                </div>
            </div>
        </div>
</body>
</html>
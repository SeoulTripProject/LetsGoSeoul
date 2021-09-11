<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="manifest" href="site.webmanifest">
<link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">
<link rel="stylesheet" href="../assets/css/bootstrap.min.css">
<link rel="stylesheet" href="../assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="../assets/css/slicknav.css">
<link rel="stylesheet" href="../assets/css/flaticon.css">
<link rel="stylesheet" href="../assets/css/animate.min.css">
<link rel="stylesheet" href="../assets/css/magnific-popup.css">
<link rel="stylesheet" href="../assets/css/fontawesome-all.min.css">
<link rel="stylesheet" href="../assets/css/themify-icons.css">
<link rel="stylesheet" href="../assets/css/slick.css">
<link rel="stylesheet" href="../assets/css/nice-select.css">
<link rel="stylesheet" href="../assets/css/style.css">
</head>
<body>

        <div class="hero-area2  slider-height2 hero-overly2 d-flex align-items-center ">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center pt-50">
                            <h2>Stay</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="popular-location section-padding30">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-tittle text-center mb-80">
                            <h2>Popular Hotel</h2>
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
                                <p>${vo.sname }</p>
                                <a href="#" class="location-btn"><i class="ti-plus"></i>Location</a>
                            </div>
                        </div>
                    </div>
                  </c:forEach>
                </div>
            </div>
        </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                            <h2>Hotel</h2>
                        </div>
                        <!--Hero form -->
                        <form action="#" class="search-box search-box2">
                            <div class="input-form">
                                <input type="text" placeholder="What are you looking for?">
                            </div>
                            <div class="select-form">
                                <div class="select-itms">
                                    <select name="select" id="select1">
                                        <option value="">All Catagories</option>
                                        <option value="">Catagories One</option>
                                        <option value="">Catagories Two</option>
                                        <option value="">Catagories Three</option>
                                        <option value="">Catagories Four</option>
                                    </select>
                                </div>
                            </div>
                            <!-- Search box -->
                            <div class="search-form">
                                <a href="#">Search</a>
                            </div>	
                        </form>	
                    </div>
                </div>
            </div>
        </div>
        <!--Hero End -->
        <!-- listing Area Start -->
        <div class="listing-area pt-120 pb-120">
            <div class="container">
                <div class="row">
                    <div class="col-xl-8 col-lg-8 col-md-6">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="count mb-35">
                                    <span>5432 Listings are available</span>
                                </div>
                            </div>
                        </div>
                        <!-- listing Details Stat-->
                        <div class="listing-details-area">
                            <div class="container">
                                <div class="row">
                                  <%-- <c:forEach var="" items="">
                                    <div class="col-lg-6 ">
                                        <div class="single-listing mb-30">
                                            <div class="list-img">
                                                <img src="assets/img/gallery/list1.png" alt="">
                                                <!-- <span>Open</span> -->
                                            </div>
                                            <div class="list-caption">
                                                <span>Open</span>
                                                <h3><a href="listing_details.html">Saintmartine</a></h3>
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
                                  </c:forEach> --%>
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
                                                    <li class="page-item active"><a class="page-link" href="#">01</a></li>
                                                    <li class="page-item"><a class="page-link" href="#">02</a></li>
                                                    <li class="page-item"><a class="page-link" href="#">03</a></li>
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
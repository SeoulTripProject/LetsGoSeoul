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
    <main>

        <!-- Hero Start-->
        <div class="hero-area3 hero-overly2 d-flex align-items-center ">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-xl-8 col-lg-9">
                        <div class="hero-cap text-center pt-50 pb-20">
                            <h2>Our Listing</h2>
                        </div>
                        <!--Hero form -->
                        <form action="#" class="search-box search-box2">
                            <div class="input-form">
                                <input type="text" placeholder="What are you looking for?">
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
        <section class="blog_area section-padding">
            <div class="container">
                <div class="row">
                  <div class="button-group-area mt-40">
                    <div class="col-lg-8 mb-4 mb-lg-0">
                        <div class="blog_left_sidebar">
                            <c:forEach var="vo" items="${list }">
                            <article class="blog_item">
                                <div class="blog_details" style="width:1000px;margin-left:10%;margin-right:auto;"> 
                                   <h2>${vo.title }</h2>
                                    </a>
                                    <ul class="blog-info-link">
                                        <li><i class="fa fa-user"></i>${vo.author }</li>
                                    	<li><i class="fa fa-check"></i>${vo.description }</li>
                                    </ul>
                                </div>
                              </article>
                             </c:forEach>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- listing-area Area End -->

    </main>
</body>
</html>
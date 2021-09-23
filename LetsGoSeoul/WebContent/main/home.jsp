<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Seoul Trip</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="manifest" href="site.webmanifest">
<link rel="shortcut icon" type="image/x-icon" href="../../assets/img/favicon.ico">
<link rel="stylesheet" href="../../assets/css/bootstrap.min.css">
<link rel="stylesheet" href="../../assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="../../assets/css/slicknav.css">
<link rel="stylesheet" href="../../assets/css/flaticon.css">
<link rel="stylesheet" href="../../assets/css/animate.min.css">
<link rel="stylesheet" href="../../assets/css/magnific-popup.css">
<link rel="stylesheet" href="../../assets/css/fontawesome-all.min.css">
<link rel="stylesheet" href="../../assets/css/themify-icons.css">
<link rel="stylesheet" href="../../assets/css/slick.css">
<link rel="stylesheet" href="../../assets/css/nice-select.css">
<link rel="stylesheet" href="../../assets/css/style.css">
<style type="text/css">
.slider-area {
	background-image: url(../assets/img/hero/namsan.jpg);
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		url:'../search/result.jsp',
		type:'post',
		success:function(res)
		{
			$('.print').html(res);
		}
	})
	$('#btn').click(function(){
		let cfd=$('#cfd').val();
		if(cfd.trim()=="")
		{
			$('#cfd').focus();
			return;
		}
		$.ajax({
			url:'../search/result.jsp',
			type:'post',
			data:{"cfd":cfd},
			success:function(res)
			{
				$('.print').html(res)
			}
		})
	})
})
</script>
</head>
<body>
        <!-- Hero Area Start-->
        <div class="slider-area hero-overly">
            <div class="single-slider hero-overly  slider-height d-flex align-items-center subscribe-area">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-xl-6 col-lg-8">
                            <!-- Hero Caption -->
                            <div class="hero__caption">
                                <span>Welcome to Seoul</span>
                                <h1>Discover Great Places</h1>
                            </div>
                            <!--Hero form -->
					        <form action="#" class="search-box input">
                            <div class="input-form">
                                <input type="text" placeholder="What are you looking for?" class="input" id="cfd">
                            </div>
                            <div class="search-form" id="btn">
                                <a href="#">Send Now</a>
                            </div>	
                            </form>	
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Hero Area End-->
        <!-- Popular Locations Start -->
        <div class="popular-location section-padding30">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <!-- Section Tittle -->
                        <div class="section-tittle text-center mb-80">
                            <span>Most visited places</span>
                            <h2>Popular Locations</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="single-location mb-30">
                            <div class="location-img">
                                <img src="../assets/img/gallery/attra.jpg" style="width:360px;height:286px">
                            </div>
                            <div class="location-details">
                                <p>Attractions</p>
                                <a href="../attraction/attraction_main.do" class="location-btn">243 <i class="ti-plus"></i> Location</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="single-location mb-30">
                            <div class="location-img">
                                <img src="../assets/img/gallery/nature.jpg" style="width:360px;height:286px">
                            </div>
                            <div class="location-details">
                                <p>Nature</p>
                                <a href="../nature/main.do" class="location-btn">107 <i class="ti-plus"></i> Location</a>
                            </div>
                        </div>
                    </div> 
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="single-location mb-30">
                            <div class="location-img">
                                <img src="../assets/img/gallery/exhibit.jpg" style="width:360px;height:286px">
                            </div>
                            <div class="location-details">
                                <p>Exhibition</p>
                                <a href="../culture/exhibition.do" class="location-btn">24 <i class="ti-plus"></i> Location</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="single-location mb-30">
                            <div class="location-img">
                                <img src="../assets/img/gallery/perf.jpg" style="width:360px;height:286px">
                            </div>
                            <div class="location-details">
                                <p>Performances</p>
                                <a href="../culture/play.do" class="location-btn">28 <i class="ti-plus"></i> Location</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="single-location mb-30">
                            <div class="location-img">
                                <img src="../assets/img/gallery/stay.jpg" style="width:360px;height:286px">
                            </div>
                            <div class="location-details">
                                <p>Stay</p>
                                <a href="../stay/stay_main.do" class="location-btn">582 <i class="ti-plus"></i> Location</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="single-location mb-30">
                            <div class="location-img">
                                <img src="../assets/img/gallery/food.jpg" style="width:360px;height:286px">
                            </div>
                            <div class="location-details">
                                <p>Restaurants</p>
                                <a href="../food/food_main.do" class="location-btn">5200 <i class="ti-plus"></i> Location</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- More Btn -->
                <div class="row justify-content-center">
                    <div class="room-btn pt-20">
                        <a href="catagori.html" class="btn view-btn1">View All Places</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Popular Locations End -->
        <!-- Services Area Start -->
        <div class="services-area pt-150 pb-150 section-bg" data-background="../assets/img/gallery/section_bg02.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <!-- Section Tittle -->
                        <div class="section-tittle section-tittle2 text-center mb-80">
                            <span>Easy to explore</span>
                            <h2>How It Works</h2>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-between">
                    <div class="col-lg-3 col-md-6">
                        <div class="single-services text-center mb-50">
                            <div class="services-icon">
                                <span class="flaticon-list"></span>
                            </div>
                            <div class="services-cap">
                                <h5><a href="#">1. Choose a Category</a></h5>
                                <p>incidid labore lore magna aliqua uisipsum suspendis loris.</p>
                            </div>
                            <!-- Shpape -->
                            <img class="shape1 d-none d-lg-block" src="../assets/img/icon/serices1.png" alt="">
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="single-services text-center mb-50">
                            <div class="services-icon">
                                <span class="flaticon-problem"></span>
                            </div>
                            <div class="services-cap">
                                <h5><a href="#">2. what you want</a></h5>
                                <p>incidid labore lore magna aliqua uisipsum suspendis loris.</p>
                            </div>
                            <img class="shape2 d-none d-lg-block" src="../assets/img/icon/serices2.png" alt="">
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="single-services text-center mb-50">
                            <div class="services-icon">
                                <span class="flaticon-respect"></span>
                            </div>
                            <div class="services-cap">
                                <h5><a href="#">3. Go out & Explore</a></h5>
                                <p>incidid labore lore magna aliqua uisipsum suspendis loris.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Services Area End -->
        <!-- Categories Area Start -->
        <div class="categories-area section-padding30">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <!-- Section Tittle -->
                        <div class="section-tittle text-center mb-80">
                            <span>We are offering for you</span>
                            <h2>Featured Categories</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="single-cat text-center mb-50">
                            <div class="cat-icon">
                                <span class="flaticon-bed"></span>
                            </div>
                            <div class="cat-cap">
                                <h5><a href="catagori.html">Leving Stay</a></h5>
                                <p>We explain everything about Seoul</p>
                                <a href="../stay/stay_main.do">View Details</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="single-cat text-center mb-50">
                            <div class="cat-icon">
                                <span class="flaticon-drink"></span>
                            </div>
                            <div class="cat-cap">
                                <h5><a href="catagori.html">Attraction</a></h5>
                                <p>We explain everything about Seoul</p>
                                <a href="../attraction/attraction_main.do">View Details</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="single-cat text-center mb-50">
                            <div class="cat-icon">
                                <span class="flaticon-home"></span>
                            </div>
                            <div class="cat-cap">
                                <h5><a href="catagori.html">Culture</a></h5>
                                <p>We explain everything about Seoul</p>
                                <a href="../culture/culture_main.do">View Details</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="single-cat text-center mb-50">
                            <div class="cat-icon">
                                <span class="flaticon-food"></span>
                            </div>
                            <div class="cat-cap">
                                <h5><a href="catagori.html">Resturent</a></h5>
                                <p>We explain everything about Seoul</p>
                                <a href="../food/food_main.do">View Details</a>
                            </div>
                        </div>
                    </div>
                 </div>
            </div>
        </div>
        <!-- Categories Area End -->
        <!-- Youtube -->
        <div class="testimonial-area testimonial-padding">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <!-- Section Tittle -->
                        <div class="section-tittle text-center mb-80">
                            <span>Introduce</span>
                            <h2>YOUTUBE</h2>
                        </div> 
                    </div>
                </div>
                <div class="row align-items-center">
                    <div class="col-lg-11 col-md-11">
                        <div class="h1-testimonial-active">
                            <!-- Single Testimonial -->
                            <div class="single-testimonial text-center">
                              <iframe width="850" height="350" src="https://www.youtube.com/embed/OgJJ9vYCvrM" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                            </div>
                            <!-- OgJJ9vYCvrM -->
                            <!-- Single Testimonial -->
                            <div class="single-testimonial text-center">
                              <iframe width="850" height="350" src="https://www.youtube.com/embed/EK0wlUAbtow" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                            </div>
                            
                            <!-- Single Testimonial -->
                            <div class="single-testimonial text-center">
                              <iframe width="850" height="350" src="https://www.youtube.com/embed/1S6p_bc2ViE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Testimonial End -->
        <!-- Blog Ara Start -->
        <div class="home-blog-area section-padding30">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <!-- Section Tittle -->
                        <div class="section-tittle text-center mb-70">
                            <span>Our blog</span>
                            <h2>News</h2>
                        </div> 
                    </div>
                </div>
                <div class="row">
                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
                      <c:forEach var="nvo" items="${nlist}">
                        <div class="single-team mb-30">
                            <div class="team-img">
                                <img src="../assets/img/gallery/home_blog1.png" alt="">
                            </div>
                            <div class="team-caption">
                                <span>${vo.title }</span>
                                <h3><a href="../news/news.jsp">${vo.description }</a></h3>
                                <p>${vo.author }</p>
                            </div>
                        </div>
                      </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <!-- Blog Ara End -->
</body>
</html>
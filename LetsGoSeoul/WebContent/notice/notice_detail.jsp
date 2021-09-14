<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.hero-area4 {
  background-image: url(../assets/img/hero/hero2.jpg);
  background-size: cover;
  background-repeat: no-repeat;
  min-height: 105px;
}
</style>
</head>
<body>
<!-- Hero Start-->
        <div class="hero-area4 slider-height2 hero-overly2 d-flex align-items-center">
        </div>
<!--Hero End -->
<!--================Blog Area =================-->
      <section class="blog_area single-post-area section-padding" style="margin-left:25%">
         <div class="container">
            <div class="row">
               <div class="col-lg-8 posts-list">
                  <div class="single-post">
                     <div class="blog_details">
                        <h2>${vo.subject }</h2>
                        <ul class="blog-info-link mt-3 mb-4">
                           <li><a href="#"><i class="fa fa-user"></i>${vo.name }</a></li>
                           <li><a href="#"><i class="fa fa-comments"></i>${vo.hit }</a></li>
                        </ul>
                        <p class="excert">${vo.content }</p>
                     </div>
                  </div>
                  <div class="navigation-top">
                     <div class="d-sm-flex justify-content-between text-center">
                        <p class="like-info"><span class="align-middle"><i class="fa fa-heart"></i></span> Lily and 4
                           people like this</p>
                        <div class="button-group-area mt-40">
                        <c:if test="${sessionScope.admin=='y' }">
                          <a href="#" class="genric-btn primary small">Edit</a>
                          <a href="#" class="genric-btn primary small">Delete</a>
                        </c:if>
                          <a href="../notice/notice_list.do" class="genric-btn primary small">List</a>
                        </div>
                     </div>
                     <div class="navigation-area">
                        <div class="row">
                           <div
                              class="col-lg-6 col-md-6 col-12 nav-left flex-row d-flex justify-content-start align-items-center">
                              <div class="thumb">
                                 <a href="#">
                                    <img class="img-fluid" src="assets/img/post/preview.png" alt="">
                                 </a>
                              </div>
                              <div class="arrow">
                                 <a href="#">
                                    <span class="lnr text-white ti-arrow-left"></span>
                                 </a>
                              </div>
                              <div class="detials">
                                 <p>Prev Post</p>
                                 <a href="#">
                                    <h4>Space The Final Frontier</h4>
                                 </a>
                              </div>
                           </div>
                           <div
                              class="col-lg-6 col-md-6 col-12 nav-right flex-row d-flex justify-content-end align-items-center">
                              <div class="detials">
                                 <p>Next Post</p>
                                 <a href="#"> 
                                    <h4>Telescopes 101</h4>
                                 </a>
                              </div>
                              <div class="arrow">
                                 <a href="#">
                                    <span class="lnr text-white ti-arrow-right"></span>
                                 </a>
                              </div>
                              <div class="thumb">
                                 <a href="#">
                                    <img class="img-fluid" src="assets/img/post/next.png" alt="">
                                 </a>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
             </div>
         </div>
      </section>
      <!--================ Blog Area end =================-->
</body>
</html>
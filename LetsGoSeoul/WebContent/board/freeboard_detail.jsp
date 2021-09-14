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
<!--================Blog Area =================-->
      <section class="blog_area single-post-area section-padding">
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
                          <a href="#" class="genric-btn primary small">Edit</a>
                          <a href="#" class="genric-btn primary small">Delete</a>
                          <a href="../board/freeboard.do" class="genric-btn primary small">List</a>
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
                  <div class="comments-area">
                     <h4>05 Comments</h4>
                     <div class="comment-list">
                        <div class="single-comment justify-content-between d-flex">
                           <div class="user justify-content-between d-flex">
                              <div class="thumb">
                                 <img src="assets/img/comment/comment_3.png" alt="">
                              </div>
                              <div class="desc">
                                 <p class="comment">
                                    Multiply sea night grass fourth day sea lesser rule open subdue female fill which them
                                    Blessed, give fill lesser bearing multiply sea night grass fourth day sea lesser
                                 </p>
                                 <div class="d-flex justify-content-between">
                                    <div class="d-flex align-items-center">
                                       <h5>
                                          <a href="#">Emilly Blunt</a>
                                       </h5>
                                       <p class="date">December 4, 2017 at 3:12 pm </p>
                                    </div>
                                    <div class="reply-btn">
                                       <a href="#" class="btn-reply text-uppercase">reply</a>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="comment-form">
                     <h4>Comment</h4>
                     <form class="form-contact comment_form" action="#" id="commentForm">
                        <div class="row">
                           <div class="col-12">
                              <div class="form-group">
                                 <textarea class="form-control w-100" name="comment" id="comment" cols="30" rows="9"
                                    placeholder="Write Comment"></textarea>
                              </div>
                           </div>
                        </div>
                        <div class="form-group">
                           <button type="submit" class="button button-contactForm btn_1 boxed-btn">Send Comment</button>
                        </div>
                     </form>
                  </div>
               </div>
         </div>
      </section>
      <!--================ Blog Area end =================-->
</body>
</html>
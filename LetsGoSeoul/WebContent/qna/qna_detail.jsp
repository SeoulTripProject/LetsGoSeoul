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
      <section class="single-post-area section-padding" style="margin-left:25%">
         <div class="container">
            <div class="row">
               <div class="col-lg-8 posts-list">
                  <div class="single-post">
                     <div class="blog_details">
                        <h2>${vo.subject }</h2>
                        <ul class="blog-info-link mt-3 mb-4">
                          <li><i class="fa fa-check"></i>${vo.no }</li>
                           <li><i class="fa fa-user"></i>${vo.name }</li>
                           <li><i class="fa fa-calendar"></i>${vo.dbday }</li>
                           <li><i class="fa fa-eye"></i>${vo.hit }</li>
                        </ul>
                        <p class="excert">${vo.content }</p>
                     </div>
                  </div>
                  <div class="navigation-top">
                     <div class="d-sm-flex justify-content-between text-center">
                        <p class="like-info"><span class="align-middle"><i class="fa fa-heart"></i></span> Lily and 4
                           people like this</p>
                        <div class="button-group-area mt-40">
                          <a href="../qna/qna_update.do?no=${vo.no }" class="genric-btn success-border radius small">Edit</a>
                          <a href="../qna/qna_delete.do?no=${vo.no }" class="genric-btn danger-border radius small">Delete</a>
                          <a href="../qna/qna.do" class="genric-btn warning-border radius small">List</a>
                        </div>
                     </div>
                     
                  </div>
                  <div class="comments-area">
                     <h4>Comments</h4>
                     <div class="comment-list">
                      <c:forEach var="rvo" items="${list }">
                        <div class="single-comment justify-content-between d-flex">
                           <div class="user justify-content-between d-flex">
                              <div class="thumb">
                                 <img src="assets/img/comment/comment_3.png" alt="">
                              </div>
                              <div class="desc">
                                 <p class="comment">${rvo.msg }</p>
                                 <div class="d-flex justify-content-between">
                                    <div class="d-flex align-items-center">
                                       <h5>
                                          <a href="#">${rvo.name }</a>
                                       </h5>
                                       <p class="date">${rvo.dbday }</p>
                                    </div>
                                    <c:if test="${sessionScope.id==rvo.id }">
                                    <div class="reply-btn">
                                       <a href="../qna/qna_ok" class="btn-reply text-uppercase">Edit</a>
                                       
                                       <a href="" class="btn-reply text-uppercase">Delete</a>
                                    </div>
                                    </c:if>
                                 </div>
                              </div>
                           </div>
                        </div>
                      </c:forEach>  
                     </div>
                  </div>
                  <div class="comment-form">
                     <h4>Comment</h4>
                     <c:if test="${sessionScope.id!=null }">
                     <form class="form-contact comment_form" method="post" action="../qna/qna_reply_insert.do" id="commentForm">
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
                     </c:if>
                  </div>
               </div>
             </div>
         </div>
      </section>
      <!--================ Blog Area end =================-->
</body>
</html>
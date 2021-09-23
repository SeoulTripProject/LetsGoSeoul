<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let u=0;
$(function(){
	$('.ubtn').click(function(){
		let no=$(this).attr("data-no");
		$('.form-contact comment_form').hide();
		if(u==0)
		{
			$(this).text("Cancel");
			$('#u'+no).show();
			u=1;
		}
		else
		{
			$(this).text("Edit");
			$('#u'+no).hide();
			u=0;
		}
	})
})
</script>
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
      <section class="blog_area single-post-area section-padding" style="margin-left:25%;">
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
                          <a href="../board/freeboard_update.do?no=${vo.no }" class="genric-btn primary small">Edit</a>
                          <a href="../board/freeboard_delete.do?no=${vo.no }" class="genric-btn primary small">Delete</a>
                          <a href="../board/freeboard.do" class="genric-btn primary small">List</a>
                        </div>
                     </div>
                     <!-- <div class="navigation-area">
                        <div class="row">
                           <div
                              class="col-lg-6 col-md-6 col-12 nav-left flex-row d-flex justify-content-start align-items-center">
                              <div class="arrow">
                                 <a href="#">
                                    <span class="lnr text-white ti-arrow-left"></span>
                                 </a>
                              </div>
                              <div class="thumb">
                                 <a href="#">
                                    <img class="img-fluid" src="assets/img/post/next.png" alt="">
                                 </a>
                              </div>
                              
                           </div>
                           <div
                              class="col-lg-6 col-md-6 col-12 nav-right flex-row d-flex justify-content-end align-items-center">
                              
                           </div>
                        </div>
                     </div> -->
                  </div>
                  <div class="comments-area">
                     <h4>Comments</h4>
                     <div class="comment-list">
                      <c:forEach var="rvo" items="${list }">
                        <div class="single-comment justify-content-between d-flex">
                           <div class="user justify-content-between d-flex" style="margin-bottom: 8%">
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
                                       <a href="#" class="btn-reply ubtn text-uppercase" data-no="${rvo.no }">Edit</a>
                                       <a href="../board/freeboard_reply_delete.do?no=${rvo.no }&bno=${vo.no}" class="btn-reply text-uppercase">Delete</a>
                                    </div>
                                    </c:if>
                                 </div>
                              </div>
                           </div>
                        </div>
                        <form class="form-contact comment_form" method="post" action="../board/freeboard_reply_update.do" id="u${rvo.no }" style="display:none">
                                <div class="row">
                                  <div class="col-12">
                                    <div class="form-group">
                                      <textarea class="form-control w-100" name="msg" id="msg" cols="30" rows="9"
                                       placeholder="Write Comment">${rvo.msg }</textarea>
                                      <input type=hidden value="${vo.no }" name="bno">
                                      <input type=hidden value="${rvo.no }" name="no">
                                    </div>
                                    <div class="form-group">
                                      <input type="submit" class="button button-contactForm btn_1 boxed-btn" value="Edit">
                                    </div>
                                  </div>
                                </div>
                              </form>
                      </c:forEach>  
                     </div>
                  </div>
                  <div class="comment-form">
                     <h4>Comment</h4>
                     <c:if test="${sessionScope.id!=null }">
                     <form class="form-contact comment_form" method="post" action="../board/freeboard_reply_insert.do" id="commentForm">
                        <div class="row">
                           <div class="col-12">
                              <div class="form-group">
                                 <textarea class="form-control w-100" name="msg" id="msg" cols="30" rows="9"
                                    placeholder="Write Comment"></textarea>
                                 <input type=hidden value="${vo.no }" name="bno">
	                             <input type=hidden value="1" name="type">
                              </div>
                           </div>
                        </div>
                        <div class="form-group">
                           <button type="submit" class="button button-contactForm btn_1 boxed-btn">Send</button>
                        </div>
                     </form>
                     </c:if>
                  </div>
            </div>
         </div>
      </section>
      <!--================ Blog Area end =================-->
</body>
</html>
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
      <div class="hero-area2  slider-height2 hero-overly2 d-flex align-items-center">
         <div class="container">
               <div class="row">
                  <div class="col-xl-12">
                     <div class="hero-cap text-center pt-50">
                           <h2>Hotel Details</h2>
                     </div>
                  </div>
               </div>
         </div>
      </div>
      <!--Hero End -->
      <!-- no,sno,sname,score,poster,images,webLink,addr -->
      <!--================Blog Area =================-->
      <section class="blog_area single-post-area section-padding">
         <div class="container">
            <div class="row">
               <div class="col-lg-8 posts-list">
                  <div class="single-post">
                     <div class="feature-img">
                     	<c:forTokens var="image" items="${vo.images }" delims="^">
		     			<img class="img-fluid" src="${image }" style="width:250px;height:250px">
		   				</c:forTokens>
                     </div>
                     <div class="blog_details">
                        <h2>${vo.sname }&nbsp;&nbsp;<span style="color:blue">${vo.score }</span></h2>
                        <ul class="blog-info-link mt-3 mb-4">
                           <li><a href="#"><i class="fa fa-user"></i> Travel, Lifestyle</a></li>
                           <li><a href="#"><i class="fa fa-comments"></i> 03 Comments</a></li>
                        </ul>
                        <p class="excert">
				                        주소 : ${vo.addr }
                        </p>
                        <%-- <c:if test="${vo.webLink!=' ' }">
                        <p class="excert">
                        	예약 : ${vo.webLink }
                        </p>
                        </c:if> --%>
                        <p class="excert"></p>
                     </div>
                  </div>
                  <div class="navigation-top">
                     <div class="d-sm-flex justify-content-between text-center">
                       <div class="col-sm-4 text-center my-2 my-sm-0">
                        <ul class="social-icons">
                           <li><a href="#"><i class="fa fa-thumbs-up"></i></a></li>
                           <li><a href="#"><i class="fa fa-heart"></i></a></li>
                           <li><a href="#"><i class="fa fa-check"></i></a></li>
                           <li><a href="../stay/stay_main.do"><i class="fa fa-list"></i></a></li>
                        </ul>
                       </div>
                     </div>
                       <div class="navigation-area">
                        <div class="row">
                        <c:if test="${(no-1)!=0 }">
                           <div
                              class="col-lg-6 col-md-6 col-12 nav-left flex-row d-flex justify-content-start align-items-center">
                              <div class="thumb">
                                 <a href="../stay/hdetail.do?no=${vo.no-1 }">
                                    <img class="img-fluid" src="../assets/img/post/preview.png" alt="">
                                 </a>
                              </div>
                              <div class="arrow">
                                 <a href="../stay/hdetail.do?no=${vo.no-1 }">
                                    <span class="lnr text-white ti-arrow-left"></span>
                                 </a>
                              </div>
                              <div class="detials">
                                 <p>Prev Post</p>
                              </div>
                           </div>
                           <div
                              class="col-lg-6 col-md-6 col-12 nav-right flex-row d-flex justify-content-end align-items-center">
                              <div class="detials">
                                 <p>Next Post</p>
                              </div>
                              <div class="arrow">
                                 <a href="../stay/hdetail.do?no=${vo.no+1 }">
                                    <span class="lnr text-white ti-arrow-right"></span>
                                 </a>
                              </div>
                              <div class="thumb">
                                 <a href="../stay/hdetail.do?no=${vo.no+1 }">
                                    <img class="img-fluid" src="../assets/img/post/next.png" alt="">
                                 </a>
                              </div>
                           </div>
                           </c:if>
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
                                 <img src="../assets/img/comment/comment_3.png" alt="">
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
                                       <a href="#" class="btn-reply text-uppercase">Edit</a>
                                       <a href="#" class="btn-reply text-uppercase">Delete</a>
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
                     <form class="form-contact comment_form" method="post" action="../stay/hdetail_reply_insert.do" id="commentForm">
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
	          <div class="col-lg-4"> 
		      <div id="map" style="width:100%;height:350px;"></div>
			      <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f327ff259f684cbacea42ee49e7f9326&libraries=services"></script>
			      <script>
			      var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			          mapOption = {
			              center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			              level: 3 // 지도의 확대 레벨
			          };  
			      
			      // 지도를 생성합니다    
			      var map = new kakao.maps.Map(mapContainer, mapOption); 
			      
			      // 주소-좌표 변환 객체를 생성합니다
			      var geocoder = new kakao.maps.services.Geocoder();
			      
			      // 주소로 좌표를 검색합니다
			      geocoder.addressSearch('${vo.addr}', function(result, status) {
			      
			          // 정상적으로 검색이 완료됐으면 
			           if (status === kakao.maps.services.Status.OK) {
			      
			              var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			      
			              // 결과값으로 받은 위치를 마커로 표시합니다
			              var marker = new kakao.maps.Marker({
			                  map: map,
			                  position: coords
			              });
			      
			              // 인포윈도우로 장소에 대한 설명을 표시합니다
			              var infowindow = new kakao.maps.InfoWindow({
			                  content: '<div style="width:150px;text-align:center;padding:6px 0;">${vo.sname}</div>'
			              });
			              infowindow.open(map, marker);
			      
			              // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			              map.setCenter(coords);
			          } 
			      });    
			      </script>  
		   </div>
         </div>
      </section>
      <!--================ Blog Area end =================-->
</body>
</html>
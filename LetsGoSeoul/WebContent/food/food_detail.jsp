<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.hero-area2 {
  background-image: url(../assets/img/hero/river.jpg);
  background-size: cover;
  background-repeat: no-repeat;
  min-height: 500px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let u=0;
$(function(){
	$('#insertbtn').click(function(){
		$('#commentForm').submit();
	})
	
	$('.ubtn').click(function(){
		let no=$(this).attr("data-no");
		$('.updateForm').hide();
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
</head>
<body>
<!-- Hero Start-->
      <div class="hero-area2  slider-height2 hero-overly2 d-flex align-items-center">
         <div class="container">
               <div class="row">
                  <div class="col-xl-12">
                     <div class="hero-cap text-center pt-50">
                           <h2>Restaurant Details</h2>
                     </div>
                  </div>
               </div>
         </div>
      </div>
      <!--Hero End -->
      <!--================Blog Area =================-->
      <section class="blog_area single-post-area section-padding">
         <div class="container">
            <div class="row">
               <div class="col-lg-8 posts-list">
                  <div class="single-post">
                     <div class="feature-img">
                     	<c:forTokens var="image" items="${vo.poster }" delims="^">
		     			<img class="img-fluid" src="${image }" style="width:250px;heigt:250px">
		   				</c:forTokens>
                     </div>
                     <div class="blog_details">
                        <h2>${vo.rname }&nbsp;<span style="color:orange">${vo.score }</span></h2>
                        <ul class="blog-info-link mt-3 mb-4">
                           <li><a href="#"><i class="fa fa-user"></i> Travel, Lifestyle</a></li>
                           <li><a href="#"><i class="fa fa-comments"></i> 03 Comments</a></li>
                        </ul>
                        <p class="excert">
				                        주소 : ${vo.addr1 }
						     <br><sup>${vo.addr2 }</sup>
                        </p>
                        <p class="excert">
                        	전화 : ${vo.tel } 
                        </p>
                        <p class="excert">
                        	음식 종류 : ${vo.rtype }
                        </p>
                        <c:if test="${vo.price!='no' }">
                        <p class="excert">
                        	가격대 : ${vo.price }
                        </p>
                        </c:if>
                        <c:if test="${vo.parking!='no' }">
                        <p class="excert">
                        	주차 : ${vo.parking }
                        </p>
                        </c:if>
                        <c:if test="${vo.openHour!='no' }">
                        <p class="excert">
                        	영업시간 : ${vo.openHour }
                        </p>
                        </c:if>
                        <c:if test="${vo.menu!='no' }">
                        <p class="excert">
                        	메뉴 : <c:forTokens items="${vo.menu }" delims="원" var="m">
			          				<li>${m }원</li>
			        			 </c:forTokens>
                        </p>
                        </c:if>
                        <p class="excert"></p>
                     </div>
                  </div>
                  <div class="navigation-top">
                     <div class="d-sm-flex justify-content-between text-center">
                        <p class="like-info"><i class="fa fa-tag">
                        </i><span class="align-middle">
                          <c:forTokens var="tag" items="${vo.rtag }" delims="^">
                          	&nbsp;${tag }&nbsp;
		   				  </c:forTokens>
                        </span>
                        </p>
                        <div class="col-sm-4 text-center my-2 my-sm-0">
                        <ul class="social-icons">
                           <li><a href="#"><i class="fa fa-thumbs-up"></i></a></li>
                           <li><a href="#"><i class="fa fa-heart"></i></a></li>
                           <li><a href="#"><i class="fa fa-check"></i></a></li>
                           <li><a href="../food/food_main.do"><i class="fa fa-list"></i></a></li>
                        </ul>
                        </div>
                     </div>
                       <div class="navigation-area">
                        <div class="row">
                        <c:if test="${vo.preno!=null}">
                           <div
                              class="col-lg-6 col-md-6 col-12 nav-left flex-row d-flex justify-content-start align-items-center">
                              <div class="thumb">
                                 <a href="../food/food_detail.do?no=${vo.preno }">
                                    <img class="img-fluid" src="../assets/img/post/preview.png" alt="">
                                 </a>
                              </div>
                              <div class="arrow">
                                 <a href="../food/food_detail.do?no=${vo.preno }">
                                    <span class="lnr text-white ti-arrow-left"></span>
                                 </a>
                              </div>
                              <div class="detials">
                                 <p>Prev POST</p>
                              </div>
                           </div>
                         </c:if>
                         <c:if test="${vo.nextno!=null }">
                           <div
                              class="col-lg-6 col-md-6 col-12 nav-right flex-row d-flex justify-content-end align-items-center">
                              <div class="detials">
                                 <p>Next PST</p>
                              </div>
                              <div class="arrow">
                                 <a href="../food/food_detail.do?no=${vo.nextno }">
                                    <span class="lnr text-white ti-arrow-right"></span>
                                 </a>
                              </div>
                              <div class="thumb">
                                 <a href="../food/food_detail.do?no=${vo.nextno }">
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
                     <c:forEach var="fvo" items="${list }">
                        <div class="single-comment justify-content-between d-flex">
                           <div class="user justify-content-between d-flex">
                              <div class="desc">
                                 <p class="comment">
     								${fvo.msg }
                                 </p>
                                 <div class="d-flex justify-content-between">
                                    <div class="d-flex align-items-center">
                                       <h5>
                                          <a href="#">${fvo.name }</a>
                                       </h5>
                                       <p class="date">${fvo.dbday } </p>
                                    </div>
                                    <c:if test="${sessionScope.id==fvo.id }">
                                    <div class="reply-btn">
                                       <a href="#" class="btn-reply text-uppercase ubtn" data-no=${fvo.no }>Edit</a>
                                       <a href="../food/reply_delete.do?no=${fvo.no }&bno=${vo.no}" class="btn-reply text-uppercase">Delete</a>
                                    </div>
                                    </c:if>
                                 </div>
                              </div>
                           </div>
                        </div>
                   <form method="post" action="../food/reply_update.do" 
               		class="updateForm" id="u${fvo.no }" style="display:none">
                        <div class="single-comment justify-content-between d-flex">
                           <div class="user justify-content-between d-flex">
                              <div class="desc">
			               		  <input type="hidden" value="${vo.no }" name="bno">
					              <input type="hidden" value="${fvo.no }" name="no">
					              <p class="comment">
     								${fvo.msg }
                                  </p>
					              <button type="submit" class="button button-contactForm btn_1 boxed-btn">Change Edit</button>
					           </div>
					        </div>
					     </div>
	              </form>
                </c:forEach>
                      </div>
               </div>
                  <div class="comment-form">
                     <h4>Leave a Comment</h4>
                   <c:if test="${sessionScope.id!=null }">
       				<form class="form-contact comment_form" id="commentForm" method="post" action="../food/reply_insert.do">
                        <div class="row">
                          <div class="col-12">
                              <div class="form-group">
                                 <textarea class="form-control w-100" name="msg" id="comment" cols="30" rows="9"
                                    placeholder="Write Comment"></textarea>
		                          <input type="hidden" value="${vo.no }" name="bno">
		              			  <input type="hidden" value="3" name="type">
                              </div>
                            </div>
                        </div> 
                        <div class="form-group">
                           <button type="submit" class="button button-contactForm btn_1 boxed-btn" id="insertbtn">Send Message</button>
                        </div>
                       </form>
                    </c:if>
                  </div>
               </div>
               <div class="col-lg-4">
                  <div class="blog_right_sidebar">
                    <div id="map" style="width:100%;height:350px;"></div>
                      <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b1f7be3cfeaa44ff7fc1c8ffcc72b6bc&libraries=services"></script>
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
						geocoder.addressSearch('${vo.addr1}', function(result, status) {
										
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
							content: '<div style="width:150px;text-align:center;padding:6px 0;">${vo.rname}</div>'
							});
							infowindow.open(map, marker);
										
						// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
						map.setCenter(coords);
							} 
						});    
						</script>
                     <aside class="single_sidebar_widget post_category_widget">
                        <h4 class="widget_title">Category</h4>
                        <ul class="list cat-list">
                           <li>
                              <a href="#" class="d-flex">
                                 <p>Resaurant food</p>
                                 <p>(37)</p>
                              </a>
                           </li>
                           <li>
                              <a href="#" class="d-flex">
                                 <p>Travel news</p>
                                 <p>(10)</p>
                              </a>
                           </li>
                           <li>
                              <a href="#" class="d-flex">
                                 <p>Modern technology</p>
                                 <p>(03)</p>
                              </a>
                           </li>
                           <li>
                              <a href="#" class="d-flex">
                                 <p>Product</p>
                                 <p>(11)</p>
                              </a>
                           </li>
                           <li>
                              <a href="#" class="d-flex">
                                 <p>Inspiration</p>
                                 <p>(21)</p>
                              </a>
                           </li>
                           <li>
                              <a href="#" class="d-flex">
                                 <p>Health Care</p>
                                 <p>(21)</p>
                              </a>
                           </li>
                        </ul>
                     </aside>
                     <aside class="single_sidebar_widget popular_post_widget">
                        <h3 class="widget_title">Recent Post</h3>
                        <div class="media post_item">
                           <img src="../assets/img/post/post_1.png" alt="post">
                           <div class="media-body">
                              <a href="blog_details.html">
                                 <h3>From life was you fish...</h3>
                              </a>
                              <p>January 12, 2019</p>
                           </div>
                        </div>
                        <div class="media post_item">
                           <img src="../assets/img/post/post_2.png" alt="post">
                           <div class="media-body">
                              <a href="blog_details.html">
                                 <h3>The Amazing Hubble</h3>
                              </a>
                              <p>02 Hours ago</p>
                           </div>
                        </div>
                        <div class="media post_item">
                           <img src="../assets/img/post/post_3.png" alt="post">
                           <div class="media-body">
                              <a href="blog_details.html">
                                 <h3>Astronomy Or Astrology</h3>
                              </a>
                              <p>03 Hours ago</p>
                           </div>
                        </div>
                        <div class="media post_item">
                           <img src="../assets/img/post/post_4.png" alt="post">
                           <div class="media-body">
                              <a href="blog_details.html">
                                 <h3>Asteroids telescope</h3>
                              </a>
                              <p>01 Hours ago</p>
                           </div>
                        </div>
                     </aside>
                     <aside class="single_sidebar_widget tag_cloud_widget">
                        <h4 class="widget_title">Tag Clouds</h4>
                        <ul class="list">
                           <li>
                              <a href="#">project</a>
                           </li>
                           <li>
                              <a href="#">love</a>
                           </li>
                           <li>
                              <a href="#">technology</a>
                           </li>
                           <li>
                              <a href="#">travel</a>
                           </li>
                           <li>
                              <a href="#">restaurant</a>
                           </li>
                           <li>
                              <a href="#">life style</a>
                           </li>
                           <li>
                              <a href="#">design</a>
                           </li>
                           <li>
                              <a href="#">illustration</a>
                           </li>
                        </ul>
                     </aside>
                     <aside class="single_sidebar_widget newsletter_widget">
                        <h4 class="widget_title">Newsletter</h4>
                        <form action="#">
                           <div class="form-group">
                              <input type="email" class="form-control" onfocus="this.placeholder = ''"
                                 onblur="this.placeholder = 'Enter email'" placeholder='Enter email' required>
                           </div>
                           <button class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
                              type="submit">Subscribe</button>
                        </form>
                     </aside>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <!--================ Blog Area end =================-->
</body>
</html>
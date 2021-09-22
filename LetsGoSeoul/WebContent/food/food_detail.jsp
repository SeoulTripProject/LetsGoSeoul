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
                           <li><a href="#"><i class="fa fa-thumbs-up"></i> Good ${vo.good }</a></li>
                           <li><a href="#"><i class="fa fa-minus"></i> Soso ${vo.soso }</a></li>
                           <li><a href="#"><i class="fa fa-thumbs-down"></i> Bad ${vo.bad }</a></li>
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
                                    <img class="img-fluid" src="../assets/img/post/left-arrow.png" style="width:50px;height:50px">
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
                                 <p>Next POST</p>
                              </div>
                              <div class="arrow">
                                 <a href="../food/food_detail.do?no=${vo.nextno }">
                                    <span class="lnr text-white ti-arrow-right"></span>
                                 </a>
                              </div>
                              <div class="thumb">
                                 <a href="../food/food_detail.do?no=${vo.nextno }">
                                    <img class="img-fluid" src="../assets/img/post/right-arrow.png" style="width:50px;height:50px">
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
                       <pre></pre>
                       <pre></pre>
                       <pre></pre>
                        <div class="single-comment justify-content-between d-flex">
                           <div class="user justify-content-between d-flex">
                              <div class="desc">
                                 <p class="comment" style="white-space: pre-wrap;">${fvo.msg }</p>
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
                             <div class="row">
                                <div class="col-12">
                                  <div class="form-group">
                                  <textarea class="form-control w-100" name="msg" id="comment" cols="30" rows="9"
                                  placeholder="Write Comment">${fvo.msg }</textarea>
			               		  <input type="hidden" value="${vo.no }" name="bno">
					              <input type="hidden" value="${fvo.no }" name="no">
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
                     <aside class="single_sidebar_widget popular_post_widget">
                        <h3 class="widget_title">Near By</h3>
                        <c:forEach var="avo" items="${aList}">
                        <div class="media post_item">
                           <img src="${avo.poster }" alt="post" style="width:90px;height:90px">
                           <div class="media-body">
                              <a href="../attraction/attraction_main.jsp">
                                 <h3>${avo.title }</h3>
                              </a>
                           </div>
                        </div>
                       </c:forEach>
                        <c:forEach var="svo" items="${sList}">
                        <div class="media post_item">
                           <img src="${svo.poster }" alt="post" style="width:90px;height:90px">
                           <div class="media-body">
                              <a href="../stay/stay_main.jsp">
                                 <h3>${svo.sname }</h3>
                              </a>
                           </div>
                        </div>
                       </c:forEach>
                        <c:forEach var="nvo" items="${nList}">
                        <div class="media post_item">
                           <img src="${nvo.poster }" alt="post" style="width:90px;height:90px">
                           <div class="media-body">
                              <a href="../nature/detail.do?no="${nvo.no }>
                                 <h3>${nvo.title }</h3>
                              </a>
                           </div>
                        </div>
                       </c:forEach>
                        <c:forEach var="evo" items="${eList}">
                        <div class="media post_item">
                           <img src="${evo.poster }" alt="post" style="width:90px;height:90px">
                           <div class="media-body">
                              <a href="../culture/exhibition_detail.do?no="${evo.no }>
                                 <h3>${evo.title }</h3>
                              </a>
                           </div>
                        </div>
                       </c:forEach>
                     </aside>
                     <aside class="single_sidebar_widget instagram_feeds">
                        <h4 class="widget_title">Recently viewed</h4>
                        <ul class="instagram_row flex-wrap">
                          <c:forEach var="cvo" items="${fList }">
                           <li>
                              <a href="#">
                                 <img class="img-fluid" src="${cvo.poster }" 
                                 style="width:90px;height:90px" title="${cvo.rname }">
                              </a>
                           </li>
                          </c:forEach>
                        </ul>
                     </aside>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <!--================ Blog Area end =================-->
</body>
</html>
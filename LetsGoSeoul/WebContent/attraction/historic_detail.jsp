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
	<div
		class="hero-area2  slider-height2 hero-overly2 d-flex align-items-center">
		<div class="container">
			<div class="row">
				<div class="col-xl-12">
					<div class="hero-cap text-center pt-50">
						<h2>Historic Place Details</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--Hero End -->
	<!--================Blog Area =================-->
	<section class=" single-post-area section-padding">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 posts-list">
					<div class="single-post">
						<div class="feature-img">
							<c:forTokens var="image" items="${vo.image }" delims="^">
								<img class="img-fluid" src="${image }"
									style="width: 250px; heigt: 250px">
							</c:forTokens>
						</div>
						<div class="blog_details">
							<h2>${vo.title }</h2>

							<c:if test="${vo.intro!=null }">
								<p class="excert">소개 : ${vo.intro }</p>
							</c:if>
							<c:if test="${vo.tel!=null }">
								<p class="excert">전화번호 : ${vo.tel }</p>
							</c:if>

							<c:if test="${vo.website!=null }">
								<p class="excert">
									웹사이트 : <a href="${vo.website }">웹사이트로 이동</a>
								</p>
							</c:if>
							<c:if test="${vo.time!=null }">
								<p class="excert">이용시간 : ${vo.time }</p>
							</c:if>
							<c:if test="${vo.holiday!=null }">
								<p class="excert">휴무일 : ${vo.holiday }</p>
							</c:if>
							<c:if test="${vo.open!=null }">
								<p class="excert">운영요일 : ${vo.open }</p>
							</c:if>
							<c:if test="${vo.price!=null }">
								<p class="excert">이용요금 : ${vo.price }</p>
							</c:if>
							<c:if test="${vo.handi!=null }">
								<p class="excert">장애인 편의시설 : ${vo.handi }</p>
							</c:if>
							<c:if test="${vo.caution!=null }">
								<p class="excert">이것만은 꼭! : ${vo.caution }</p>
							</c:if>
							<div id="map" style="width: 100%; height: 350px;"></div>

							<script type="text/javascript"
								src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0995d39979ef9be078034104ced7c19c&libraries=services"></script>
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
							geocoder.addressSearch('${vo.addr2}', function(result, status) {
							
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
							            content: '<div style="width:150px;text-align:center;padding:6px 0;">${vo.addr}</div>'
							        });
							        infowindow.open(map, marker);
							
							        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							        map.setCenter(coords);
							    } 
							});    
							</script>
							<c:if test="${vo.addr!=null }">
								<p class="excert">주소 : ${vo.addr }</p>
							</c:if>
							<c:if test="${vo.traffic!=null }">
								<p class="excert">교통정보 : ${vo.traffic }</p>
							</c:if>
							<p class="excert"></p>
							<p class="excert"></p>
						</div>
					</div>
					<div class="navigation-top">
						<div class="d-sm-flex justify-content-between text-center">
							<p class="like-info">
								<i class="fa fa-tag"> </i>
							</p>
							<div class="col-sm-4 text-center my-2 my-sm-0">
								<ul class="social-icons">
									<li><a href="#"><i class="fa fa-thumbs-up"></i></a></li>
									<li><a href="#"><i class="fa fa-heart"></i></a></li>
									<li><a href="#"><i class="fa fa-check"></i></a></li>
									<li><a href="../culture/exhibition.do"><i
											class="fa fa-list"></i></a></li>
								</ul>
							</div>
						</div>
						<div class="navigation-area">
							<div class="row">
								<div
									class="col-lg-6 col-md-6 col-12 nav-left flex-row d-flex justify-content-start align-items-center">
									<div class="thumb">
										<a href="#"> <img class="img-fluid"
											src="../assets/img/post/preview.png" alt="">
										</a>
									</div>
									<div class="arrow">
										<a href="#"> <span class="lnr text-white ti-arrow-left"></span>
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
										<a href="#"> <span class="lnr text-white ti-arrow-right"></span>
										</a>
									</div>
									<div class="thumb">
										<a href="#"> <img class="img-fluid"
											src="../assets/img/post/next.png" alt="">
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="blog-author">
						<div class="media align-items-center">
							<img src="../assets/img/blog/author.png" alt="">
							<div class="media-body">
								<a href="#">
									<h4>Harvard milan</h4>
								</a>
								<p>Second divided from form fish beast made. Every of seas
									all gathered use saying you're, he our dominion twon Second
									divided from</p>
							</div>
						</div>
					</div>
					<div class="comments-area">
						<h4>05 Comments</h4>
						<div class="comment-list">
							<div class="single-comment justify-content-between d-flex">
								<div class="user justify-content-between d-flex">
									<div class="thumb">
										<img src="../assets/img/comment/comment_1.png" alt="">
									</div>
									<div class="desc">
										<p class="comment">Multiply sea night grass fourth day sea
											lesser rule open subdue female fill which them Blessed, give
											fill lesser bearing multiply sea night grass fourth day sea
											lesser</p>
										<div class="d-flex justify-content-between">
											<div class="d-flex align-items-center">
												<h5>
													<a href="#">Emilly Blunt</a>
												</h5>
												<p class="date">December 4, 2017 at 3:12 pm</p>
											</div>
											<div class="reply-btn">
												<a href="#" class="btn-reply text-uppercase">reply</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="comment-list">
							<div class="single-comment justify-content-between d-flex">
								<div class="user justify-content-between d-flex">
									<div class="thumb">
										<img src="../assets/img/comment/comment_2.png" alt="">
									</div>
									<div class="desc">
										<p class="comment">Multiply sea night grass fourth day sea
											lesser rule open subdue female fill which them Blessed, give
											fill lesser bearing multiply sea night grass fourth day sea
											lesser</p>
										<div class="d-flex justify-content-between">
											<div class="d-flex align-items-center">
												<h5>
													<a href="#">Emilly Blunt</a>
												</h5>
												<p class="date">December 4, 2017 at 3:12 pm</p>
											</div>
											<div class="reply-btn">
												<a href="#" class="btn-reply text-uppercase">reply</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="comment-list">
							<div class="single-comment justify-content-between d-flex">
								<div class="user justify-content-between d-flex">
									<div class="thumb">
										<img src="../assets/img/comment/comment_3.png" alt="">
									</div>
									<div class="desc">
										<p class="comment">Multiply sea night grass fourth day sea
											lesser rule open subdue female fill which them Blessed, give
											fill lesser bearing multiply sea night grass fourth day sea
											lesser</p>
										<div class="d-flex justify-content-between">
											<div class="d-flex align-items-center">
												<h5>
													<a href="#">Emilly Blunt</a>
												</h5>
												<p class="date">December 4, 2017 at 3:12 pm</p>
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
						<h4>Leave a Reply</h4>
						<form class="form-contact comment_form" action="#"
							id="commentForm">
							<div class="row">
								<div class="col-12">
									<div class="form-group">
										<textarea class="form-control w-100" name="comment"
											id="comment" cols="30" rows="9" placeholder="Write Comment"></textarea>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<input class="form-control" name="name" id="name" type="text"
											placeholder="Name">
									</div>
								</div>
								<div class="col-sm-6">
									<div class="form-group">
										<input class="form-control" name="email" id="email"
											type="email" placeholder="Email">
									</div>
								</div>
								<div class="col-12">
									<div class="form-group">
										<input class="form-control" name="website" id="website"
											type="text" placeholder="Website">
									</div>
								</div>
							</div>
							<div class="form-group">
								<button type="submit"
									class="button button-contactForm btn_1 boxed-btn">Send
									Message</button>
							</div>
						</form>
					</div>
					<%-- 지도 --%>

				</div>
			</div>
		</div>
	</section>
	<!--================ Blog Area end =================-->
</body>
</html>
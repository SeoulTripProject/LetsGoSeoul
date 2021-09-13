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

	<div
		class="hero-area2  slider-height2 hero-overly2 d-flex align-items-center ">
		<div class="container">
			<div class="row">
				<div class="col-xl-12">
					<div class="hero-cap text-center pt-50">
						<h2>Attraction</h2>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="popular-location section-padding30">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-tittle text-center mb-80">
						<h2>Landmark</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<c:forEach var="lvo" items="${Llist }">
					<div class="col-4">
						<div class="single-location mb-30 inline">
							<div class="location-img inline">
								<img src="${lvo.poster }" style="width: 360px; height: 286px">
							</div>
							<div class="location-details">
								<p>${lvo.title }</p>
								<a href="../attraction/landmark.do" class="location-btn"><i class="ti"></i>바로가기</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<hr>
			<div class="row">
				<div class="col-lg-12">
					<div class="section-tittle text-center mb-80">
						<h2>Palace</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<c:forEach var="pvo" items="${Plist }">
					<div class="col-4">
						<div class="single-location mb-30 inline">
							<div class="location-img inline">
								<img src="${pvo.poster }" style="width: 360px; height: 286px">
							</div>
							<div class="location-details">
								<p>${pvo.title }</p>
								<a href="../attraction/palace.do" class="location-btn"><i class="ti-plus"></i>바로가기</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<hr>
			<div class="row">
				<div class="col-lg-12">
					<div class="section-tittle text-center mb-80">
						<h2>Historic Place</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<c:forEach var="hvo" items="${Hlist }">
					<div class="col-4">
						<div class="single-location mb-30 inline">
							<div class="location-img inline">
								<img src="${hvo.poster }" style="width: 360px; height: 286px">
							</div>
							<div class="location-details">
								<p>${hvo.title }</p>
								<a href="../attraction/historic.do" class="location-btn"><i class="ti-plus"></i>바로가기</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<hr>
			<div class="row">
				<div class="col-lg-12">
					<div class="section-tittle text-center mb-80">
						<h2>Old Store</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<c:forEach var="ovo" items="${Olist }">
					<div class="col-4">
						<div class="single-location mb-30 inline">
							<div class="location-img inline">
								<img src="${ovo.poster }" style="width: 360px; height: 286px">
							</div>
							<div class="location-details">
								<p>${ovo.title }</p>
								<a href="../attraction/old.do" class="location-btn"><i class="ti-plus"></i>바로가기</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<hr>
			<div class="row">
				<div class="col-lg-12">
					<div class="section-tittle text-center mb-80">
						<h2>Museum</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<c:forEach var="mvo" items="${Mlist }">
					<div class="col-4">
						<div class="single-location mb-30 inline">
							<div class="location-img inline">
								<img src="${mvo.poster }" style="width: 360px; height: 286px">
							</div>
							<div class="location-details">
								<p>${mvo.title }</p>
								<a href="../attraction/museum.do" class="location-btn"><i class="ti-plus"></i>바로가기</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>
	<div id="back-top">
		<a title="Go to Top" href="#"> <i class="fas fa-level-up-alt"></i></a>
	</div>
</body>
</html>
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
button{
  background:#1AAB8A;
  color:#fff;
  border:none;
  position:relative;
  height:60px;
  font-size:1.6em;
  padding:0 2em;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
}
button:hover{
  background:#fff;
  color:#1AAB8A;
}
button:before,button:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #1AAB8A;
  transition:400ms ease all;
}
button:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
button:hover:before,button:hover:after{
  width:100%;
  transition:800ms ease all;
}

</style>
</head>
<body>
<!-- Hero Start-->
      <div class="hero-area2  slider-height2 hero-overly2 d-flex align-items-center">
         <div class="container">
               <div class="row">
                  <div class="col-xl-12">
                     <div class="hero-cap text-center pt-50">
                           <h2>Guest House Details</h2>
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
                     	<c:forTokens var="image" items="${vo.images }" delims="^">
		     			<img class="img-fluid" src="${image }" style="width:250px;heigt:250px">
		   				</c:forTokens>
                     </div>
                     <div class="blog_details">
                        <h2>${vo.sname }</h2>
                        <ul class="blog-info-link mt-3 mb-4">
                           <li><a href="#"><i class="fa fa-user"></i> Travel, Lifestyle</a></li>
                           <li><a href="#"><i class="fa fa-comments"></i> 03 Comments</a></li>
                        </ul>
                        <!-- no,sno,sname,time,poster,images,tel,email,"
						+ "webLink,addr,langu,info,roomInfo,bus -->
                        <p class="excert">
                        	시간 : ${vo.time } 
                        </p>
                        <c:if test="${vo.tel!='-' }">
                        <p class="excert">
                        	전화 : ${vo.tel }
                        </p>
                        </c:if>
                        <p class="excert">
                        	e-mail : ${vo.email } 
                        </p>
                        <c:if test="${vo.webLink!=' ' }">
                          <div class="text-right">
                           <button class="text-right" id="rbtn">
                            <a href="${vo.webLink }">
                              <span>reservation
                              </span>
                            </a>
                           </button>
                          </div>
                        </c:if>
                        <p class="excert">
                        	구사언어 : ${vo.langu } 
                        </p>
                        <p class="excert">
                        	상세정보 : ${vo.info } 
                        </p>
                        <p class="excert">
                        	객실정보 : ${vo.roomInfo } 
                        </p>
                        <p class="excert">
				                        주소 : ${vo.addr }
                        </p>
                        <p class="excert">
                        	교통편 : ${vo.bus } 
                        </p>

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
                           <li><a href="../stay/ghouse.do"><i class="fa fa-list"></i></a></li>
                        </ul>
                       </div>
                     </div>
                       <div class="navigation-area">
                        <div class="row">
                        <c:if test="${(no-1)!=0 }">
                           <div
                              class="col-lg-6 col-md-6 col-12 nav-left flex-row d-flex justify-content-start align-items-center">
                              <div class="thumb">
                                 <a href="../stay/gdetail.do?no=${vo.no-1 }">
                                    <img class="img-fluid" src="../assets/img/post/left-arrow.png" style="width:50px;height:50px">
                                 </a>
                              </div>
                              <div class="arrow">
                                 <a href="../stay/gdetail.do?no=${vo.no-1 }">
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
                                 <a href="../stay/gdetail.do?no=${vo.no+1 }">
                                    <span class="lnr text-white ti-arrow-right"></span>
                                 </a>
                              </div>
                              <div class="thumb">
                                 <a href="../stay/gdetail.do?no=${vo.no+1 }">
                                    <img class="img-fluid" src="../assets/img/post/right-arrow.png" style="width:50px;height:50px">
                                 </a>
                              </div>
                           </div>
                           </c:if>
                        </div>
                     </div>
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
			      <br>
			      <div class="text-center">
		           <button class="text-right" id="rbtn">
		             <a href="../stay/ghouse.do">
		               <span>List
		               </span>
		             </a>
		           </button>
		         </div>
		         
		         <h4 class="text-center">Recommand Food</h4>
		             <c:forEach var="fvo" items="${fList }" varStatus="s">
		               <div style="width:90px; height:90px; border:1px solid white; float:left;">
                         <a href="../food/food_detail.do?no=${fvo.no }">
                           <img src="${fvo.poster }" style="width:90px;height:90px" title="${fvo.rname }">
                         </a>
		               </div>
		             </c:forEach>
		            <br> 
		            <br>
		            <br>
		            <br>
		            <div style="height:130px"></div>
		            <h4 class="text-center">Recommand Nature</h4>
		             <c:forEach var="nvo" items="${nList }" varStatus="s">
		               <div style="width:90px; height:90px; border:1px solid white; float:left;">
                         <a href="../nature/detail.do?no=${nvo.no }">
                           <img src="${nvo.poster }" style="width:90px;height:90px" title="${nvo.title }">
                         </a>
		               </div>
		             </c:forEach>
		           
               </div>
            </div>
         </div>
      </section>
      <!--================ Blog Area end =================-->
</body>
</html>










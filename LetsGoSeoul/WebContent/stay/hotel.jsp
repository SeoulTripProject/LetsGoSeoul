<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
.col-3{
	display: inline;
}
li{
	text-align: left;
}
</style>
</head>
<body>
<!-- Hero Start-->
        <div class="hero-area2 hero-overly2 d-flex align-items-center ">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-xl-8 col-lg-9">
                        <div class="hero-cap text-center pt-50 pb-20">
                            <h2>Hotel</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Hero End -->
        <!-- listing Area Start -->
           <div class="popular-location section-padding30">
             <div class="listing-details-area">
               <div class="container">
                 <div class="row">
	                  <c:forEach var="vo" items="${list }" varStatus="s">
	                   <c:if test="${s.index%4==0 }">
	                   <div class="col-md-3 ">
                        <div class="single-listing mb-30">
	                     <div class="list-img">
	                       <img src="${vo.poster }" style="width:360px;height:251px">
	                          <!-- <span>Open</span> -->
	                     </div>
	                   <div class="list-caption">
	                     <span><a href="../stay/hdetail.do?no=${vo.no}">Open</a></span>
	                      <a href="../stay/hdetail.do?no=${vo.no}"><h5>${vo.sname }</h5></a>
	                     <div class="list-footer">
	                       <ul>
	                        <li>평점&nbsp;&nbsp;${vo.score }</li>
	                       </ul>
	                     </div>
	                   </div>
	                 </div>
	                 </div>
	                 </c:if>
	                 <c:if test="${s.index%4!=0 }">
	                   <div class="col-md-3 ">
                        <div class="single-listing mb-30">
	                     <div class="list-img">
	                       <img src="${vo.poster }" style="width:360px;height:251px">
	                          <!-- <span>Open</span> -->
	                     </div>
	                   <div class="list-caption">
	                     <span><a href="../stay/hdetail.do?no=${vo.no}">Open</a></span>
	                      <a href="../stay/hdetail.do?no=${vo.no}"><h5>${vo.sname }</h5></a>
	                     <div class="list-footer">
	                       <ul>
	                        <li>평점&nbsp;&nbsp;${vo.score }</li>
	                       </ul>
	                     </div>
	                   </div>
	                 </div>
	                </div>
	               </c:if>
	              </c:forEach>
               </div>
             </div>
           </div>
          <!-- listing Details End -->
          <!--Pagination Start  -->
          <div class="pagination-area pt-70 text-center">
              <div class="container">
                  <div class="row">
                      <div class="col-xl-12">
                          <div class="single-wrap d-flex justify-content-center">
                              <nav aria-label="Page navigation example">
                               <ul class="pagination justify-content-start">
						          <c:if test="${curpage>BLOCK }">
						          <li class="page-item"><a href="../stay/hotel.do?page=${startPage-1 }" class="page-link"><span class="ti-angle-left"></span></a></li>
						          </c:if>
						            <c:forEach var="i" begin="${startPage }" end="${ endPage}">
						               <c:if test="${curpage==i }">
						                 <c:set var="ss" value="class=current"/>
						               </c:if>
						               <c:if test="${curpage!=i }">
						                 <c:set var="ss" value=""/>
						               </c:if>
						              <li class="page-item" ${ss }><a class="page-link" href="../stay/hotel.do?page=${i }">${i }</a></li>
						            </c:forEach>  
						            <c:if test="${endPage<totalpage }">
						             <li class="page-item"><a href="../stay/hotel.do?page=${endPage+1 }" class="page-link"><span class="ti-angle-right"></span></a></li>
						            </c:if>
						        </ul>
                              </nav>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
        </div>
        <!-- listing-area Area End -->
        <div id="back-top" >
          <a title="Go to Top" href="#"> <i class="fas fa-level-up-alt"></i></a>
    	</div>
</body>
</html>
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
        <div class="hero-area3 hero-overly2 d-flex align-items-center ">
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
	               
	                 <div class="col-3">
	                  <c:forEach var="vo" items="${list }">
	                   <div class="single-listing mb-30">
	                     <div class="list-img">
	                       <img src="${vo.poster }">
	                          <!-- <span>Open</span> -->
	                     </div>
	                   <div class="list-caption">
	                     <span>Open</span>
	                     <h3><a href="../stay/hotel.do?no=${no}">${vo.sname }</a></h3>
	                     <p>${vo.score }</p>
	                     <div class="list-footer">
	                       <ul>
	                        <li>+10 278 367 9823</li>
	                        <li>contact@midnight.com</li>
	                       </ul>
	                     </div>
	                   </div>
	                 </div>
	                </c:forEach>
	               </div>
	             
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
                                <c:forEach var="i" begin="1" end="${totalpage }">
							        <c:if test="${curpage==i }">
							           <c:set var="ss" value="class=current"/>
							        </c:if>
							        <c:if test="${curpage!=i }">
							           <c:set var="ss" value=""/>
							        </c:if>
							        <li ${ss } class="page-item"><a href="../stay/hotel?page=${i }" class="page-link">${i }</a></li>
							     </c:forEach>
							     <li class="page-item"><a class="page-link" href="../stay/hotel?page=${i+1 }"><span class="ti-angle-right"></span></a></li>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.col-3{
	display: inline;
}
</style>
</head>
<body>
<!-- Hero Start-->
        <div class="hero-area3 hero-overly2 d-flex align-items-center ">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-xl-8 col-lg-9">
                        <div class="hero-cap text-center pt-50 pb-20">
                            <h2>Exhibition</h2>
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
	                   <div class="single-listing mb-30">
	                     <div class="list-img">
	                       <img src="${vo.poster }" style="width:275px;height:191px">
	                          <!-- <span>Open</span> -->
	                     </div>
	                   <div class="list-caption">
	                     <span>Open</span>
	                     <h5><a href="../culture/exhibition.do?no=${no}">${vo.title }</a></h5>
	                     <div class="list-footer">
	                       <ul>
	                        <li>기간&nbsp;&nbsp;${vo.period }</li>
	                       </ul>
	                     </div>
	                   </div>
	                 </div>
	                 </c:if>
	                 <c:if test="${s.index%4!=0 }">
	                   <div class="single-listing mb-30">
	                     <div class="list-img">
	                       <img src="${vo.poster }" style="width:275px;height:191px">
	                          <!-- <span>Open</span> -->
	                     </div>
	                   <div class="list-caption">
	                     <span>Open</span>
	                     <h5><a href="../culture/exhibition.do?no=${no}">${vo.title }</a></h5>
	                     <div class="list-footer">
	                       <ul>
	                        <li>기간&nbsp;&nbsp;${vo.period }</li>
	                       </ul>
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
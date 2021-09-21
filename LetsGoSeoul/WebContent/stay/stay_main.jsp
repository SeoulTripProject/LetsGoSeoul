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
</style>
</head>
<body>

        <div class="hero-area2  slider-height2 hero-overly2 d-flex align-items-center ">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center pt-50">
                            <h2>Stay</h2>
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
                            <h2>Hotel</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                   <c:forEach var="vo" items="${list }">
                    <div class="col-4">
                        <div class="single-location mb-30 inline">
                            <div class="location-img inline">
                                <img src="${vo.poster }" style="width:360px;height:286px">
                            </div>
                            <div class="location-details">
                                <p>${vo.sname }</p>
                                <a href="../stay/hdetail.do?no=${vo.no}" class="location-btn"><i class="ti-plus"></i>Location</a>
                            </div>
                        </div>
                    </div>
                  </c:forEach>
                </div>
                <hr>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-tittle text-center mb-80">
                            <h2>Guest House</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                   <c:forEach var="gvo" items="${list2 }">
                    <div class="col-4">
                        <div class="single-location mb-30 inline">
                            <div class="location-img inline">
                                <img src="${gvo.poster }" style="width:360px;height:286px">
                            </div>
                            <div class="location-details">
                                <p>${gvo.sname }</p>
                                <a href="../stay/gdetail.do?no=${vo.no}" class="location-btn"><i class="ti-plus"></i>Location</a>
                            </div>
                        </div>
                    </div>
                  </c:forEach>
                </div>
                
            </div>
        </div>
        <div id="back-top" >
          <a title="Go to Top" href="#"> <i class="fas fa-level-up-alt"></i></a>
    	</div>
</body>
</html>
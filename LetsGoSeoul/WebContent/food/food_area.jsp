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
<link rel="stylesheet" href="../food/food.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.images').css('cursor','pointer');
	$('.images').click(function(){
		let no=$(this).attr("data-value");
		$.ajax({
			type:'GET',
			url:'../food/location_result.do',
			data:{"no":no},
			success:function(res)
			{
				$('.print').html(res); 
			}
		})
	})
})
</script>
</head>
<body>
        <!-- Hero Start-->
        <div class="hero-area2  slider-height2 hero-overly2 d-flex align-items-center ">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center pt-50">
                            <h2>Explore By Area</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Hero End -->
        <!-- Categories Area Start -->
        <div class="categories-area section-padding30">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <!-- Section Tittle -->
                        <div class="section-tittle text-center mb-80">
                            <span>Exploring By</span>
                            <h2>Areas</h2>
                        </div>
                    </div>
                </div>
				<div class="section-top-border">
					<h3 class="mb-30">Definition</h3>
					<div class="row">
						<div class="col-md-4">
							<div class="single-defination">
				   				<div id="a">
				    				<img id="seoul_1" src="../food/map/1111.png">
									    <%
									       for(int i=1;i<=25;i++)
									       {
									     %>
									         <img id="gu<%=i %>" src="../food/map/gu_<%=i%>_off.png" 
									          onmouseover="this.src='../food/map/gu_<%=i%>_on.png'" 
									          onmouseout="this.src='../food/map/gu_<%=i%>_off.png'" class="images"
									          data-value="<%=i %>"
									         >
									     <%
									       }
									     %>
				            	</div>
				      		 </div>
				  		</div>
				  		<div class="row print">
				  		</div>
        				<c:if test="${vo.no!=0 }">
							<div class="col-md-4">
								<div class="single-defination">
									<h4 class="mb-30" style="margin-left: 30%">Gu</h4>
			                         <c:forEach var="vo" items="${list }">
			                            <div class="location-img">
			                                <img src="${vo.poster }" alt="">
			                            </div>
			                            <div class="location-details">
			                                <p>${vo.rname }</p>
			                                <a href="#" class="location-btn">65 <i class="ti-plus"></i> Location</a>
			                            </div>
			                          </c:forEach>
								</div>
							</div> 
      					</c:if>
					</div> 
                 </div>
            </div>
        </div>
        <!-- Categories Area End -->
</body>
</html>
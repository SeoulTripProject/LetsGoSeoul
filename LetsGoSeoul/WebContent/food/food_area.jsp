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
			type:'get',
			url:'../food/location_result.jsp',
			data:{"no":no},
			success:function(result)
			{
				$('.print').html(result); 
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
					<h3 class="mb-30">Area of Seoul</h3>
					<div class="row">
						<div class="col-md-4">
							<div class="single-defination">
				   				<div id="a">
				    				<img id="seoul_1" src="../food/map/1111.png">
				    					<c:forEach var="i" begin="1" end="25">
									         <img id="gu${i }" src="../food/map/gu_${i }_off.png" 
									          onmouseover="this.src='../food/map/gu_${i }_on.png'" 
									          onmouseout="this.src='../food/map/gu_${i }_off.png'" class="images"
									          data-value="${i }"
									         >
				    					</c:forEach>
				            	</div>
				      		 </div>
				  		</div>
				  		  <div class="row print">
				  		  
						  </div> 
				  </div>
                 </div>
            </div>
        </div>
        <!-- Categories Area End -->
</body>
</html>
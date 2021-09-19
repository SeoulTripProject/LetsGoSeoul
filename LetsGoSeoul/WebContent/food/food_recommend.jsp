<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.rebtn').click(function(){
		let no=$(this).attr("data-no");
		$.ajax({
			type: "post",
			url: '../food/sub_menu.do',
			data: {"no":no},
			success: function(result)
			{
				$('#menu').html(result);
			}
		})
	})
})
</script>
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
        <!-- Hero Start-->
        <div class="hero-area2  slider-height2 hero-overly2 d-flex align-items-center ">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="hero-cap text-center pt-50">
                            <h2>Recommended Restaurants</h2>
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
                            <span>Choose one</span>
                            <h2>Recommendation By Tags</h2>
                        </div>
                    </div>
                </div>
                <div class="wrapper row3" style="margin-left:30%;margin-right:auto;">
				  <main class="container clear"> 
				  <div class="row">
				    <div class="text-center">
				     <div class="button-group-area mt-40">
				          <span class="genric-btn primary radius rebtn" data-no="1">Situations</span>
				          <span class="genric-btn success radius rebtn" data-no="2">Moods</span>
				          <span class="genric-btn info radius rebtn" data-no="3">Preferences</span>
				          <span class="genric-btn warning radius rebtn" data-no="4">Weather</span>
				    </div>
				    </div>
				    <div id="menu">
				    
				    </div>
                    <div id="recommend">
                        	
                    </div>
				  </div>
				  </main>
				  </div>  
            </div>
        </div>
</body>
</html>
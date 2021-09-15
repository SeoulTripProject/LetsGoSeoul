<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#insertbtn').click(function(){
		$('#Frbtn').submit();
	})
})
</script>
<style type="text/css">
.hero-area4 {
  background-image: url(../assets/img/hero/hero2.jpg);
  background-size: cover;
  background-repeat: no-repeat;
  min-height: 105px;
}
</style>
</head>
<body>
<!-- Hero Start-->
        <div class="hero-area4 slider-height2 hero-overly2 d-flex align-items-center">
        </div>
<!--Hero End -->
<!-- ================ contact section start ================= -->
        <section class="contact-section" style="margin-left:25%">
            <div class="container">
                <div class="d-none d-sm-block mb-5 pb-4">   
                </div>
                <div class="row">
                    <div class="col-12">
                        <h2 class="contact-title">FreeBoard</h2>
                    </div>
                    <div class="col-lg-8">
                        <form class="form-contact contact_form" action="../board/freeboard_upok.do" method="post" id="Frbtn" novalidate="novalidate">
                            <div class="row">
                                
                                    <div class="col-sm-6">
                                    <div class="form-group">
                                        <input class="form-control valid" name="name" id="name" type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter your name'" placeholder="Enter your name" value="${vo.name }">
                                        <input type=hidden name=no value="${vo.no }">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <input class="form-control" name="subject" id="subject" type="text" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Subject'" placeholder="Enter Subject" value="${vo.subject }">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <textarea class="form-control w-100" name="content" id="content" cols="30" rows="9" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Content'" placeholder=" Enter Content">${vo.content }</textarea>
                                    </div>
                                </div>
                                
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <input class="form-control valid" name="pwd" id="password" type="password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter password'" placeholder="password">
                                    </div>
                                </div>
                                
                            </div>
                            <div class="form-group mt-3">
                                <input type="submit" class="boxed-btn" value="Edit" id="insertbtn">
                                <input type="button" class="boxed-btn"  onclick="javascript:history.back()" value="Cancel">

                            </div>
                        </form>
                    </div>
                    <div class="col-lg-3 offset-lg-1">
                        <div class="media contact-info">
                            <span class="contact-info__icon"><i class="ti-home"></i></span>
                            <div class="media-body">
                                <h3>Seoul, Korea.</h3>
                                <p>Zoom</p>
                            </div>
                        </div>
                        <div class="media contact-info">
                            <span class="contact-info__icon"><i class="ti-tablet"></i></span>
                            <div class="media-body">
                                <h3>+1 222 222 2222</h3>
                                <p>Mon to Fri 9am to 6pm</p>
                            </div>
                        </div>
                        <div class="media contact-info">
                            <span class="contact-info__icon"><i class="ti-email"></i></span>
                            <div class="media-body">
                                <h3>2team@project.com</h3>
                                <p>Send us your query anytime!</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- ================ contact section end ================= -->
</body>
</html>
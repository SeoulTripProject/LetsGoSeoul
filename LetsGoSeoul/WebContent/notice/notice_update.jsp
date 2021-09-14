<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.hero-area5 {
  background-image: url(../assets/img/hero/hero2.jpg);
  background-size: cover;
  background-repeat: no-repeat;
  min-height: 128px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#insertbtn').click(function(){
		$('#frbtn').submit();
	})
})
</script>
</head>
<body>
<!-- Hero Start-->
   <div class="hero-area5 slider-height2 hero-overly2 d-flex align-items-center">
   </div> 
<!--Hero End -->
<!-- ================ contact section start ================= -->
        <section class="contact-section">
            <div class="container">
                <div class="d-none d-sm-block mb-5 pb-4">   
                </div>
                <div class="row">
                    <div class="col-12">
                        <h2 class="contact-title">Notice</h2>
                    </div>
                    <div class="col-lg-8">
                        <form class="form-contact contact_form" action="../notice/notice_update_ok.do" method="post" id="Frbtn" novalidate="novalidate">
                            <div class="row">
                                <div class="col-12">
                                    <div class="form-group">
                                        <input class="form-control" name="subject" id="subject" type="text" value="${vo.subject }">
                                        <input type=hidden value="${vo.no }" name="no">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <textarea class="form-control w-100" name="content" id="content" cols="30" rows="9">${vo.content }</textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group mt-3">
                                <input type="submit" class="boxed-btn" value="Save Changes" id="insertbtn">
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
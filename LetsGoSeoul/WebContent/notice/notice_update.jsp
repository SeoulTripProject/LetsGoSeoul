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
  background-image: url(../assets/img/hero/river.jpg);
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
        <section class="contact-section" style="margin-left:25%">
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
                </div>
            </div>
        </section>
        <!-- ================ contact section end ================= -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<section class="contact-section" style="margin-left:25%">
  <div class="container">
    <div class="row">
      <div class="col-lg-8">
        <form class="form-contact contact_form" action="../board/freeboard_delok.do" method="post" id="Frbtn" novalidate="novalidate">
          <div class="row">
            <div class="col-sm-6">
              <div class="form-group">
                <input class="form-control valid" name="pwd" id="password" type="password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter password'" placeholder="password">
                <input type=hidden name=no value="${no }">
              </div>
            </div>
          </div>
          <div class="form-group mt-3">
            <input type="submit" class="boxed-btn" value="Delete" id="insertbtn">
            <input type="button" class="boxed-btn"  onclick="javascript:history.back()" value="Cancel">
          </div>
        </form>
      </div>
    </div>
  </div>
</section>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css"> 
form {
  width: 60%;
  margin: 300px auto;
  background: #efefef; 
  padding: 60px 120px 80px 120px;
  text-align: center;
  -webkit-box-shadow: 2px 2px 3px rgba(0,0,0,0.1);
  box-shadow: 2px 2px 3px rgba(0,0,0,0.1);
}
label {
  display: block;
  position: relative;
  margin: 40px 0px;
}
.label-txt {
  position: absolute;
  top: -1.6em;
  padding: 10px;
  font-family: sans-serif;
  font-size: .8em;
  letter-spacing: 1px;
  color: rgb(120,120,120);
  transition: ease .3s;
}
.input {
  width: 100%;
  padding: 10px;
  background: transparent;
  border: none;
  outline: none;
}

.line-box {
  position: relative;
  width: 100%;
  height: 2px;
  background: #BCBCBC;
}

.line {
  position: absolute;
  width: 0%;
  height: 2px;
  top: 0px;
  left: 50%;
  transform: translateX(-50%);
  background: #8BC34A;
  transition: ease .6s;
}

.input:focus + .line-box .line {
  width: 100%;
}

.label-active {
  top: -3em;
}

button {
  display: inline-block;
  padding: 12px 24px;
  background: rgb(220,220,220);
  font-weight: bold;
  color: rgb(120,120,120);
  border: none;
  outline: none;
  border-radius: 3px;
  cursor: pointer;
  transition: ease .3s;
}

button:hover {
  background: #8BC34A;
  color: #ffffff;
}

</style>
</head>
<body>
		<!-- Hero Start-->
		<div class="hero-area2  slider-height2 hero-overly2 d-flex align-items-center">
			<div class="container">
					<div class="row">
						<div class="col-xl-12">
						<div class="hero-cap text-center pt-50">
								<h2>Sign In</h2>
						</div>
						</div>
					</div>
			</div>
		</div>
		<!--Hero End -->
		<form>
		  <label>
		    <p class="label-txt">ID</p>
		    <input type="text" class="input">
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">PASSWORD</p>
		    <input type="password" class="input">
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">CHECK PASSWORD</p>
		    <input type="password" class="input">
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">NAME</p>
		    <input type="text" class="input">
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">GENDER</p>
  	        <input type="radio" value="MAN" name=sex checked>MAN
  	        <input type="radio" value="WOMAN" name=sex>WOMAN
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">BIRTHDAY</p>
		    <input type="date" size=30 name=birthday id=birthday>
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">EMAIL</p>
		    <input type="text" class="input">
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">POSTCODE</p>
  	        <input type="text" name=post1 size=7 class="input" readonly id="post1">-<input type=text id="post2" class="input" name=post2 size=7 readonly>
  	      	<input type=button value="우편번호검색" class="btn btn-sm btn-primary" id=postBtn>
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">ADDRESS</p>
		    <input type="text" class="input" name=addr1 size=55 id=addr1 readonly>
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">DETAILADDRESS</p>
		    <input type="text" class="input" name=addr2 size=55 class="input-sm">
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">TEL</p>
		    <select name=tel1 class="input">
  	      		<option>010</option>
  	      	</select>
  	        <input type="text" name=tel2 size=20 class="input" id=tel2>
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">PREFERENCE</p>
		    <input type="checkbox" name="preference" id="type" class="input">
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  
		  <button type="submit">submit</button>
		</form>
		  	      
  	   
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../shadow/css/shadowbox.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../shadow/js/shadowbox.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
Shadowbox.init({
	players:['iframe']
});
$(function(){
	$('#idBtn').click(function(){
		 Shadowbox.open({
			content:'../member/idcheck.jsp',
			player:'iframe',
			title:'아이디 중복체크',
			width:340,
			height:200
		}); 
	});
	// id,class(javascript/css) ,name(java에 값을 보낸다) 
	$('#postBtn').click(function(){
		 Shadowbox.open({
			content:'../member/postfind.jsp',
			player:'iframe',
			title:'우편번호 찾기',
			width:530,
			height:350
		}); 
	});
	$('#sendBtn').click(function(){
		// NOT NULL => 강제 입력 (오라클에서 오류 방지 => 유효성 검사)
		//alert("click");
		/* let id=$('#id').val();
		if(id.trim()=="")
		{
			$('#id').focus();
			return;
		} */
		
		let pwd=$('#pwd').val();
		if(pwd.trim()=="")
		{
			$('#pwd').focus();
			return;
		}
		let pwd1=$('#pwd1').val();
		if(pwd!=pwd1)
		{
			$('#pwd1').focus();
			return;
		}
		
		// 이름 
		let name=$('#name').val();
		if(name.trim()=="")
		{
			$('#name').focus();
			return;
		}
		// 생년월일
		let birth=$('#birthday').val();
		if(birth.trim()=="")
		{
			$('#birthday').focus();
			return;
		}
		// 이메일
		let email=$('#email').val();
		if(email.trim()=="")
		{
			$('#email').focus();
			return;
		}
		// 주소 
		/* let addr1=$('#addr1').val();
		if(addr1.trim()=="")
		{
			$('#addr1').focus();
			return;
		} */
		
		// 전화번호
		let tel2=$('#tel2').val();
		if(tel2.trim()=="")
		{
			$('#tel2').focus();
			return;
		}
		
		// 정상수행 
		$('#joinFrm').submit();
	})
})
</script>
<style type="text/css"> 
form {
  width: 60%;
  margin: 100px auto;
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
  text-align: left;
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
  padding: 10px;
  background: transparent;
  border: none;
  outline: none;
  display: inline;
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
  background: #131154;
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
  background: #131154;
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
		<form method="post" action="../member/join_ok.do" id="joinFrm" name="joinFrm">
		  <label>
		    <p class="label-txt">ID</p>
		    <br>
		    <input type="text" class="input" name=id size=20 readonly id=id width=30%>
		    <input type=button value="중복체크" id=idBtn class="btn btn-sm btn-danger">
		    <br>
		    <br>
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">PASSWORD</p>
		    <input type="password" class="input" width=100%>
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">CHECK PASSWORD</p>
		    <input type="password" class="input" width=100%>
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">NAME</p>
		    <input type="text" class="input" width=100%>
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">GENDER</p>
		    <br>
  	        <input type="radio" value="MAN" name=sex checked>MAN
  	        <input type="radio" value="WOMAN" name=sex>WOMAN
  	        <br>
  	        <br>
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">BIRTHDAY</p>
		    <br>
		    <input type="date" size=30 name=birthday id=birthday>
		    <br>
		    <br>
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">EMAIL</p>
		    <input type="text" class="input" width=100%>
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">POSTCODE</p>
		    <br>
  	        <input type="text" name=post1 size=7 class="input inline" readonly id="post1">-<input type=text id="post2" class="input inline" name=post2 size=7 readonly>
  	      	<input type=button value="우편번호검색" class="btn btn-sm btn-primary" id=postBtn>
  	      	<br>
  	      	<br>
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  <label>
		    <p class="label-txt">ADDRESS</p>
		    <input type="text" class="input" name=addr1 size=55 id=addr1 readonly width=100%>
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
		    <br>
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
		    <br>
		    <input type="checkbox" name="preference" id="type" class="input">
		    <br>
		    <br>
		    <div class="line-box">
		      <div class="line"></div>
		    </div>
		  </label>
		  
		  <button type="submit" id=sendBtn>JOIN</button>
		</form>
		  	      
  	   
</body>
</html>
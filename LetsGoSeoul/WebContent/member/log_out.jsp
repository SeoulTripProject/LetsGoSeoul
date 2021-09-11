<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	// 로그아웃 처리
	$('#logoutBtn').click(function(){
		location.href="../member/logout.do";
	})
})
</script>
</head>
<body>

</body>
</html>
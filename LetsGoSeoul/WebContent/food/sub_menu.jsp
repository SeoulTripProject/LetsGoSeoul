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
	$('.submenu').click(function(){
		let menu=$(this).text();
		$.ajax({
			type: 'post',
			url: '../food/recommand_result.do',
			data: {"menu":menu},
			success: function(result)
			{
				$('#recommand').html(result);
			}
		})
	})
})
</script>
</head>
<body>
<div class="wrapper row3" style="margin-right:40%;">
	<main class="container clear"> 
	 <div class="text-center">
	  <div class="row">
	  <table class="table">
        <c:forEach var="m" items="${list }">
         <span class="genric-btn default radius submenu">${m }</span>
        </c:forEach>
      </table>
      </div>
     </div>
    </main>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<!--================Blog Area =================-->
      <section class="blog_area single-post-area section-padding" style="margin-left:40%" >
         <div class="container" >
            <div class="row" >
            <form method=post action="../qna/qna_delok.do">
	      <table class="table">
	       <tr>
	         <td class="inline">
	           비밀번호:<input type=password name=pwd size=25 class="input-sm">
	           <input type=hidden name=no value="${no }">
	         </td>
	       </tr>
	       <tr>
	         <td class="text-center">
	           <input type=submit value="삭제" class="genric-btn primary-border radius">
	           <input type=button value="취소" class="genric-btn danger-border radius"
	            onclick="javascript:history.back()">
	         </td>
	       </tr>
	      </table>
      </form>
            </div>
         </div>
      </section>
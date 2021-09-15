<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:choose>
  <c:when test="${bCheck==true }">
    <c:redirect url="../board/freeboard_detail.do?no=${no }"/>
  </c:when>
  <c:otherwise>
    <script>
    alert("Wrong password\nEnter the correct password");
    history.back();
    </script>
  </c:otherwise>
</c:choose>
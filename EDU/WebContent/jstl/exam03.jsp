<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>JSP Standard Tag library</h3>
	<c:set var="num" value="${80 }"></c:set>
	<c:out value="${num }"></c:out>
	
	<c:if test="${num >= 60 }">합격입니다.</c:if>
	<c:if test="${num < 60 }">불합격입니다.</c:if>
	
	<c:choose>
		<c:when test= "${num >= 90 }">A학점</c:when>
		<c:when test= "${num >= 80 }">B학점</c:when>
		<c:when test= "${num >= 70 }">C학점</c:when>
		<c:when test= "${num >= 60 }">D학점</c:when>
		<c:otherwise>F학점</c:otherwise>
	</c:choose>
	

</body>
</html>
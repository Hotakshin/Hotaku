<%@page import="com.edu.beans.BookBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jstl/exam01.jsp</title>
</head>
<body>
<%
	BookBean book = new BookBean();
	book.setAuthor("홍길동");
	book.setPublisher("홍출판사");
	book.setTitle("의적");
%>
<c:set var = "name" value="Hong"></c:set>
<c.out value ="${name }"></c.out>
<p>${name eq 123 }</p>
<c:remove var="name" />

<c:set var="title" value="${Hong.title }"></c:set>
<c:out value="${title }"></c:out>
<p>${Hong }</p>

<c:set var="pub"><%=book.getPublisher() %></c:set>
<c:out value="${pub }"/>
</body>
</html>
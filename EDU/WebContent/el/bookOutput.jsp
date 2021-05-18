<%@page import="com.edu.beans.BookBean"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>el/bookOutput.jsp</title>
</head>
<body>
<%
	BookBean book = (BookBean) request.getAttribute("book");
%>
<h1>정상적으로 처리되었습니다.</h1>
<p>책제목:${book.title}</p>
<p>책저자:${book.author }</p>
<p>출판사:${book.publisher }</p>
</body>
</html>
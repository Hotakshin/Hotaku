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
<h1>���������� ó���Ǿ����ϴ�.</h1>
<p>å����:${book.title}</p>
<p>å����:${book.author }</p>
<p>���ǻ�:${book.publisher }</p>
</body>
</html>
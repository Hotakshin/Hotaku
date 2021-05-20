<%@page import="com.edu.beans.BookBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jstl/exam04.jsp</title>
</head>
<body>
<%
	List<BookBean> bookList = new ArrayList<>();
	bookList.add(new BookBean("title1","author1","pub1"));
	bookList.add(new BookBean("title2","author2","pub2"));
	request.setAttribute("list",bookList);
//	for (BookBean book : bookList) {
//		out.print(book.getTitle());
//		out.print(book.getAuthor());
//		out.print(book.getPublisher());
//	}
//	for (int i = 0; i < 5; i++){
		
//	}



%>

	<h3>forEach 반복문</h3>
	<c:forEach items="${list }" var="book">
		<p>${book.title }/ ${book.author } / ${book.publisher }</p></c:forEach>

	<c:forEach begin="2" end="9" var="val">
	<c:forEach begin="1" end="9" var="num">
		<p>${val } * ${num } = ${val * num }</p></c:forEach>
		</c:forEach>
</body>
</html>
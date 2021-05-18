<%@page import="com.edu.beans.BookBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:set var="num" value="${85 }"/>
���� <c:out value="${num }"/> ��
<c:if test="${num gt 60 }">�հ��Դϴ�.</c:if>
<c:if test="${num lt 60 }">���հ�</c:if>

<c:choose>
	<c:when test="${num >= 90 }">A����</c:when>
	<c:when test="${num ge 80 }">B����</c:when>
	<c:when test="${num >= 70 }">C����</c:when>
	<c:otherwise>F����</c:otherwise>
</c:choose>

<%
	ArrayList<BookBean> blist = new ArrayList<>();
	blist.add(new BookBean("title1","author1","pub1"));
	blist.add(new BookBean("title2","author2","pub2"));
	blist.add(new BookBean("title3","author3","pub3"));
//	for (BookBean book : list) {
//		out.print("title" + book.getTitle());
//	}
	request.setAttribute("list", blist);
%>
	<c:forEach items="${list }" var="item">
		${item.title } / ${item.author } / ${item.publisher }<br>
	</c:forEach>
</body>
</html>
<%@page import="java.util.List"%>
<%@page import="com.edu.test.stateless.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList.jsp</title>
</head>
<body>
	<table border="1">
		<%
		List<Member> list = (List<Member>) request.getAttribute("memberList");
		for (Member mem : list) {
			out.print("<tr>");
			out.print("<td> ID : " + mem.getMemberId() + " </td> <td> Name :  " + mem.getMemberName() + "</td>");
			out.print("</tr>");
		}
		%>
	</table>
</body>
</html>
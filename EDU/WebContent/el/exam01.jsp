<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language(/el/exam01.jsp)</title>
</head>
<body>
<%
//	String name = "hello";
//	request.setAttribute("name",name);
	
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
<%=name %>/<%=age %>
${param.name } / ${param.age }

</body>
</html>
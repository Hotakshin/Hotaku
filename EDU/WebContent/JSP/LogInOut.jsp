<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/LogInOut.jsp</title>
</head>
<body>
	<%
	String msg = (String) request.getAttribute("err");
	if (msg == null) {
		msg = "";
	}
	%>
	
	<%
		if (session.getAttribute("info") == null) { 
	%>
		<form action="LogInfo.jsp" method="POST">
			ID : <input type="text" name="id"><br> 비밀번호 : <input
				type="password" name="pwd"><br> <input type="submit"
				value="로그인">
		</form>
	<%
		} else{
	%>
		<a href="LogInfo.jsp">로그아웃.</a>
	<%
		}
	%>
	<h4 style="color: red"><%=msg%></h4>
	


</body>
</html>
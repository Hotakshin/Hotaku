<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/Example01.jsp</title>
</head>
<body>
	<%!
	String name;
	public int sum(int a, int b) {
		return a + b;
	}%>
	<%
	// 주석문장
	/*
		--------------------------------------------
		ㅎㄱㄷㅁㅁ돔옴ㅇㄱㅎㅁㄱ오목휴ㅜ륛흇ㄱㄴ
	*/
	String user = request.getParameter("name");
	if (user == null) {
		user = "Guest";
	}
	int result = sum(10, 20);
	%>
	<!-- HTML 주석 -->
	<h1>
		Hello
		<%=user%></h1>
	<h2>
		결과 :
		<%=result%></h2>
</body>
</html>
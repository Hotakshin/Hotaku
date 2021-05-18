<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example07.jsp ::: 스크립트릿(애플릿, 서블릿)</title>
<style>
table {
	border-collapse: collapse;
}
</style>
</head>
<body>
<%! // 멤버 변수와 메소드 지정할때 !	
	
%>

	<h1>구구단</h1>
	<h3>table 이용</h3>
	<table border="1">
	<%
		for (int i = 1; i < 10; i++) {
	%>
		<tr>
			<%
			for (int j = 2; j < 10; j++) {
			%>
			<td><%=j%>*<%=i%> = <%=j * i%></td>
			<%
			}
			%>
		</tr>
		<%
		}
	%>
	</table>
</body>
</html>
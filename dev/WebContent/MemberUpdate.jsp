<%@page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>MemberUpdate.jsp</title>
</head>
<body>
	<form action="MemberSearch.do" method="post">
		ID : <input type="text" name="id">
		<input type="hidden" name="job" value="update">
		<input type="submit" value="조회">
	</form>
	
	<%
		MemberVO member = (MemberVO) request.getAttribute("member");
		if(member != null){
			// 입력화면...
			%>
			<form action="MemberUpdate.do" method="post">
			아이디 : <input type="text" name="id" value="<%=member.getId()%>" readonly/><br>
			비밀번호 : <input type="password" name="passwd" value="<%=member.getPasswd() %>"><br>
			이름 : <input type="text" name="name" value="<%=member.getName()%>"><br>
			메일 : <input type="email" name="mail" value="<%=member.getMail()%>"><br>
			<input type="submit" value="수정">
			</form>
			<%
		} else {
			// 조회된 결과 X;
			%>
			<h3>조회결과 없습니다.</h3>
			<%
		}
	%>
</body>
</html>
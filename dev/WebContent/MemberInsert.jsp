<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>회원가입 페이지</h3>
<form action="MemberInsert.do" method="post">
	아이디 : <input type="text" name="id"><br>
	비밀번호 : <input type="password" name="passwd"><br>
	이름 : <input type="text" name="name"><br>
	메일 : <input type="email" name="mail"><br>
	<input type="submit" value="등록">
	</form>
</body>
</html>
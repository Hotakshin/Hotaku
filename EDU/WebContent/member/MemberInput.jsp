<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>사용자 등록(memberInput.jsp)</title>
</head>
<body>
	<form action="MemberProc.do" method="post">
	ID : <input type="text" name="id">
	PW : <input type="password" name="passwd">
	Name : <input type="ext" name="name">
	Mail : <input type="email" name="mail">
	<input type="submit" value="등록">
	</form>
<!-- MVC 
		Model : 클래스(Member) , 서비스(Service), 디비처리(DAO)
		View: 사용자에게 화면 (jsp)
		Controller: jsp,servlet
		
		MemberInput.jsp(입력화면)
		>> memberProc.jsp(사용자입력 처리)
		>> MemberService.java(서비스로직)
		>> MemberDAO.java
		>> OracleDBMS
		>> memberOutput.jsp(출력화면) -->
</body>
</html>
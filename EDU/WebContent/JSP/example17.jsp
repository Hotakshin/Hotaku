<%@page import="com.edu.test.stateless.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example17.jsp</title>
</head>
<body>
	<%
		String id = request.getParameter("memberId");
		String pw = request.getParameter("memberPwd");
		String nm = request.getParameter("memberName");
		String ag = request.getParameter("memberAge");
	
		Member member1 = new Member();
		
		member1.setMemberId(id);
		member1.setMemberPwd(pw);
		member1.setMemberName(nm);
		member1.setMemberAge(Integer.parseInt(ag));
		
		out.print(member1.getMemberId() + "<br />");
		out.print(member1.getMemberPwd() + "<br />");
		out.print(member1.getMemberName() + "<br />");
		out.print(member1.getMemberAge()+ "<br />-------------------<br />") ;
	%>
	<jsp:useBean id="member2" class="com.edu.test.stateless.Member"></jsp:useBean>
	<jsp:setProperty property="*" name="member2"/>
	
	<jsp:getProperty property="memberId" name="member2"/><br>
	<jsp:getProperty property="memberPwd" name="member2"/><br>
	<jsp:getProperty property="memberName" name="member2"/><br>
	<jsp:getProperty property="memberAge" name="member2"/><br>
</body>
</html>
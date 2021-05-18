<%@page import="com.edu.test.stateless.Member"%>
<%@page import="com.edu.test.stateless.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// DB조회 후 가져온 Member 확인 후 이름 , 나이를 출력
	//					없으면 "해당 사용자 없음" 출력.
	MemberDAO dao = new MemberDAO();
	Member member = new Member();
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	member = dao.checkInfo(id, pwd);

	String name = member.getMemberName();
	int age = member.getMemberAge();
	%>
	<%
	//String 객체의 equals로 비교
		if(request.getMethod().equals("POST")) {// post로 했는지 get으로 했는지 읽어옴 / Post이면 로그인
			if (member == null || member.getMemberId() == null) {
				out.print("<h3>사용자 정보가 없습니다.</h3>");
			} else {
				session.setAttribute("info", member);
				out.print("<h3> 이름 : " + member.getMemberName() + "<br />나이 : " + member.getMemberAge() + "</h3>");
			}
		}else{ // Get이면 로그아웃
			session.invalidate(); // 세션삭제
			out.print("로그아웃 됨");
		}
	%>
</body>
</html>
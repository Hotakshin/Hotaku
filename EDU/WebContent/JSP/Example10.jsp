<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP/Example10.jsp</title>
</head>
<body>
	<%
	String rId = null;
	String name = null;
	String pwd = null;
	int age = 0;
	String id = request.getParameter("id");
	pwd = request.getParameter("pwd");
	if (id == null) {
		id = (String) session.getAttribute("id");
	}
	if (pwd == null) {
		pwd = (String) session.getAttribute("pwd");
	}
	if (id.isEmpty() || pwd.isEmpty()) {
		request.setAttribute("err", "ID, 비밀번호 입력하세요");
		RequestDispatcher rd = request.getRequestDispatcher("LogInOut.jsp");
		rd.forward(request, response);
		return;
	}
	// 로그인 처리
	if (session.isNew() || session.getAttribute("id") == null) {
		session.setAttribute("id", id);
		session.setAttribute("pwd", pwd);
		session.setAttribute("name", "홍길동");
		session.setAttribute("age", 15);
		out.print("로그인 작업이 완료.");
	} else {
		out.print("이미 로그인 상태 입니다.");
		rId = (String) session.getAttribute("id");
		name = (String) session.getAttribute("name");
		age = (int) session.getAttribute("age");
	}
	%>

	<h3>
		ID :
		<%=id%>
	</h3>
	<h3>
		이름 :
		<%=name%>
	</h3>
	<h3>
		나이 :
		<%=age%>
	</h3>
</body>
</html>
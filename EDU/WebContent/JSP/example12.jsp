<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/example12.jsp</title>
</head>
<body>
<h1>Example12.jsp</h1>
<%-- <%@ include file = "example01.jsp" %>  --%>
<%!
	
	public void work(String p, PageContext pc) {
		
		try{
			JspWriter out = pc.getOut();
			if(p.equals("include")) {
				out.print("include 전");
				pc.include("Example07.jsp");
			} else if(p.equals("forward")){
				pc.forward("Example02.jsp");
			}
		}catch(Exception e){
			System.out.println("오류발생");
		}
	}
	
	
%>

<%
	String p = request.getParameter("p");
	this.work(p, pageContext);
%>
</body>
</html>
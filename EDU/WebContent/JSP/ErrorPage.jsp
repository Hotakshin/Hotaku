<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- ErrorPage.jsp -->
<%@page errorPage="Example03.jsp"%>

<%
	String name = request.getParameter("id");
	if(name.equals("user")){
		name = "정상처리 됨.";
	}
	out.print(name);
%>

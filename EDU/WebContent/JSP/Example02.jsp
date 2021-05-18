<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

JSP 프로그래밍

<% Date date = new Date(); %>
<% 
	List<String> list = new ArrayList<>(); 
	out.print(date);
%>
<%@page import="com.edu.beans.BookDAO"%>
<%@page import="com.edu.beans.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String title = request.getParameter("title");
	String author = request.getParameter("author");
	String publisher = request.getParameter("publisher");
	
	out.print(title);
	out.print(author);
	out.print(publisher);
	
	//디비에 입력처리 .. 
	BookDAO dao = new BookDAO();
	BookBean book = new BookBean();
	
	
	book.setAuthor(author);
	book.setPublisher(publisher);
	book.setTitle(title);
	
	dao.insertBook(book);
	request.setAttribute("book",book);
	
	RequestDispatcher rd = request.getRequestDispatcher("bookOutput.jsp");
	rd.forward(request, response);
%>
	
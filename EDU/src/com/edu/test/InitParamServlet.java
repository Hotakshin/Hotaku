package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InitParamServlet extends HttpServlet{
	String id, password;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		id = config.getInitParameter("id"); // web.xml의 InitParam 태그 안의 name값이 id의 값 들고옴
		password = config.getInitParameter("password"); 
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<h3>" + id + "</h3>");
		out.print("<h3>" + password + "</h3>");
	}
}

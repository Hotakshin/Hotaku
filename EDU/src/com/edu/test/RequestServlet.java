package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String met = request.getMethod();
		System.out.println(met);
		String name = request.getParameter("name");
		String id = request.getParameter("user_id");
		String age = request.getParameter("user_age");

		
		PrintWriter out = response.getWriter();
		if(met.equals("GET")) {
			out.print("<table border='1'>");
			out.print("<tr><td>이름</td><td>"+name+"</td></tr>");
			out.print("<tr><td>아이디</td><td>"+id+"</td></tr>");
			out.print("<tr><td>나이</td><td>"+age+"</td></tr>");
			out.print("</table>");
		}else {
			System.out.println("POST");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}

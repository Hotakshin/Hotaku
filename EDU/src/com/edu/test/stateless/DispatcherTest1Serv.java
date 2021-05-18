package com.edu.test.stateless;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher1")
public class DispatcherTest1Serv extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String param = req.getParameter("p");
		if(param == null || param.isEmpty()) {	// 필드가 비어 있거나 다른 오류가 발생하는 경우 1(true)을 반환
			param = "Null";
		}
		
		out.print("<h3>Dispatcher 수행 1</h3>");
		ServletContext sc = this.getServletContext(); // application 단위 (edu 전체에서 관리하는 객체)
		RequestDispatcher rd = sc.getRequestDispatcher("/dispatcher2"); // 페이지를 요청한 페이지의 정보를 들고와서 처리해주는 기능??+
		req.setAttribute("data1", "Good");
		req.setAttribute("data2", param);
		rd.forward(req, resp);
		
		out.close();
	}
}

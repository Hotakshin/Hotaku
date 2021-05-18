package com.edu.test.stateless;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context3")
public class ServletContextTest3Servl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ServletContext -> 값을 읽어오도록. Obj1, Obj2
		ServletContext sc = this.getServletContext();
		ShareObjeck so1 = (ShareObjeck) sc.getAttribute("data1");
		ShareObjeck so2 = (ShareObjeck) sc.getAttribute("data2");
		System.out.println(so1.getCount() + " , " + so1.getStr());
		System.out.println(so2.getCount() + " , " + so2.getStr());
		
		// 값을 지정 해준 servlet 먼저 실행 해야된다.
	}
	
}

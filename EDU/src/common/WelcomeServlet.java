package common;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcomeServlet")
public class WelcomeServlet extends HttpServlet {
	// Servlet (InterFace) => GenericSerlvet(추상클래스) => HttpServlet
	// 제일 먼저 init 실행 -> 2. service -> destroy(소멸자) 
	private static final long serialVersionUID = 1L;

	public WelcomeServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException { // 첫번째
		// TODO Auto-generated method stub
		System.out.println("init()");
	}
	
//	@Override
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("service(1)");
//		doGet(req, res);
//	}
//	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("service(2)");
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

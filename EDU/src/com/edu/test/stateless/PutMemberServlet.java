package com.edu.test.stateless;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberRegister")
public class PutMemberServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		// DB에서 리스트 => memberList.jsp
		MemberDAO dao = new MemberDAO();
		List<Member> list = dao.getMemberList();

		RequestDispatcher re = req.getRequestDispatcher("memberList.jsp");
		req.setAttribute("memberList", list);
		re.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		// parameter를 읽어서 DB에 insert, memberResult.jsp 페이지로 재실행
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		// 읽어와서

		MemberDAO dao = new MemberDAO();

		System.out.println("DB에 입력되었습니다.");
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPwd(pwd);
		member.setMemberName(name);
		member.setMemberAge(Integer.parseInt(age));
		dao.insertMember(member);
		// set

//		this.getServletContext();	// ServletContext가 가지고 있는 RequestDispatcher 사용하기 위함
		RequestDispatcher rd = req.getRequestDispatcher("memberResult.jsp");
		req.setAttribute("member", member);
		rd.forward(req, resp);
	}
}

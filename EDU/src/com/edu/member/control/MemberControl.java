package com.edu.member.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.member.model.MemberService;
import com.edu.member.model.MemberVO;

@WebServlet("/member/MemberProc.do")
public class MemberControl extends HttpServlet {
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 // 사용자의 입력 -> Oracle 저장 -> 처리결과 (memberOutPut.jsp)
	   
	
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	String mail = request.getParameter("mail");
	   
	   MemberVO member = new MemberVO();
	   member.setId(id);
	   member.setPasswd(passwd);
	   member.setName(name);
	   member.setMail(mail);
	   
	   // 서비스 로직 (MemberService.java)
	   // DB 처리 (MemberDAO.java)
	   MemberService service = new MemberService();
	   service.memberInsert(member);
	   
	   request.setAttribute("member", member);

	   
	   // 처리결과 memberOutPut.jsp
	   
	   RequestDispatcher rd = request.getRequestDispatcher("MemberOutput.jsp");
	   rd.forward(request, response);
}
}

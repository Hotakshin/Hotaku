package com.edu.member.model;

public class MemberService {

		//c처리하는 로직
		//입력,조회,수정,삭제 기능 구현. *(실제 파일, 디비 X)
	MemberDAO dao = new MemberDAO();
	
	public void memberInsert(MemberVO member) {
		//기능을 구현.
		dao.insertMember(member);
	}
}

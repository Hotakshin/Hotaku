package com.dev.service;

import java.util.List;

import com.dev.dao.MemberDAO;
import com.dev.vo.MemberVO;

public class MemberService {
	
	private static MemberService service = new MemberService();
	private MemberService() {
		
	}
	public static MemberService getInstance() {
		return service;
	}
	
	//입력, 수정, 삭제, 조회, 리스트
	public void memberInsert(MemberVO member) {
		MemberDAO dao = MemberDAO.getInstance();
		dao.insertMember(member);
		
		
	}
	public MemberVO memberSearch(String id) {
		MemberDAO dao = MemberDAO.getInstance();
		return dao.searchMember(id);
	}
	public MemberVO memberSearch() {
		
		return null;
		
	}
	
	public void memberUpdate(MemberVO member) {
		MemberDAO dao = MemberDAO.getInstance();
		dao.updateMember(member);
		
	}
	
	public void memberDelete(String id) {
		MemberDAO dao = MemberDAO.getInstance();
		dao.deleteMember(id);
	}
	public List<MemberVO> memberList() {
		MemberDAO dao = MemberDAO.getInstance();
		return dao.listMember();
	}
}

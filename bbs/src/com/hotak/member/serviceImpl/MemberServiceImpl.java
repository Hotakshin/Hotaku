package com.hotak.member.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hotak.common.DAO;
import com.hotak.member.service.MemberService;
import com.hotak.member.vo.MemberVO;

public class MemberServiceImpl extends DAO implements MemberService {

	PreparedStatement psmt;
	ResultSet rs;
	
	// id 중복 체크 메소드 / 중복 존재하면 true / 아닐때 false
	public boolean idCheck(String id) {
		boolean exist = false;
		String sql = "select id from member where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				exist = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return exist;
	}
	public void close() {
		if (rs != null)
			try {
				psmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		if (psmt != null)
			try {
				psmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}

		if (conn != null)
			try {
				psmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}

	}
	@Override
	public List<MemberVO> selectMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO selectMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(MemberVO vo) {
		String sql = "insert into member(id,name,passwd,address) values(?,?,?,?)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			// 각각 ?,?,?,? 지정
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getPwd());
			psmt.setString(4, vo.getAddr());
			r = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return r;
	}

	@Override
	public int updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}

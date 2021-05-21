package com.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dev.vo.MemberVO;

public class MemberDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	private static MemberDAO dao = new MemberDAO();

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {

		return dao;
	}

	// 연결처리 Connection 객체
	private void connect() {
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// close
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DB처리 기능
	public void insertMember(MemberVO member) {
		connect();
		String sql = "insert into member_b(id, name, passwd, mail) values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getPasswd());
			psmt.setString(4, member.getMail());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public MemberVO searchMember(String id) {
		connect();
		String sql = "select * from member_b where id=?";
		MemberVO member = null; // MemberVO member = null;
		try {
			psmt = conn.prepareStatement(sql); // psmt 객체
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setMail(rs.getString("mail"));
				member.setName(rs.getString("name"));
				member.setPasswd(rs.getString("passwd"));
				System.out.println(rs.getString("passwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return member;
	}

	// 회원정보수정
	public void updateMember(MemberVO member) {
		connect();
		String sql = "update member_b set PassWD = ?, Name = ?,Mail = ? Where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(4, member.getId());
			psmt.setString(2, member.getName());
			psmt.setString(1, member.getPasswd());
			psmt.setString(3, member.getMail());
			System.out.println(member.getId());
			System.out.println(member.getName());
			System.out.println(member.getPasswd());
			System.out.println(member.getMail());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public void deleteMember(String id) {
		connect();
		String sql = "delete from member_b where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public List<MemberVO> listMember() {
		connect();
		String sql = "select * from member_b order by 1";
		List<MemberVO> memberList = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql); // psmt 객체
			rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setMail(rs.getString("mail"));
				member.setName(rs.getString("name"));
				member.setPasswd(rs.getString("passwd"));
				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return memberList;
	}
}

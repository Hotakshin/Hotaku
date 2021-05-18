package com.edu.test.stateless;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	public MemberDAO() {
//		DataSource ds = DataSource.getInstance(); // DB 연결
//		conn = ds.getConnection();
		//Connection Poll 을 활용해서 Connection 객체 사용
		try {
			InitialContext ic = new InitialContext(); // 서버의 리소스를 관리하는 객체
			javax.sql.DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertMember(Member mem) {
		String sql = "insert into member values(?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem.getMemberId());
			psmt.setString(2, mem.getMemberName());
			psmt.setInt(3, mem.getMemberAge());
			psmt.setString(4, mem.getMemberPwd());
			int n = psmt.executeUpdate();
			if (n != 0) {
				System.out.println("한건 입력.");
			} else {
				System.out.println("실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public List<Member> getMemberList() {
		String sql = "select * from member order by 1";
		List<Member> list = new ArrayList<Member>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Member mem = new Member();
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberPwd(rs.getString("member_pwd"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberAge(rs.getInt("member_age"));

				list.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public Member checkInfo(String id, String pwd) {
		// id pwd 조회해서 한건 가져와서 Member
		Member mem = new Member();
		String sql = "select * from member where MEMBER_ID = ? and MEMBER_PWD = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			rs = psmt.executeQuery();
			if(rs.next()) {
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberAge(rs.getInt("member_age"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return mem;
	}

	// 한건조회
	public Member getMember(String id) {
		// id 조회해서 한건 가져와서 Member
		Member mem = new Member();
		String sql = "select * from member where MEMBER_ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberAge(rs.getInt("member_age"));
				mem.setMemberPwd(rs.getString("member_pwd"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return mem;
	}
	
	public void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

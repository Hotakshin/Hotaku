package userProj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBcon;



public class UserDAO {
	
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	public UserVO getInsertUser(UserVO vo) {
	conn = DBcon.getConnect();
	String sql = "insert into user_temp values(?,?,?,?,?)";
	UserVO user = new UserVO();
	
	try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, vo.getUser_id());
		psmt.setString(2, vo.getUser_name());
		psmt.setString(3, vo.getUser_pass());
		psmt.setString(4, vo.getUser_phone());
		psmt.setString(5, vo.getUser_gender());
		int r = psmt.executeUpdate();
		System.out.println(r + " 건 입력 되었습니다.");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
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
		return vo;
	}
	public List<UserVO> getUserList() {
		conn = DBcon.getConnect();
		List<UserVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("select * from user_temp");
			rs = psmt.executeQuery();
			while (rs.next()) {
				UserVO vo = new UserVO();
				vo.setUser_id(rs.getString("user_id"));
				vo.setUser_name(rs.getString("user_name"));
				vo.setUser_pass(rs.getString("user_pass"));
				vo.setUser_phone(rs.getString("user_phone"));
				vo.setUser_gender(rs.getString("user_gender"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
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
		return list;
	}
	public UserVO getDelectKeyVal(String user_id) {
		conn = DBcon.getConnect();
		// 신규번호 , 한건입력, 한건조회
		System.out.println(user_id);
		String sql = "delete from user_temp where user_id =?";
		UserVO vo = new UserVO();
		try {
			// 키값을 가져오는 부분.
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			int r = psmt.executeUpdate();
			System.out.println(r + " 개의 정보 제거됌");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
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

		return vo;
	}
	
}

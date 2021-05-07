package fileBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBCon;

public class FileDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	public FileVO getFile(int num) { // num값으로 한건 조회.
		conn = DBCon.getConnect();
		String sql = "select * from file_board where num = ?";
		FileVO file = new FileVO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			if (rs.next()) {
				file.setAuthor(rs.getString("author"));
				file.setDay(rs.getString("day"));
				file.setFileName(rs.getString("file_name"));
				file.setNum(rs.getInt("num"));
				file.setTitle(rs.getString("title"));
			}
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

		return file;
	}

	public List<FileVO> getFileList() {
		conn = DBCon.getConnect();
		List<FileVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("select * from file_board");
			rs = psmt.executeQuery();
			while (rs.next()) {
				FileVO vo = new FileVO();
				vo.setAuthor(rs.getString("author"));
				vo.setDay(rs.getString("day"));
				vo.setFileName(rs.getString("file_name"));
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		return list;
	}

	int key = 0;

	public FileVO getInsertKeyVal(FileVO vo) {
		conn = DBCon.getConnect();
		// 신규번호 , 한건입력, 한건조회
		String selectKey = "select nvl(max(num),0)+1 from file_board";
		String insertSql = "insert into file_board values(?,?,?,?,to_char(sysdate,'yyyy-mm-dd'))";
		String selectSql = "select * from file_board where num =?";
		FileVO file = new FileVO();
		try {
			// 키값을 가져오는 부분.
			psmt = conn.prepareStatement(selectKey);
			rs = psmt.executeQuery();
			if (rs.next()) {
				key = rs.getInt(1);
			}
			// 새로운 키값으로 한건 입력.
			psmt = conn.prepareStatement(insertSql);
			psmt.setInt(1, key);
			psmt.setString(2, vo.getAuthor());
			psmt.setString(3, vo.getTitle());
			psmt.setString(4, vo.getFileName());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되엇습니다.");
			// 신규입력된 전체 정보 가져오기
			psmt = conn.prepareStatement(selectSql);
			psmt.setInt(1, key);
			rs = psmt.executeQuery();
			if (rs.next()) {
				file.setAuthor(rs.getString("author"));
				file.setDay(rs.getString("day"));
				file.setFileName(rs.getString("file_name"));
				file.setNum(rs.getInt("num"));
				file.setTitle(rs.getString("title"));
			}
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

		return file;
	}
	public FileVO getDelectKeyVal(int num) {
		conn = DBCon.getConnect();
		// 신규번호 , 한건입력, 한건조회
		String sql = "delete from file_board where num =?";
		FileVO vo = new FileVO();
		try {
			// 키값을 가져오는 부분.
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			int r = psmt.executeUpdate();
			System.out.println(r + " 개의 사진 제거됌");
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
	
	public boolean updateFile(FileVO vo) {
		conn = DBCon.getConnect();
		int modifyCnt = 0;
		String sql = "update file_board set author=?,title=?,file_name=nvl(?, file_name) where num=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getAuthor());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getFileName());
			psmt.setInt(4, vo.getNum());
			modifyCnt = psmt.executeUpdate();
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
		
		return modifyCnt == 0 ? false : true;
	}
	
}

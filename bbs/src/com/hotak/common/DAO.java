package com.hotak.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.hotak.member.vo.MemberVO;

public class DAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "bbs";
	private String passwd = "bbs";
	public Connection conn;

	public DAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException|ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

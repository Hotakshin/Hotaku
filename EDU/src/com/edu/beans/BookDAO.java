package com.edu.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
// 전체리스트 , 신규입력 , 수정, 삭제 - DBMS에 저장 및 수정
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
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
	// 제목조회
	public BookBean getBook(String title) {
		String sql = "select * from book where title = ?";
		conn = DAO.connet();
		BookBean book = new BookBean();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			rs = psmt.executeQuery();
			if(rs.next()) {
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return book;
	}
	
	
	//전체리스트 조회
	public List<BookBean> getBookList(){
		String sql = "select * from book";
		conn = DAO.connet();
		List<BookBean> bookList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BookBean book = new BookBean();
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setTitle(rs.getString("title"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return bookList;
	}
	//저자별 책 조회
	
	public List<BookBean> getBooksByAuthor(String Author) {
		String sql = "select * from book where Author = ?";
		List<BookBean> bookList = new ArrayList<>();
		BookBean book = new BookBean();
		conn = DAO.connet();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getAuthor());
//			psmt.setString(1, Author);
			rs = psmt.executeQuery();
			while (rs.next()) {
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setTitle(rs.getString("title"));
				bookList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return bookList;
		
	}
	
	//한건 입력
	
	public void insertBook(BookBean book ) {
		String sql = "insert into book values(?,?,?)";
		conn = DAO.connet();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getTitle());
			psmt.setString(2, book.getAuthor());
			psmt.setString(3, book.getPublisher());
			System.out.println(book.getTitle());
			int r = psmt.executeUpdate();
			   if(r != 0 ) {
		            System.out.println(r + "건 입력");
		         }else {
		            System.out.println("실패");
		         }

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
}



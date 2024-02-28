package com.spring.board.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcUtil {
	
//	DB 접속을 위한 정보 저장
	static String id = "root";
	static String pass = "111111";
	static String url = "jdbc:mysql://localhost:3306/cattabledb?characterEncoding=utf-8";
	
	//JDBC 이용을 위한 객체
	Connection conn = null;
	PreparedStatement  pstmt = null;
	ResultSet rs = null;
	
	public static Connection getConnection() {	
		
		try {
			//mySql 디비를 사용하기 위한 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 로딩 완료 !!");
			
			//디비 연결 !!
			return DriverManager.getConnection(url, id, pass);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;		
	}

	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		
		if(conn != null) {
			try {
				if(!conn.isClosed()) {
					conn.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
		
		if(pstmt != null) {
			try {
				if(!pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				pstmt = null;
			}
		}
		
		if(rs != null) {
			try {
				if(!rs.isClosed()) {
					rs.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}		
	}
	
}

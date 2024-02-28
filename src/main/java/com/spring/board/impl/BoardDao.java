package com.spring.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.spring.board.common.JdbcUtil;

@Repository("boardDao")
public class BoardDao {
	//디비 처리를 위한 객체 선언
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
    //1. 디비에 데이터 저장하는 메소드 
	public void insertBoard(BoardDo bdo) {
		System.out.println("insertBoard() ==> ");
		
		//디비서버연결!!
		conn = JdbcUtil.getConnection();
		String sql = "insert into board values (null, ?, ?, ? )";
		
		try {
			//sql 문 완성!!
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bdo.getName());
			pstmt.setString(2, bdo.getBirth());
			pstmt.setString(3, bdo.getAdopted());
			
			//sql 문 실행
			pstmt.executeUpdate();
			
			//디비 연결 끊기
			JdbcUtil.close(conn, pstmt, rs);
			
			System.out.println("insertBoard() 처리 완료 !! ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	//2. 디비에 저장되어 있는 모든 데이터를 가져오는 메소드 
	public ArrayList<BoardDo> getBoardList(){
		System.out.println("getBoardList() ==> ");
		ArrayList<BoardDo> bList = new ArrayList<BoardDo>();
		
		//디비연결
		conn = JdbcUtil.getConnection();
		//sql문 완성
		String sql = "select * from board";
		
		try {			
			pstmt = conn.prepareStatement(sql);
			
			//??? 없어서, 바로 sql문 실행
			//전체 데이터를 읽어오는 sql문 실행이기 때문에, 
			//ResultSet으로 받아줌...
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDo bdo = new BoardDo();
				bdo.setSeq(rs.getInt(1));
				bdo.setName(rs.getString(2));
				bdo.setBirth(rs.getString(3));
				bdo.setAdopted(rs.getString(4));				
				bList.add(bdo);
			}
			//디비연결 종료
			JdbcUtil.close(conn, pstmt, rs);
			System.out.println("getBoardList() 처리 완료 !!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return bList;
	}
	
	//3. 디비에 저장되어 있는 데이터 중에, 특정 데이터를 가져오는 메소드
	//(seq = 1 인 데이터 가져오기)
	public BoardDo getBoard(BoardDo bdo) {
		System.out.println("getBoard() ==> ");
		BoardDo temp = new BoardDo();
		
		//디비 연결
		conn = JdbcUtil.getConnection();
		//sql문 완성 
		String sql = "select * from board where seq=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bdo.getSeq());
			
			//sql문 실행 및 결과처리
			rs= pstmt.executeQuery();
			while(rs.next()) {
				temp.setSeq(rs.getInt(1));
				temp.setName(rs.getString(2));
				temp.setBirth(rs.getString(3));
				temp.setAdopted(rs.getString(4));			
			}
			//연결 해제
			JdbcUtil.close(conn, pstmt, rs); 
			System.out.println("getBoard() 처리 성공 !!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return temp;
	}
		
	//4. 디비에 데이터 수정 하기 
	public void updateBoard(BoardDo bdo) {
		System.out.println("updateBoard() ==> ");
		
		conn = JdbcUtil.getConnection();
		String sql = "update board set Name=?, Adopted=? where seq=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bdo.getName());
			pstmt.setString(2, bdo.getAdopted());
			pstmt.setInt(3, bdo.getSeq());
			
			pstmt.executeUpdate();
			
			JdbcUtil.close(conn, pstmt, rs);
			System.out.println("updateBoard() 처리 완료 !! ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//5. 디비 데이터 삭제 
	public void deleteBoard(BoardDo bdo) {
		System.out.println("deleteBoard() ==> ");
		conn = JdbcUtil.getConnection();
		String sql = "delete from board where seq=?";		
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setInt(1, bdo.getSeq());
			
			pstmt.executeUpdate();
			
			JdbcUtil.close(conn, pstmt, rs);
			System.out.println("deleteBoard() 처리 완료 !! ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//6. 디비에서 키워드를 이용하여 검색
	public ArrayList<BoardDo> searchBoardList(String searchCon, String searchKey){
		System.out.println("searchBoardList() ==> ");
		
		ArrayList<BoardDo> bList = new ArrayList<BoardDo>();
		
		//디비연결
		conn = JdbcUtil.getConnection();
		//sql문 완성
		String sql = "";
		if(searchCon.equals("name"))
			sql = "select * from board where name like ?";
		else if(searchCon.equals("birth"))	
			sql = "select * from board where birth like ?";
		else if(searchCon.equals("adopted"))	
			sql = "select * from board where adopted like ?";
		else
			System.out.println("searchCon Error !! ");		
		
		try {			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchKey + "%");
			
			//??? 없어서, 바로 sql문 실행
			//전체 데이터를 읽어오는 sql문 실행이기 때문에, 
			//ResultSet으로 받아줌...
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDo bdo = new BoardDo();
				bdo.setSeq(rs.getInt(1));
				bdo.setName(rs.getString(2));
				bdo.setBirth(rs.getString(3));
				bdo.setAdopted(rs.getString(4));				
				bList.add(bdo);
			}
			//디비연결 종료
			JdbcUtil.close(conn, pstmt, rs);
			System.out.println("searchBoardList() 처리 완료 !!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return bList;
	}
	//7. 오름차순 내림차순에 따라 보드 새롭게 정렬
		public ArrayList<BoardDo> sortBoardList(String sortCon){
			System.out.println("sortBoardList() ==> ");
			ArrayList<BoardDo> bList = new ArrayList<BoardDo>();
			
			//디비연결
			conn = JdbcUtil.getConnection();
			//sql문 완성
			String sql = "";
			if(sortCon.equals("asc"))
				sql = "select * from board order by seq asc";
			else if(sortCon.equals("desc"))
				sql = "select * from board order by seq desc";
			else
				System.out.println("비정상적 접근!");
			
			try {			
				pstmt = conn.prepareStatement(sql);
				
				//??? 없어서, 바로 sql문 실행
				//전체 데이터를 읽어오는 sql문 실행이기 때문에, 
				//ResultSet으로 받아줌...
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					BoardDo bdo = new BoardDo();
					bdo.setSeq(rs.getInt(1));
					bdo.setName(rs.getString(2));
					bdo.setBirth(rs.getString(3));
					bdo.setAdopted(rs.getString(4));				
					bList.add(bdo);
				}
				//디비연결 종료
				JdbcUtil.close(conn, pstmt, rs);
				System.out.println("sortBoardList() 처리 완료 !!");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			return bList;
		}
}

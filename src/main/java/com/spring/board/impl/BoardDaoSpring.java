package com.spring.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.board.common.JdbcUtil;

@Repository("boardDaoSpring")
public class BoardDaoSpring {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	//디비 처리를 위한 객체 선언
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
    //1. 디비에 데이터 저장하는 메소드 
	public void insertBoard(BoardDo bdo) {
		System.out.println("[Spring JDBC] insertBoard() ==> ");
		
		String sql = "insert into board values (null, ?, ?, ? )";
		jdbcTemplate.update(sql, bdo.getName(), bdo.getBirth(), bdo.getAdopted());
			
	}
		
	
	//2. 디비에 저장되어 있는 모든 데이터를 가져오는 메소드
	public ArrayList<BoardDo> getBoardList(){
	System.out.println("[spring JDBC] getBoardList() ==> ");
	 
	//sql문 완성 
	String sql = "select * from board"; return (ArrayList<BoardDo>)
	jdbcTemplate.query(sql, new BoardRowMapper()); }
	
	
	//3. 디비에 저장되어 있는 데이터 중에, 특정 데이터를 가져오는 메소드
	//(seq = 1 인 데이터 가져오기)
	// --> spring JDBC를 이용하여 수정함. 
	// 이때 사용하는 메소드는 queryForObject(spl, args, RowMapper<T>) 
	public BoardDo getBoard(BoardDo bdo) {
		System.out.println("[spring JDBC] getBoard() ==> ");
		//sql문 완성 
		String sql = "select * from board where seq=?";
		Object[] args = {bdo.getSeq()};
		return jdbcTemplate.queryForObject(sql,args, new BoardRowMapper());
	}
		
	//4. 디비에 데이터 수정 하기 
	public void updateBoard(BoardDo bdo) {
		System.out.println("[spring JDBC] updateBoard() ==> ");
		
		String sql = "update board set Name=?, Adopted=? where seq=?";
		jdbcTemplate.update(sql, 
							bdo.getName(), 
				 			bdo.getAdopted(),
				 			bdo.getSeq());
	}
	
	//5. 디비 데이터 삭제 
	public void deleteBoard(BoardDo bdo) {
		System.out.println("[spring JDBC] deleteBoard() ==> ");
	
		String sql = "delete from board where seq=?";
		jdbcTemplate.update(sql, bdo.getSeq());
			
	}

	//6. 디비에서 키워드를 이용하여 검색
	public ArrayList<BoardDo> searchBoardList(String searchCon, String searchKey){
		System.out.println("[spring JDBC] searchBoardList() ==> ");
		
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
		Object[] args = {"%"+searchKey+"%"};
		return (ArrayList<BoardDo>) jdbcTemplate.query(sql, args, new BoardRowMapper());
		
	
	}
	
	//7. 디비 seq 번호에 따라 오름차순, 내림차순 정렬
	public ArrayList<BoardDo> sortBoardList(String sortCon){
		System.out.println("[spring JDBC] sortBoardList() ==> ");
		
		//sql문 완성
		String sql = "";
		if(sortCon.equals("asc"))
			sql = "select * from board order by seq asc";
		else if(sortCon.equals("desc"))
			sql = "select * from board order by seq desc";
		else
			System.out.println("비정상적인 접근!");
		return (ArrayList<BoardDo>) jdbcTemplate.query(sql, new BoardRowMapper());
	}
}


class BoardRowMapper implements RowMapper<BoardDo> {
	@Override
	public BoardDo mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("[spring JDBC] mapRow() --> ");
		BoardDo board = new BoardDo();
		board.setSeq(rs.getInt(1));
		board.setName(rs.getString(2));
		board.setBirth(rs.getString(3));
		board.setAdopted(rs.getString(4));		
		return board;
	}
}

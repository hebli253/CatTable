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
	
	
	//��� ó���� ���� ��ü ����
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
    //1. ��� ������ �����ϴ� �޼ҵ� 
	public void insertBoard(BoardDo bdo) {
		System.out.println("[Spring JDBC] insertBoard() ==> ");
		
		String sql = "insert into board values (null, ?, ?, ? )";
		jdbcTemplate.update(sql, bdo.getName(), bdo.getBirth(), bdo.getAdopted());
			
	}
		
	
	//2. ��� ����Ǿ� �ִ� ��� �����͸� �������� �޼ҵ�
	public ArrayList<BoardDo> getBoardList(){
	System.out.println("[spring JDBC] getBoardList() ==> ");
	 
	//sql�� �ϼ� 
	String sql = "select * from board"; return (ArrayList<BoardDo>)
	jdbcTemplate.query(sql, new BoardRowMapper()); }
	
	
	//3. ��� ����Ǿ� �ִ� ������ �߿�, Ư�� �����͸� �������� �޼ҵ�
	//(seq = 1 �� ������ ��������)
	// --> spring JDBC�� �̿��Ͽ� ������. 
	// �̶� ����ϴ� �޼ҵ�� queryForObject(spl, args, RowMapper<T>) 
	public BoardDo getBoard(BoardDo bdo) {
		System.out.println("[spring JDBC] getBoard() ==> ");
		//sql�� �ϼ� 
		String sql = "select * from board where seq=?";
		Object[] args = {bdo.getSeq()};
		return jdbcTemplate.queryForObject(sql,args, new BoardRowMapper());
	}
		
	//4. ��� ������ ���� �ϱ� 
	public void updateBoard(BoardDo bdo) {
		System.out.println("[spring JDBC] updateBoard() ==> ");
		
		String sql = "update board set Name=?, Adopted=? where seq=?";
		jdbcTemplate.update(sql, 
							bdo.getName(), 
				 			bdo.getAdopted(),
				 			bdo.getSeq());
	}
	
	//5. ��� ������ ���� 
	public void deleteBoard(BoardDo bdo) {
		System.out.println("[spring JDBC] deleteBoard() ==> ");
	
		String sql = "delete from board where seq=?";
		jdbcTemplate.update(sql, bdo.getSeq());
			
	}

	//6. ��񿡼� Ű���带 �̿��Ͽ� �˻�
	public ArrayList<BoardDo> searchBoardList(String searchCon, String searchKey){
		System.out.println("[spring JDBC] searchBoardList() ==> ");
		
		//sql�� �ϼ�
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
	
	//7. ��� seq ��ȣ�� ���� ��������, �������� ����
	public ArrayList<BoardDo> sortBoardList(String sortCon){
		System.out.println("[spring JDBC] sortBoardList() ==> ");
		
		//sql�� �ϼ�
		String sql = "";
		if(sortCon.equals("asc"))
			sql = "select * from board order by seq asc";
		else if(sortCon.equals("desc"))
			sql = "select * from board order by seq desc";
		else
			System.out.println("���������� ����!");
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

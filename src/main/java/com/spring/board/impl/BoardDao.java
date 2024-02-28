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
	//��� ó���� ���� ��ü ����
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
    //1. ��� ������ �����ϴ� �޼ҵ� 
	public void insertBoard(BoardDo bdo) {
		System.out.println("insertBoard() ==> ");
		
		//��񼭹�����!!
		conn = JdbcUtil.getConnection();
		String sql = "insert into board values (null, ?, ?, ? )";
		
		try {
			//sql �� �ϼ�!!
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bdo.getName());
			pstmt.setString(2, bdo.getBirth());
			pstmt.setString(3, bdo.getAdopted());
			
			//sql �� ����
			pstmt.executeUpdate();
			
			//��� ���� ����
			JdbcUtil.close(conn, pstmt, rs);
			
			System.out.println("insertBoard() ó�� �Ϸ� !! ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	//2. ��� ����Ǿ� �ִ� ��� �����͸� �������� �޼ҵ� 
	public ArrayList<BoardDo> getBoardList(){
		System.out.println("getBoardList() ==> ");
		ArrayList<BoardDo> bList = new ArrayList<BoardDo>();
		
		//��񿬰�
		conn = JdbcUtil.getConnection();
		//sql�� �ϼ�
		String sql = "select * from board";
		
		try {			
			pstmt = conn.prepareStatement(sql);
			
			//??? ���, �ٷ� sql�� ����
			//��ü �����͸� �о���� sql�� �����̱� ������, 
			//ResultSet���� �޾���...
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDo bdo = new BoardDo();
				bdo.setSeq(rs.getInt(1));
				bdo.setName(rs.getString(2));
				bdo.setBirth(rs.getString(3));
				bdo.setAdopted(rs.getString(4));				
				bList.add(bdo);
			}
			//��񿬰� ����
			JdbcUtil.close(conn, pstmt, rs);
			System.out.println("getBoardList() ó�� �Ϸ� !!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return bList;
	}
	
	//3. ��� ����Ǿ� �ִ� ������ �߿�, Ư�� �����͸� �������� �޼ҵ�
	//(seq = 1 �� ������ ��������)
	public BoardDo getBoard(BoardDo bdo) {
		System.out.println("getBoard() ==> ");
		BoardDo temp = new BoardDo();
		
		//��� ����
		conn = JdbcUtil.getConnection();
		//sql�� �ϼ� 
		String sql = "select * from board where seq=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bdo.getSeq());
			
			//sql�� ���� �� ���ó��
			rs= pstmt.executeQuery();
			while(rs.next()) {
				temp.setSeq(rs.getInt(1));
				temp.setName(rs.getString(2));
				temp.setBirth(rs.getString(3));
				temp.setAdopted(rs.getString(4));			
			}
			//���� ����
			JdbcUtil.close(conn, pstmt, rs); 
			System.out.println("getBoard() ó�� ���� !!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return temp;
	}
		
	//4. ��� ������ ���� �ϱ� 
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
			System.out.println("updateBoard() ó�� �Ϸ� !! ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//5. ��� ������ ���� 
	public void deleteBoard(BoardDo bdo) {
		System.out.println("deleteBoard() ==> ");
		conn = JdbcUtil.getConnection();
		String sql = "delete from board where seq=?";		
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setInt(1, bdo.getSeq());
			
			pstmt.executeUpdate();
			
			JdbcUtil.close(conn, pstmt, rs);
			System.out.println("deleteBoard() ó�� �Ϸ� !! ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//6. ��񿡼� Ű���带 �̿��Ͽ� �˻�
	public ArrayList<BoardDo> searchBoardList(String searchCon, String searchKey){
		System.out.println("searchBoardList() ==> ");
		
		ArrayList<BoardDo> bList = new ArrayList<BoardDo>();
		
		//��񿬰�
		conn = JdbcUtil.getConnection();
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
		
		try {			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchKey + "%");
			
			//??? ���, �ٷ� sql�� ����
			//��ü �����͸� �о���� sql�� �����̱� ������, 
			//ResultSet���� �޾���...
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDo bdo = new BoardDo();
				bdo.setSeq(rs.getInt(1));
				bdo.setName(rs.getString(2));
				bdo.setBirth(rs.getString(3));
				bdo.setAdopted(rs.getString(4));				
				bList.add(bdo);
			}
			//��񿬰� ����
			JdbcUtil.close(conn, pstmt, rs);
			System.out.println("searchBoardList() ó�� �Ϸ� !!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return bList;
	}
	//7. �������� ���������� ���� ���� ���Ӱ� ����
		public ArrayList<BoardDo> sortBoardList(String sortCon){
			System.out.println("sortBoardList() ==> ");
			ArrayList<BoardDo> bList = new ArrayList<BoardDo>();
			
			//��񿬰�
			conn = JdbcUtil.getConnection();
			//sql�� �ϼ�
			String sql = "";
			if(sortCon.equals("asc"))
				sql = "select * from board order by seq asc";
			else if(sortCon.equals("desc"))
				sql = "select * from board order by seq desc";
			else
				System.out.println("�������� ����!");
			
			try {			
				pstmt = conn.prepareStatement(sql);
				
				//??? ���, �ٷ� sql�� ����
				//��ü �����͸� �о���� sql�� �����̱� ������, 
				//ResultSet���� �޾���...
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					BoardDo bdo = new BoardDo();
					bdo.setSeq(rs.getInt(1));
					bdo.setName(rs.getString(2));
					bdo.setBirth(rs.getString(3));
					bdo.setAdopted(rs.getString(4));				
					bList.add(bdo);
				}
				//��񿬰� ����
				JdbcUtil.close(conn, pstmt, rs);
				System.out.println("sortBoardList() ó�� �Ϸ� !!");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			return bList;
		}
}

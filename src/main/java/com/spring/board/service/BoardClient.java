package com.spring.board.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.board.common.JdbcUtil;
import com.spring.board.impl.BoardDo;

public class BoardClient {

	public static void main(String[] args) {		
		//JdbcUtil jUtil = new JdbcUtil();
		//��� ���� (�׽�Ʈ) !! 
		//jUtil.getConnection();
		
		ApplicationContext context = 
		new ClassPathXmlApplicationContext("boardSetting.xml");
		
		BoardService bService = (BoardService) context.getBean("boardService");
		
		//1. DO �̿��Ͽ� ������ �����Ŀ�, ��� ����
//		BoardDo bdo = new BoardDo();
//		bdo.setTitle("title3");
//		bdo.setWriter("writer3");
//		bdo.setContent("content3");
//		
//		bService.insertBoard(bdo);
		
		//2. ��ü ������ ����� ����
		ArrayList<BoardDo> bList = bService.getBoardList();
		for(BoardDo bdo: bList) {
			System.out.println(" --> " + bdo.toString());
		}
		
		//3. �ϳ��� ������ �����ͼ� ����� ���� 
		BoardDo temp = new BoardDo();
		temp.setSeq(3);
		BoardDo temp2 = bService.getBoard(temp);
		System.out.println(" getBoard() -> " + temp2.toString());
		
		//4. �����ϱ� 
		temp.setSeq(1);
		temp.setName("name ����");
		temp.setBirth("birth ����");
		bService.updateBoard(temp);
		temp2 = bService.getBoard(temp);
		System.out.println(" getBoard() -> " + temp2.toString());
		
		//5. �����ϱ� 
		temp.setSeq(3);
		bService.deleteBoard(temp);
		//���̵� sql���� ��� Ȯ��
		
		
	}

}

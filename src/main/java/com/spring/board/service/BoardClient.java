package com.spring.board.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.board.common.JdbcUtil;
import com.spring.board.impl.BoardDo;

public class BoardClient {

	public static void main(String[] args) {		
		//JdbcUtil jUtil = new JdbcUtil();
		//디비 연결 (테스트) !! 
		//jUtil.getConnection();
		
		ApplicationContext context = 
		new ClassPathXmlApplicationContext("boardSetting.xml");
		
		BoardService bService = (BoardService) context.getBean("boardService");
		
		//1. DO 이용하여 데이터 저장후에, 디비에 저장
//		BoardDo bdo = new BoardDo();
//		bdo.setTitle("title3");
//		bdo.setWriter("writer3");
//		bdo.setContent("content3");
//		
//		bService.insertBoard(bdo);
		
		//2. 전체 데이터 출력해 보기
		ArrayList<BoardDo> bList = bService.getBoardList();
		for(BoardDo bdo: bList) {
			System.out.println(" --> " + bdo.toString());
		}
		
		//3. 하나의 데이터 가져와서 출력해 보기 
		BoardDo temp = new BoardDo();
		temp.setSeq(3);
		BoardDo temp2 = bService.getBoard(temp);
		System.out.println(" getBoard() -> " + temp2.toString());
		
		//4. 수정하기 
		temp.setSeq(1);
		temp.setName("name 수정");
		temp.setBirth("birth 수정");
		bService.updateBoard(temp);
		temp2 = bService.getBoard(temp);
		System.out.println(" getBoard() -> " + temp2.toString());
		
		//5. 삭제하기 
		temp.setSeq(3);
		bService.deleteBoard(temp);
		//하이디 sql에서 결과 확인
		
		
	}

}

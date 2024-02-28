package com.spring.board.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.board.service.BoardService;

@Service("boardService")
public class BoardServiceimpl implements BoardService{
	
//	BoardDao 타입의 객체의 생성되어 있으면, 자동으로 주입(DI) 을 해주는 어노테이션 (중요!!)
	@Autowired
	private BoardDao bdao;
	
	@Override
	public void insertBoard(BoardDo bdo) {
		bdao.insertBoard(bdo);
	}
	
	@Override
	public ArrayList<BoardDo> getBoardList() {		
		return bdao.getBoardList();
	}

	@Override
	public BoardDo getBoard(BoardDo bdo) {
		// TODO Auto-generated method stub
		return bdao.getBoard(bdo);
	}

	@Override
	public void updateBoard(BoardDo bdo) {
		bdao.updateBoard(bdo);
	}

	@Override
	public void deleteBoard(BoardDo bdo) {		
		bdao.deleteBoard(bdo);
	}

}

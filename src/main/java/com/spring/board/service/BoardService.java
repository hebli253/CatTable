package com.spring.board.service;

import java.util.ArrayList;

import com.spring.board.impl.BoardDo;

public interface BoardService {
	
	//데이터 저장
	void insertBoard(BoardDo bdo);

	//전체 데이터 가져오기 
	ArrayList<BoardDo> getBoardList();
	
	//하나의 데이터 가져오기 
	BoardDo getBoard(BoardDo bdo);
	
	//데이터 수정하기 
	void updateBoard(BoardDo bdo);
	
	//데이터 삭제하기 
	void deleteBoard(BoardDo bdo);

}

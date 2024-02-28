package com.spring.board.service;

import java.util.ArrayList;

import com.spring.board.impl.BoardDo;

public interface BoardService {
	
	//������ ����
	void insertBoard(BoardDo bdo);

	//��ü ������ �������� 
	ArrayList<BoardDo> getBoardList();
	
	//�ϳ��� ������ �������� 
	BoardDo getBoard(BoardDo bdo);
	
	//������ �����ϱ� 
	void updateBoard(BoardDo bdo);
	
	//������ �����ϱ� 
	void deleteBoard(BoardDo bdo);

}

package com.spring.cattable.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.board.impl.BoardDao;
import com.spring.board.impl.BoardDo;

public class GetBoardListController implements Controller{

	@Override
	public ModelAndView handleRequest( HttpServletRequest request, 
									   HttpServletResponse response) throws Exception {
		System.out.println("GetBoardListController --> ");
		
		//1. ��� �����Ͽ� ������ ó�� (BoardDo, BoardDao �̿�)
		//BoardDo bdo = new BoardDo();
		BoardDao bdao = new BoardDao();		
		ArrayList<BoardDo> bList = bdao.getBoardList();
		
		//����� ������ ���������� üũ!! 
		for(BoardDo bdo: bList) {
			System.out.println(" --> " + bdo.toString());
		}
		
		//2. ��� �̿� ó���� �����͸� �� ȣ���ϸ鼭, 
		// ������ ����(ModelAndView �̿�)
		
		ModelAndView mav = new ModelAndView();
		//bList �̸� ���� ������ ó���� bList ������ ����� �� ���� 
		mav.addObject("bList", bList);
		//�� �������� ���ؼ�, /WEB-INF/~~~ + getBoardListView + .jsp 
		mav.setViewName("getBoardListView");
			
		
		return mav;
	}

}

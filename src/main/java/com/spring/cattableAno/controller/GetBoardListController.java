package com.spring.cattableAno.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.impl.BoardDao;
import com.spring.board.impl.BoardDo;

//@Controller
public class GetBoardListController{

//	<prop key="/getBoardList.do"> getBoardList </prop>
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardDo bdo, 
									 BoardDao bdao,
									 ModelAndView mav ){
		System.out.println("GetBoardListController(Ano) --> ");		
		//1. ��� �����Ͽ� ������ ó�� (BoardDo, BoardDao �̿�)
		ArrayList<BoardDo> bList = bdao.getBoardList();		
		//����� ������ ���������� üũ!! 
		for(BoardDo board: bList) {
			System.out.println(" --> " + board.toString());
		}		
		//2. ��� �̿� ó���� �����͸� �� ȣ���ϸ鼭, 
		// ������ ����(ModelAndView �̿�)
		//bList �̸� ���� ������ ó���� bList ������ ����� �� ���� 
		mav.addObject("bList", bList);
		//�� �������� ���ؼ�, /WEB-INF/~~~ + getBoardListView + .jsp 
		mav.setViewName("getBoardListView");	
		
		return mav;
	}

}

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
		
		//1. 디비 연동하여 데이터 처리 (BoardDo, BoardDao 이용)
		//BoardDo bdo = new BoardDo();
		BoardDao bdao = new BoardDao();		
		ArrayList<BoardDo> bList = bdao.getBoardList();
		
		//제대로 데이터 가져오는지 체크!! 
		for(BoardDo bdo: bList) {
			System.out.println(" --> " + bdo.toString());
		}
		
		//2. 디비 이용 처리된 데이터를 뷰어를 호출하면서, 
		// 데이터 전달(ModelAndView 이용)
		
		ModelAndView mav = new ModelAndView();
		//bList 이름 으로 위에서 처리한 bList 데이터 결과를 뷰어에 전달 
		mav.addObject("bList", bList);
		//뷰 리졸버에 의해서, /WEB-INF/~~~ + getBoardListView + .jsp 
		mav.setViewName("getBoardListView");
			
		
		return mav;
	}

}

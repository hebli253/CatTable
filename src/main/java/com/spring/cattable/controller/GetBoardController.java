package com.spring.cattable.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.board.impl.BoardDao;
import com.spring.board.impl.BoardDo;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
									  HttpServletResponse response) throws Exception {
		System.out.println("GetBoardController --> ");
		//1. seq 변수에 데이터 가져오기 		
		//<a href="getBoard.do?seq=${board.seq}" >${board.title}</a> 
		int seq = Integer.parseInt(request.getParameter("seq"));
		System.out.println("seq : " + seq);
		
		//2. 디비로 부터 데이터 가져오기
		BoardDo bdo = new BoardDo();
		bdo.setSeq(seq);
		
		BoardDao bdao = new BoardDao();
		BoardDo board = bdao.getBoard(bdo);
		
		//3. ModelAndView 이용하여 뷰어에게 데이터 전달해서 출력 하기 
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("getBoardView");

		return mav;
	}

}

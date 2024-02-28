package com.spring.cattableAno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.impl.BoardDao;
import com.spring.board.impl.BoardDo;

//@Controller
public class GetBoardController {
	//<prop key="/getBoard.do"> getBoard </prop>
	@RequestMapping(value="/getBoard.do")
	public ModelAndView getBoard(BoardDo bdo,
								 BoardDao bdao,
								 ModelAndView mav) {
		System.out.println("GetBoardController(Ano) --> ");
		System.out.println("seq : " + bdo.getSeq());
		
		BoardDo board = bdao.getBoard(bdo);
		mav.addObject("board", board);
		mav.setViewName("getBoardView");
		
		return mav;
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, 
//									  HttpServletResponse response) throws Exception {
//		System.out.println("GetBoardController --> ");
//		//1. seq 변수에 데이터 가져오기 		
//		//<a href="getBoard.do?seq=${board.seq}" >${board.title}</a> 
//		int seq = Integer.parseInt(request.getParameter("seq"));
//		System.out.println("seq : " + seq);
//		
//		//2. 디비로 부터 데이터 가져오기
//		BoardDo bdo = new BoardDo();
//		bdo.setSeq(seq);
//		
//		BoardDao bdao = new BoardDao();
//		BoardDo board = bdao.getBoard(bdo);
//		
//		//3. ModelAndView 이용하여 뷰어에게 데이터 전달해서 출력 하기 
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("board", board);
//		mav.setViewName("getBoardView");
//
//		return mav;
//	}

}

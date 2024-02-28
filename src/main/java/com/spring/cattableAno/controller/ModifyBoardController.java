package com.spring.cattableAno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.impl.BoardDao;
import com.spring.board.impl.BoardDo;

//@Controller
public class ModifyBoardController {
	
	//<prop key="/modifyBoard.do"> modifyBoard </prop>
	@RequestMapping(value="/modifyBoard.do")
	public ModelAndView modifyBoard(BoardDo bdo,
									BoardDao bdao,
									ModelAndView mav) {
		System.out.println("ModifyController(Ano) --> ");
		System.out.println("seq : " + bdo.getSeq());
		
		BoardDo board = bdao.getBoard(bdo);
		mav.addObject("board", board);
		mav.setViewName("modifyBoardView");
		
		return mav;
	}
	

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("ModifyController --> ");
//		
//		int seq = Integer.parseInt(request.getParameter("seq"));
//		BoardDo bdo = new BoardDo();
//		bdo.setSeq(seq);
//		
//		BoardDao bdao = new BoardDao();
//		BoardDo board = bdao.getBoard(bdo);
//		
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("board", board);
//		mav.setViewName("modifyBoardView");
//		
//		return mav;
//	}

}

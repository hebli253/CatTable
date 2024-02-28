package com.spring.cattableAno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.impl.BoardDao;
import com.spring.board.impl.BoardDo;

//public class InsertBoardController implements Controller{

//@Controller
public class InsertBoardController {
	
	//<prop key="/insertBoard.do"> insertBoard </prop>
	@RequestMapping(value="/insertBoard.do")
	public ModelAndView insertBoard(BoardDo bdo,
									BoardDao bdao,
									ModelAndView mav) {
		
		System.out.println("InsertBoardController(Ano) --> ");
		mav.setViewName("insertBoardView");
		
		return mav;
	}
	

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("InsertBoardController --> ");
//		//1. 해당 컨트롤러는 뷰어만 호출하는 기능
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("insertBoardView");
//		
//		return mav;
//	}

}

package com.spring.cattableAno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.impl.BoardDao;
import com.spring.board.impl.BoardDo;

//@Controller
public class DeleteBoardController{
	
	//<prop key="/deleteBoard.do"> deleteBoard </prop>
	@RequestMapping(value="/deleteBoard.do")
	public ModelAndView deleteBoard(BoardDo bdo,
									BoardDao bdao,
									ModelAndView mav) {
		System.out.println("DeleteBoardController(Ano) --> ");
		
		bdao.deleteBoard(bdo);
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}
	
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("DeleteBoardController --> ");
//		
//		//1. ���޵Ǵ� seq ���� Ȯ��
//		int seq = Integer.parseInt(request.getParameter("seq"));
//		//System.out.println("seq : " + seq);
//		
//		//2. seq �� �ش�Ǵ� �����͸� ��񿡼� ����
//		BoardDo bdo = new BoardDo();
//		bdo.setSeq(seq);
//		
//		BoardDao bdao = new BoardDao();
//		bdao.deleteBoard(bdo);
//		
//		//3. ��ü ����Ʈ ����(������ ������ ����)
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		
//		return mav;
//	}

}

package com.spring.cattable.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.board.impl.BoardDao;
import com.spring.board.impl.BoardDo;

public class DeleteBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("DeleteBoardController --> ");
		
		//1. ���޵Ǵ� seq ���� Ȯ��
		int seq = Integer.parseInt(request.getParameter("seq"));
		//System.out.println("seq : " + seq);
		
		//2. seq �� �ش�Ǵ� �����͸� ��񿡼� ����
		BoardDo bdo = new BoardDo();
		bdo.setSeq(seq);
		
		BoardDao bdao = new BoardDao();
		bdao.deleteBoard(bdo);
		
		//3. ��ü ����Ʈ ����(������ ������ ����)
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}

}

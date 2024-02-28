package com.spring.cattableAno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.impl.BoardDao;
import com.spring.board.impl.BoardDo;

//<prop key="/insertBoardProc.do"> insertBoardProc </prop>

//@Controller
public class InsertBoardProcController{
	
	@RequestMapping(value="/insertBoardProc.do")
	public ModelAndView insertBoardProc(BoardDo bdo,
										BoardDao bdao,
										ModelAndView mav) {
		
		System.out.println("InsertBoardProcController(Ano) --> ");
		
		//1. Ŭ���̾�Ʈ�� ���� ���޵Ǵ� ������ ��������
//		System.out.println("title : " + bdo.getTitle());
//		System.out.println("writer : " + bdo.getWriter());
//		System.out.println("content : " + bdo.getContent());
		
		bdao.insertBoard(bdo);
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}
	
	
	

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("InsertBoardProcController --> ");
//	
//		//1. Ŭ���̾�Ʈ�� ���� ���޵Ǵ� ������ �������� 
//		String writer = request.getParameter("writer");
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		System.out.println( "title : " + title + 
//							", writer : " + writer + 
//							", content : " + content );
//		
//		//2. ��� ���޵� ������ ����
//		BoardDo bdo = new BoardDo();
//		bdo.setTitle(title);
//		bdo.setWriter(writer);
//		bdo.setContent(content);
//		
//		BoardDao bdao = new BoardDao();
//		bdao.insertBoard(bdo);
//		
//		//3. ��ü �Խ��� �����ֱ� ȣ���ϱ� 
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		
//		return mav;
//	}

}

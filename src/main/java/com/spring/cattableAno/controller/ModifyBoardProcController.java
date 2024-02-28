package com.spring.cattableAno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.impl.BoardDao;
import com.spring.board.impl.BoardDo;

//@Controller
public class ModifyBoardProcController {
	
	//<prop key="/modifyBoardProc.do"> modifyBoardProc </prop>
	@RequestMapping(value="/modifyBoardProc.do")
	public ModelAndView modifyBoardProc(BoardDo bdo,
										BoardDao bdao,
										ModelAndView mav ) {
		System.out.println("ModifyBoardProcController(Ano) --> ");
		
		System.out.println("seq : " + bdo.getSeq() + 
					   ", Name : " + bdo.getName() +
					   ", Adopted : " + bdo.getAdopted() );
		bdao.updateBoard(bdo);
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}
	

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, 
//									  HttpServletResponse response) throws Exception {
//		System.out.println("ModifyBoardProcController --> ");
//		
//		//1. ������ �����͸� �������� 
//		int seq = Integer.parseInt(request.getParameter("seq"));
//		String Name = request.getParameter("Name");
//		String Adopted = request.getParameter("Adopted");
//		
////		System.out.println("seq : " + seq + 
////						   ", Name : " + Name +
////						   ", Adopted : " + Adopted);
//		
//		//2. ������ �����͸� ��� ���� 
//		BoardDo bdo = new BoardDo();
//		bdo.setSeq(seq);
//		bdo.setName(Name);
//		bdo.setAdopted(Adopted);
//		
//		BoardDao bdao = new BoardDao();
//		bdao.updateBoard(bdo);
//		
//		//3. ��� ������ �Ŀ�, getBoardList.do ȣ���Ͽ�, 
//		// ������ �����Ͱ� ���Ե� ��ü ����Ʈ �����ֱ�
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		
//		return mav;
//	}

}

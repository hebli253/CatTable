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
//		//1. 수정된 데이터를 가져오기 
//		int seq = Integer.parseInt(request.getParameter("seq"));
//		String Name = request.getParameter("Name");
//		String Adopted = request.getParameter("Adopted");
//		
////		System.out.println("seq : " + seq + 
////						   ", Name : " + Name +
////						   ", Adopted : " + Adopted);
//		
//		//2. 수정된 데이터를 디비에 저장 
//		BoardDo bdo = new BoardDo();
//		bdo.setSeq(seq);
//		bdo.setName(Name);
//		bdo.setAdopted(Adopted);
//		
//		BoardDao bdao = new BoardDao();
//		bdao.updateBoard(bdo);
//		
//		//3. 디비에 저장한 후에, getBoardList.do 호출하여, 
//		// 수정된 데이터가 포함된 전체 리스트 보여주기
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		
//		return mav;
//	}

}

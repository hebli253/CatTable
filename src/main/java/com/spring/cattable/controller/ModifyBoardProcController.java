package com.spring.cattable.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.board.impl.BoardDao;
import com.spring.board.impl.BoardDo;

public class ModifyBoardProcController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
									  HttpServletResponse response) throws Exception {
		System.out.println("ModifyBoardProcController --> ");
		
		//1. ������ �����͸� �������� 
		int seq = Integer.parseInt(request.getParameter("seq"));
		String Name = request.getParameter("Name");
		String Adopted = request.getParameter("Adopted");
		
//		System.out.println("seq : " + seq + 
//						   ", Name : " + Name +
//						   ", Adopted : " + Adopted);
		
		//2. ������ �����͸� ��� ���� 
		BoardDo bdo = new BoardDo();
		bdo.setSeq(seq);
		bdo.setName(Name);
		bdo.setAdopted(Adopted);
		
		BoardDao bdao = new BoardDao();
		bdao.updateBoard(bdo);
		
		//3. ��� ������ �Ŀ�, getBoardList.do ȣ���Ͽ�, 
		// ������ �����Ͱ� ���Ե� ��ü ����Ʈ �����ֱ�
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}

}

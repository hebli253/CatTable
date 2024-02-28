package com.spring.cattable.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.board.impl.BoardDao;
import com.spring.board.impl.BoardDo;

public class InsertBoardProcController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("InsertBoardProcController --> ");
	
		//1. Ŭ���̾�Ʈ�� ���� ���޵Ǵ� ������ �������� 
		String Birth = request.getParameter("Birth");
		String Name = request.getParameter("Name");
		String Adopted = request.getParameter("Adopted");
		System.out.println( "Name : " + Name + 
							", Birth : " + Birth + 
							", Adopted : " + Adopted );
		
		//2. ��� ���޵� ������ ����
		BoardDo bdo = new BoardDo();
		bdo.setName(Name);
		bdo.setBirth(Birth);
		bdo.setAdopted(Adopted);
		
		BoardDao bdao = new BoardDao();
		bdao.insertBoard(bdo);
		
		//3. ��ü �Խ��� �����ֱ� ȣ���ϱ� 
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}

}

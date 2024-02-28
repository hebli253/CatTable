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
	
		//1. 클라이언트로 부터 전달되는 데이터 가져오기 
		String Birth = request.getParameter("Birth");
		String Name = request.getParameter("Name");
		String Adopted = request.getParameter("Adopted");
		System.out.println( "Name : " + Name + 
							", Birth : " + Birth + 
							", Adopted : " + Adopted );
		
		//2. 디비에 전달된 데이터 저장
		BoardDo bdo = new BoardDo();
		bdo.setName(Name);
		bdo.setBirth(Birth);
		bdo.setAdopted(Adopted);
		
		BoardDao bdao = new BoardDao();
		bdao.insertBoard(bdo);
		
		//3. 전체 게시판 보여주기 호출하기 
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}

}

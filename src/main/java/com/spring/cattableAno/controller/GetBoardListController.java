package com.spring.cattableAno.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.impl.BoardDao;
import com.spring.board.impl.BoardDo;

//@Controller
public class GetBoardListController{

//	<prop key="/getBoardList.do"> getBoardList </prop>
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardDo bdo, 
									 BoardDao bdao,
									 ModelAndView mav ){
		System.out.println("GetBoardListController(Ano) --> ");		
		//1. 디비 연동하여 데이터 처리 (BoardDo, BoardDao 이용)
		ArrayList<BoardDo> bList = bdao.getBoardList();		
		//제대로 데이터 가져오는지 체크!! 
		for(BoardDo board: bList) {
			System.out.println(" --> " + board.toString());
		}		
		//2. 디비 이용 처리된 데이터를 뷰어를 호출하면서, 
		// 데이터 전달(ModelAndView 이용)
		//bList 이름 으로 위에서 처리한 bList 데이터 결과를 뷰어에 전달 
		mav.addObject("bList", bList);
		//뷰 리졸버에 의해서, /WEB-INF/~~~ + getBoardListView + .jsp 
		mav.setViewName("getBoardListView");	
		
		return mav;
	}

}

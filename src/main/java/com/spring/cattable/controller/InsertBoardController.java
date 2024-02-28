package com.spring.cattable.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InsertBoardController  implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("InsertBoardController --> ");
		//1. 해당 컨트롤러는 뷰어만 호출하는 기능
		ModelAndView mav = new ModelAndView();
		mav.setViewName("insertBoardView");
		
		return mav;
	}

}

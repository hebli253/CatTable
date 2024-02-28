package com.spring.cattableAno.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.impl.BoardDao;
import com.spring.board.impl.BoardDo;

//@Controller
public class BoardController {	
	
	//	<prop key="/getBoardList.do"> getBoardList </prop>
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(BoardDo bdo, 
							   BoardDao bdao,
							   Model model ){
		System.out.println("GetBoardListController(Ano-Board) --> ");		
		//1. 디비 연동하여 데이터 처리 (BoardDo, BoardDao 이용)
		ArrayList<BoardDo> bList = bdao.getBoardList();			
		model.addAttribute("bList", bList);			
		return "getBoardListView";
	}
	
	//<prop key="/insertBoard.do"> insertBoard </prop>
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardDo bdo,
							  BoardDao bdao,
							  ModelAndView mav) {
		
		System.out.println("InsertBoardController(Ano) --> ");
		//mav.setViewName("insertBoardView");
		
		return "insertBoardView";
	}
	
	@RequestMapping(value="/insertBoardProc.do", method=RequestMethod.GET)
	public String insertBoardProcGet(BoardDo bdo,
									BoardDao bdao,
									ModelAndView mav) {		
		System.out.println("InsertBoardProcController(Ano-Get) --> ");
		
		bdao.insertBoard(bdo);
		//mav.setViewName("redirect:getBoardList.do");
		
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping(value="/insertBoardProc.do", method=RequestMethod.POST)
	public String insertBoardProcPost(BoardDo bdo,
										BoardDao bdao,
										ModelAndView mav) {		
		System.out.println("InsertBoardProcController(Ano-Post) --> ");
		
		bdao.insertBoard(bdo);
		//mav.setViewName("redirect:getBoardList.do");
		
		return "redirect:getBoardList.do";
	}
	
	//<prop key="/getBoard.do"> getBoard </prop>
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardDo bdo,
								 BoardDao bdao,
								 Model model) {
		System.out.println("GetBoardController(Ano) --> ");
		System.out.println("seq : " + bdo.getSeq());
		
		BoardDo board = bdao.getBoard(bdo);
		//mav.addObject("board", board);
		//mav.setViewName("getBoardView");
		model.addAttribute("board", board);
		
		return "getBoardView";
	}
	
	//<prop key="/modifyBoard.do"> modifyBoard </prop>
	@RequestMapping(value="/modifyBoard.do")
	public String modifyBoard(BoardDo bdo,
									BoardDao bdao,
									Model model) {
		System.out.println("ModifyController(Ano) --> ");
		System.out.println("seq : " + bdo.getSeq());
		
		BoardDo board = bdao.getBoard(bdo);
		//mav.addObject("board", board);
		//mav.setViewName("modifyBoardView");
		model.addAttribute("board",board);
		
		return "modifyBoardView";
	}
	
	//<prop key="/modifyBoardProc.do"> modifyBoardProc </prop>
	@RequestMapping(value="/modifyBoardProc.do")
	public String modifyBoardProc(BoardDo bdo,
										BoardDao bdao,
										ModelAndView mav ) {
		System.out.println("ModifyBoardProcController(Ano) --> ");
		
		System.out.println("seq : " + bdo.getSeq() + 
					   ", Name : " + bdo.getName() +
					   ", Adopted : " + bdo.getAdopted() );
		bdao.updateBoard(bdo);
		//mav.setViewName("redirect:getBoardList.do");
		
		return "redirect:getBoardList.do";
	}
	
	//<prop key="/deleteBoard.do"> deleteBoard </prop>
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardDo bdo,
									BoardDao bdao,
									ModelAndView mav) {
		System.out.println("DeleteBoardController(Ano) --> ");
		
		bdao.deleteBoard(bdo);
		//mav.setViewName("redirect:getBoardList.do");
		
		return "redirect:getBoardList.do";
	}
	
	
	@RequestMapping(value="/searchBoardList.do")
	public String searchBoardList(@RequestParam(value="searchCon") String searchCon,
								  @RequestParam(value="searchKey") String searchKey,
								  BoardDao bdao, Model model) {
		System.out.println("searchBoardList --> ");
		
		System.out.println("searchCon : " + searchCon +
						   ", searchKey : " + searchKey );
		
		ArrayList<BoardDo> bList = bdao.searchBoardList(searchCon, searchKey);
		model.addAttribute("bList", bList);
		
		return "getBoardListView";
	}
		
	@RequestMapping(value="/sortBoardList.do")
	public String searchBoardList(@RequestParam(value="sortCon") String sortCon,
								  BoardDao bdao, Model model) {
		System.out.println("sortBoardList --> ");
		
		System.out.println("sortCon : " + sortCon);
		
		ArrayList<BoardDo> bList = bdao.sortBoardList(sortCon);
		model.addAttribute("bList", bList);
		
		return "getBoardListView";
	}
	

}

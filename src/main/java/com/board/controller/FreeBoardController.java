package com.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.service.FreeBoardService;
import com.board.vo.BoardVo;

@Controller
public class FreeBoardController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(FreeBoardController.class);
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	// 자유 게시판 list 화면
	@RequestMapping(value = "/board/freeBoard", method = RequestMethod.GET)
	public String listFreeBoard(Model model, HttpServletRequest request) throws Exception{
		
		// 세션 객체 
		HttpSession sesseion = request.getSession();
		
		// 세션 가져오기
		sesseion.getAttribute("user");
		
		// 서비스 처리
		List<BoardVo> resultFreeBoard = freeBoardService.listFreeBoard();
		// model에 결과 add
		model.addAttribute("freeBoard", resultFreeBoard);
		// view page로 리턴
		return "board/freeBoard";
	}
	
	// 자유 게시판 글 작성 화면		
	@RequestMapping(value = "/board/freeInsert", method = RequestMethod.GET)
	public void freeInsertView() throws Exception{
		
	}
		
	// 자유 게시판 글 작성
	@RequestMapping(value = "/board/freeInsert", method = RequestMethod.POST)
	public String freeBoardInsert(BoardVo boardVo) throws Exception{
		// 서비스 처리
		freeBoardService.freeBoardInsert(boardVo);
		
		// list로 돌아가서 insert를 확인. redirect 사용
		return "redirect:/board/freeBoard";
	}
		
	// javaBoard list
	@RequestMapping(value = "/board/javaBoard", method = RequestMethod.GET)
	public String listJavaBoard(Model model, HttpServletRequest request) throws Exception{
		
		HttpSession sesseion = request.getSession();
		
		sesseion.getAttribute("user");
		
		List<BoardVo> resultJavaBoard = freeBoardService.listJavaBoard();
		
		model.addAttribute("javaBoard", resultJavaBoard);
		
		return "board/javaBoard";
	}
		
	// java 게시판 글 작성 화면
	@RequestMapping(value = "/board/javaInsert", method = RequestMethod.GET)
	public void javaInsertView() throws Exception{
		
	}
			
	// java 게시판 글 작성
	@RequestMapping(value = "/board/javaInsert", method = RequestMethod.POST)
	public String javaBoardInsert(BoardVo boardVo) throws Exception{
	
		// 서비스 처리
		freeBoardService.javaBoardInsert(boardVo);
		
		// list로 돌아가서 insert를 확인. redirect 사용한다.
		return "redirect:/board/javaBoard";
	}
		
	// sqlboard list
	@RequestMapping(value = "/board/sqlBoard", method = RequestMethod.GET)
	public String listSqlBoard(Model model, HttpServletRequest request) throws Exception{
		
		HttpSession sesseion = request.getSession();
		
		sesseion.getAttribute("user");
			
		List<BoardVo> resultSqlBoard = freeBoardService.listSqlBoard();
			
		model.addAttribute("sqlBoard", resultSqlBoard);
		return "board/sqlBoard";
	}
		
	// sql 게시판 글 작성 화면
	@RequestMapping(value = "/board/sqlInsert", method = RequestMethod.GET)
	public void sqlInsertView() throws Exception{
	
	}
		
	// sql 게시판 글 작성
	@RequestMapping(value = "/board/sqlInsert", method = RequestMethod.POST)
	public String sqlBoardInsert(BoardVo boardVo) throws Exception{
		
		freeBoardService.sqlBoardInsert(boardVo);
		
		// list로 돌아가서 insert를 확인. redirect 사용
		return "redirect:/board/sqlBoard";
	}
	
	// reviewBoard list
	@RequestMapping(value = "/board/reviewBoard", method = RequestMethod.GET)
	public String listReviewBoard(Model model, HttpServletRequest request) throws Exception{
		
		HttpSession sesseion = request.getSession();
		
		sesseion.getAttribute("user");
			
		List<BoardVo> resultReviewBoard = freeBoardService.listReviewBoard();
			
		model.addAttribute("reviewBoard", resultReviewBoard);
		return "board/reviewBoard";
	}
		
	// sql 게시판 글 작성 화면
	@RequestMapping(value = "/board/reviewInsert", method = RequestMethod.GET)
	public void reviewInsertView() throws Exception{

	}
		
	// sql 게시판 글 작성
	@RequestMapping(value = "/board/reviewInsert", method = RequestMethod.POST)
	public String reviewBoardInsert(BoardVo boardVo) throws Exception{
		
		freeBoardService.reviewBoardInsert(boardVo);
		
		// list로 돌아가서 insert를 확인. redirect 사용
		return "redirect:/board/reviewBoard";
	}
	
	
}

package com.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO;
import com.board.dao.FreeBoardDAO;
import com.board.vo.BoardVo;

@Service
public class FreeBoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(FreeBoardService.class);
	
	@Autowired
	private FreeBoardDAO freeBoardDAO;
	
	@Autowired
	private BoardDAO boardDAO;

	// 자유게시판 조회
	public List<BoardVo> listFreeBoard() throws Exception {
		// dao 처리
		return freeBoardDAO.listFreeBoard();
	}
	
	// 자유게시판 등록
	public void freeBoardInsert(BoardVo boardVo) {
		// dao 처리
		freeBoardDAO.freeBoardInsert(boardVo);
	}
	// 자바게시판 조회
	public List<BoardVo> listJavaBoard() throws Exception {
		// dao 처리
		return freeBoardDAO.listJavaBoard();
	}
	// 자바게시판 등록
	public void javaBoardInsert(BoardVo boardVo) {
		// dao 처리
		freeBoardDAO.javaBoardInsert(boardVo);
		
	}
	// sql 게시판 조회
	public List<BoardVo> listSqlBoard() {
		// dao 처리
		return freeBoardDAO.listSqlBoard();
	}
	// sql게시판 등록
	public void sqlBoardInsert(BoardVo boardVo) {
		// dao 처리
		freeBoardDAO.sqlBoardInsert(boardVo);		
	}
	// 복습게시판 조회
	public List<BoardVo> listReviewBoard() {
		// dao 처리
		return freeBoardDAO.listReviewBoard();
	}
	// 복습게시판 등록
	public void reviewBoardInsert(BoardVo boardVo) {
		// dao 처리
		freeBoardDAO.reviewBoardInsert(boardVo);		
		
	}
	
	public List<BoardVo> listBoardSelect(BoardVo boardVo) throws Exception {
		
		if (boardVo.getDivision() == "free") {
			
			return freeBoardDAO.listFreeBoard();
		}
		
		return boardDAO.selectBoardAll();
	}
}

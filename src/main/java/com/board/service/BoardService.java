package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO;
import com.board.vo.BoardVo;

@Service
public class BoardService {
	

	@Autowired
	private BoardDAO boardDAO;
	
	// select Now
	public String selectNow() {
		return boardDAO.selectNow();
	}
	
	// 게시글 작성
	public void insert(BoardVo boardVo) throws Exception {
		boardDAO.insert(boardVo);
	}
	
	// 게시물 목록 조회
	public List<BoardVo> selectBoardAll() throws Exception {

		return boardDAO.selectBoardAll();
	}
	
	// 게시물 조회
	public BoardVo selectBoard(int id) throws Exception {

		return boardDAO.selectBoard(id);
	}
	
	// 게시물 수정
	public void updateBoard(BoardVo boardVo) throws Exception {
		
		boardDAO.updateBoard(boardVo);
	}

	// 게시물 삭제
	public void delete(int id) throws Exception {
		
		boardDAO.delete(id);
	}


}

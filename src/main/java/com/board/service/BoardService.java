package com.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO;
import com.board.vo.BoardVo;
import com.board.vo.Search;

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
	// 게시판 페이지 
	public List<BoardVo> selectPage(Map<String, Object> pageMap) {
		// TODO Auto-generated method stub
		
		return boardDAO.selectPage(pageMap);
	}
	
	// 총 게시물 수
	public int selectTotalCnt() {
		// TODO Auto-generated method stub
		int result = boardDAO.selectToTalCnt();
		return result;
	}
	
	// 조회수 카운트 업
//	public int selCntUp(int id) {
//		return boardDAO.selCntUp(id);
//	}
	
	// 게시판 검색 후 페이지
	public List<BoardVo> searchSelectPage(Search search) throws Exception{
		
		return boardDAO.searchSelectPage(search);
	}
	
	// 게시판 검색 후 카운트
	public int selectResultCnt(Search search) throws Exception {
		
		return boardDAO.selectResultCnt(search);
	}
}

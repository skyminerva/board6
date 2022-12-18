package com.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.vo.BoardVo;

@Repository
public class FreeBoardDAO {
	
	@Autowired
	private SqlSession session;
	
	// 자유게신판 조회
	public List<BoardVo> listFreeBoard() {
		return session.selectList("boardMapper.listFreeBoard");
	}
	// 자유게시판 등록
	public void freeBoardInsert(BoardVo boardVo) {
		
		session.insert("boardMapper.freeBoardInsert", boardVo);		
	}
	
	// 자바 게시판 조회
	public List<BoardVo> listJavaBoard() {
		return session.selectList("boardMapper.listJavaBoard");
	}
	
	// 자바 게시판 등록
	public void javaBoardInsert(BoardVo boardVo) {
		session.insert("boardMapper.javaBoardInsert", boardVo);	
	}
	
	// sql게시판 조회
	public List<BoardVo> listSqlBoard() {
		return session.selectList("boardMapper.listSqlBoard");
	}
	
	// sql 게시판 등록
	public void sqlBoardInsert(BoardVo boardVo) {
		session.insert("boardMapper.sqlBoardInsert", boardVo);			
	}
	
	// 복습 게시판 조회
	public List<BoardVo> listReviewBoard() {
		return session.selectList("boardMapper.listReviewBoard");
	}
	
	// 복습 게시판 등록
	public void reviewBoardInsert(BoardVo boardVo) {
		session.insert("boardMapper.reviewBoardInsert", boardVo);			

	}

}

package com.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.vo.BoardVo;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public String selectNow() {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne("boardMapper.selectNow");
		
	}
	
	// 게시글 작성
	public void insert(BoardVo boarVo) throws Exception {
		sqlSession.insert("boardMapper.insert", boarVo);
		
	}
	
	// 게시물 목록 조회
	public List<BoardVo> selectBoardAll() throws Exception {
	
		return sqlSession.selectList("boardMapper.selectBoardAll");

	}
	
	// 게시물 조회
	public BoardVo selectBoard(int id) throws Exception {
			
		return sqlSession.selectOne("boardMapper.selectBoard", id);
	}
	
	// 게시물 수정
	public void updateBoard(BoardVo boardVo) throws Exception {
		
		sqlSession.update("boardMapper.updateBoard", boardVo);
	}

	// 게시물 삭제
	public void delete(int id) throws Exception {
		
		sqlSession.delete("boardMapper.delete", id);
	}

}

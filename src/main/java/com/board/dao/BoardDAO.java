package com.board.dao;

import java.util.List;
import java.util.Map;

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
		
		// 조회가 되면 카운트 업
		sqlSession.update("boardMapper.selCntUp", id);
		
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

	// 게시판 페이지 목록
	public List<BoardVo> selectPage(Map<String, Object> pageMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardMapper.selectPage", pageMap);
	}
	
	// 총 게시물 수
	public int selectToTalCnt() {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne("boardMapper.boardCnt");
	}
	
	// 조회수 카운트 업
//	public int selCntUp(int id) {
//		return sqlSession.update("boardMapper.selCntUp", id);
//	}

}

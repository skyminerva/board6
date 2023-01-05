package com.board.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.vo.CommentVo;

//@Repository
public class CommentDAO {
	
//	@Autowired
	private SqlSession sqlSession;
	
	// 댓글 생성
	public int insertCmt (CommentVo commentVo) {
		
		return sqlSession.insert("CommentMapper.insertCmt", commentVo);
	}

	// 게시물의 댓글 조회
	public CommentVo selectCmt(int cmtNo) {
		return sqlSession.selectOne("CommentMapper.selectCmtCnt", cmtNo);
	}
	
	// 게시물 댓글 삭제
	public int deleteCmt (Map<String, Object> param) {
		// service에서 hashmap으로 만들어야 한다. 
		return sqlSession.delete("CommentMapper.deleteCmt", param);
	}
	
	// 게시물의 댓글 전부 삭제 ?? 전부 삭제 필요한가?? 내가 사용한다고 생각!!!
	public int deleteCommentAll(int id) {
		return sqlSession.delete("CommentMapper.deleteCmtAll", id);
	}
	
	// 게시물의 댓글 수 카운드
	public int selectCmtCnt(int id) {
		return sqlSession.selectOne("CommentMapper.selectCmtCnt", id);
	}
	
	// TODO 작성자 조건으로 댓글 전체 보기????
	
	
	

}

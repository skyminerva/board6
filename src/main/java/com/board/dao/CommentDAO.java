package com.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.vo.CommentVo;

// 어노테이션 추가 했는 지 확인!! bean 오류 발생의 원인 
@Repository 
public class CommentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 댓글 생성 -- namespace 제대로 확인!!
	public int insertCmt (CommentVo commentVo) {
		
		return sqlSession.insert("commentMapper.insertCmt", commentVo);
	}

	// 게시물의 댓글 조회
	public List<CommentVo> listCmt(int id) {
		return sqlSession.selectList("commentMapper.listCmt", id);
	}
	
	// 댓글 수정
	public void updateCmt(CommentVo commentVo) {
		sqlSession.update("commentMapper.updateCmt", commentVo);
	}
	
	public CommentVo selectCmt(int cmtNo) {
		return sqlSession.selectOne("commentMapper.selectCmt", cmtNo);
	}
	
	// 게시물 댓글 삭제
	public int deleteCmt (Map<String, Object> param) {
		// service에서 hashmap으로 만들어야 한다. 
		return sqlSession.delete("commentMapper.deleteCmt", param);
	}
	
	// 게시물의 댓글 전부 삭제 ?? 전부 삭제 필요한가?? 내가 사용한다고 생각!!!
	public int deleteCommentAll(int id) {
		return sqlSession.delete("commentMapper.deleteCmtAll", id);
	}

	
//	// 게시물의 댓글 수 카운드
//	public int selectCmtCnt(int id) {
//		return sqlSession.selectOne("commentMapper.selectCmtCnt", id);
//	}
	
	
	
	

}

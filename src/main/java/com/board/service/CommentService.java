package com.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.CommentDAO;
import com.board.vo.CommentVo;

// 어노테이션 제대로 붙였는지 확인!! bean 오류 발생.
@Service
public class CommentService {
	
	private final Logger logger = LoggerFactory.getLogger(CommentService.class);
	
	@Autowired
	private CommentDAO commentDAO;
	
	// 댓글 생성
	public int insertCmt (CommentVo commentVo) {
		logger.debug("===============insertCmt================= : {}", commentVo);
		
		return commentDAO.insertCmt(commentVo);
	}
	
	// 게시물의 댓글 조회 -- 여러 댓글이 존재할 수 있으니 리스트로 받아야 한다.
	public List<CommentVo> listCmt(int id) {
		logger.debug("===============selectCmt================= : {}", id);
		return commentDAO.listCmt(id);
	}
	
	public void updateCmt(CommentVo commentVo) {
		commentDAO.updateCmt(commentVo);
	}
	
	public CommentVo selectCmt(int cmtNo) {
		
		return commentDAO.selectCmt(cmtNo);
	}
	
//	// 게시물의 댓글 수 카운드
//	public int selectCmtCnt(int id) {
//		logger.debug("===============selectCmtCnt================= : {}", id);
//		return commentDAO.selectCmtCnt(id);
//	}
	
	// 게시물의 댓글 전부 삭제
	public int deleteCommentAll(int id) {
		logger.debug("===============deleteCommentAll================= : {}", id);
		
		return commentDAO.deleteCommentAll(id);
	}
	
	// 게시물 댓글 삭제
	public int deleteCmt (int cmtNo, String commenter) {
		logger.debug("===============selectCmtCnt================= : {}", cmtNo, commenter);
		
		// service에서 hashmap cmtNo, commenter으로 만들어야 한다. 
		Map<String, Object> resultCmt = new HashMap<String, Object>();
		// 댓글 번호
		resultCmt.put("cmtNo", cmtNo);
		// 댓글 작성자 
		resultCmt.put("commenter", commenter);
		
		logger.debug("===============resultCmt================= : {}", resultCmt);
		return commentDAO.deleteCmt(resultCmt);
	}


	


}

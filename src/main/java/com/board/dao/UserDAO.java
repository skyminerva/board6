package com.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.vo.UserVo;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 회원가입 
	public void userAdd(UserVo userVo) {
		sqlSession.insert("userMapper.userAdd", userVo);
	}
	
	// 회원선택 (로그인)
	public UserVo userSelect(String id) {
		
		return sqlSession.selectOne("userMapper.userSelect", id);
	}

}

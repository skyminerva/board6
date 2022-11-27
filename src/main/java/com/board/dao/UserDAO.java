package com.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.vo.UserVo;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void userAdd(UserVo userVo) {
		sqlSession.insert("userMapper.userAdd", userVo);
	}
	

}

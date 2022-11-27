package com.board.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.UserDAO;
import com.board.vo.UserVo;

@Service
public class UserService {
	
	private final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDAO userDAO;

	public void userAdd(UserVo userVo) {
		logger.info("userAdd");
		
		// dao 처리
		userDAO.userAdd(userVo);
		
	}

}

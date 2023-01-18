package com.board.service;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.UserDAO;
import com.board.util.BoardUtill;
import com.board.vo.UserVo;

@Service
public class UserService {
	
	private final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDAO userDAO;
	
	public void userAdd(UserVo userVo) throws NoSuchAlgorithmException {
		logger.info("userAdd");
//		MessageDigest md = MessageDigest.getInstance("SHA-512");
//	    md.update(pwd.getBytes());
//	    byte[] digest = md.digest();
//	    String result = new BigInteger(1, digest).toString(16).toUpperCase();
//	    userVo.setPwd(result);
		
		userVo.setPwd(BoardUtill.generate(userVo.getPwd()));
		// dao 처리
		userDAO.userAdd(userVo);
		
	}
	
	public UserVo userSelect(String id) {
		
		
		// dao 처리
		return userDAO.userSelect(id);
	}
}

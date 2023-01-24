package com.board.service;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.UserDAO;
import com.board.util.AesCrypto;
import com.board.util.BoardUtill;
import com.board.vo.UserVo;

@Service
public class UserService {
	
	private final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDAO userDAO;
	
	// 회원가입
	public void userAdd(UserVo userVo) throws Exception {
		logger.info("userAdd");
		// util 로 변경
//		MessageDigest md = MessageDigest.getInstance("SHA-512");
//	    md.update(pwd.getBytes());
//	    byte[] digest = md.digest();
//	    String result = new BigInteger(1, digest).toString(16).toUpperCase();
//	    userVo.setPwd(result);
		
		// aes 로 username 양방향 암호화 
		AesCrypto crypto = new AesCrypto();
		String userName = userVo.getName();
		String aesName = crypto.encrypt(userName);
		userVo.setName(aesName);
		
		// sha512로 패스워드 암호화 (단방향)
		userVo.setPwd(BoardUtill.generate(userVo.getPwd()));
		// dao 처리
		userDAO.userAdd(userVo);
		
	}
	
	// 회원가입 완료 후 가입정보 조회
	public UserVo userSelect(String id) throws Exception {
		
		UserVo result = userDAO.userSelect(id);
		
		// dao 처리
		return result;
	}
}

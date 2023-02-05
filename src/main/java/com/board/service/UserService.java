package com.board.service;

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
		String aesName = AesCrypto.encrypt(userVo.getName());
		userVo.setName(aesName);
		
		// sha512로 패스워드 암호화 (단방향)
		userVo.setPwd(BoardUtill.generate(userVo.getPwd()));
		// dao 처리
		userDAO.userAdd(userVo);
		
	}
	
	// 회원가입 완료 후 가입정보 조회
	public UserVo userSelect(String id) throws Exception {
		
		UserVo result = userDAO.userSelect(id);
		
		return result;
	}
	
	// 패스워드 변경
	public int updatePwd(UserVo userVo, String param) throws Exception {
		
		// user 정보 조회
		UserVo user = userDAO.userSelect(userVo.getId());
        
        // sha512 암호화 패스워드 비교 (단방향) -- 단방향은 복호화로 비교하는 것이 아니라 암호화 자제로 비교 
		// 화면에 입력된 현재 password
        String pwd = BoardUtill.generate(userVo.getPwd());
		// 화면에서 입력된 new password
		String newPwd = BoardUtill.generate(param);
		int result = 0;
		// user 객체가 null이 아니면 select된 id가 존재하므로 로그인 성공 >> pwd equals 확인 후 로그인 처리
		if (user != null && user.getPwd().equals(pwd)) {
			userVo.setPwd(newPwd);
			// dao 로 전달
			result = userDAO.updatePwd(userVo);
		}
		
		return result;
		
	}
}

package com.board.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.service.UserService;
import com.board.vo.UserVo;
import com.mysql.cj.Session;

@Controller
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	// 회원 가입 화면
	@RequestMapping(value = "/board/userAdd", method = RequestMethod.GET)
	public void userView() throws Exception{
	
	}
	
	// 회원 가입
	@RequestMapping(value = "/board/userAdd", method = RequestMethod.POST)
	public String userAdd(UserVo userVo, Model model) throws Exception{
		logger.info("userAdd");
		
		// 서비스 처리
		userService.userAdd(userVo);
		
		model.addAttribute("userInfo", userVo);
		// userInfo 화면에서 회원가입 정보 띄우기
		return "board/userInfo";
	}
	
	// password modify
	@RequestMapping(value = "/board/updatePwd", method = RequestMethod.GET)
	public void updatePwd() throws Exception {
	
	}
	
	// password modify
	@RequestMapping(value = "/board/updatePwd", method = RequestMethod.POST)
	public String updatePwd(UserVo userVo, String newPwd, HttpSession session) throws Exception {
		
		int result = userService.updatePwd(userVo, newPwd);
		if(result == 1) {
			session.invalidate();
			return "board/loginView";
		} else {
			return "board/updatePwd";
		}
	}
	
}

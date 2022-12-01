package com.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.dao.UserDAO;
import com.board.service.UserService;
import com.board.vo.UserVo;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value ="/board/loginView", method = RequestMethod.GET)
	public String loginView() {
		
		return "board/loginView";  // Todo loginView 만들기
	}
	
	@RequestMapping(value = "/board/loginView", method = RequestMethod.POST)
	public String login(String id, String pwd, HttpServletRequest request) {
		
		if (loginCheck(id, pwd) == false) {
			
			return "board/loginView";
			
		}
		// 세션 가지고 오기  // todo 더 찾아서 공부
		HttpSession session = request.getSession();
		// 세션 값 set
		session.setAttribute("id", id);
		
		return "redirect:/board/boardAll";
	}

		
	public boolean loginCheck(String id, String pwd) {
		// 입력한 id와 pwd를 확인  
		// TODO sql select로 로그인 확인 만들기
	    UserVo userVo = null;
	    userVo = userService.userSelect(id);
	    // userVo 값 널이 아니고  셀렉트한 id의 pwd를 equals로 비교
	    if (userVo != null && userVo.getPwd().equals(pwd)) {
			return true;
		} 
	    
	    return false;
	}

}

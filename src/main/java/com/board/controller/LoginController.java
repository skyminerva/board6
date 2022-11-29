package com.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
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
		// 세션 값 get
		session.getAttribute("id");
		// 세션 종료
		session.invalidate();
		// 세션 예약 종료, 초단위로 설정 10분은 10*60 
		session.setMaxInactiveInterval(0);
		
		return "redirect:/board/boardAll";
	}

	public boolean loginCheck(String id, String pwd) {
		// 입력한 id와 pwd를 확인  
		// TODO sql select로 로그인 확인 만들기
		return "jiwon394".equals(id) && "1234".equals(pwd);
	}
}

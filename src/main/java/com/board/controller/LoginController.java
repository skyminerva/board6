package com.board.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.service.UserService;
import com.board.vo.UserVo;

@Controller
public class LoginController {
	
	private final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value ="/board/loginView", method = RequestMethod.GET)
	public String loginView() {
		
		return "board/loginView";  // Todo loginView 만들기
	}
	
	// HttpServletRequest는 interceptor에 있으므로  HttpSession을 사용해서 set만 해주면 된다.
	@RequestMapping(value = "/board/loginView", method = RequestMethod.POST)
	public String login(String id, String pwd, boolean keepLogin ,boolean autoLogin ,HttpSession session, HttpServletResponse response) {
//	public String login(String id, String pwd, HttpServletRequest request) {
//		
//		if (loginCheck(id, pwd) == false) {
//			
//			return "board/loginView";
//			
//		}
		// logincheck를 안하니 여기에서 서비스처리 id로 유저셀렉(로그인)
		UserVo user = userService.userSelect(id);
        logger.debug("**************user****************** : {}", user);
		
		// user 객체가 null이 아니면 select된 id가 존재하므로 로그인 성공 >> pwd equals 확인 후 로그인 처리
		if (user != null && user.getPwd().equals(pwd)) {
			
			// setAttribute의 "user"는 interceptor의 getAttribute와 맞춰주어야 한다.
			session.setAttribute("user", user);
			
			// 쿠키로 로그인 유지와 자동 로그인
			// 유지 및 자동 미체크시 쿠키 생성 안함
			if(keepLogin != true && autoLogin != true) {
				
				// cookie 생성
				Cookie cookie = new Cookie("id", null);
				// 쿠키 종료 시간 설정
				cookie.setMaxAge(0);
				// 쿠키 추가
				response.addCookie(cookie);
			
			// 로그인 유지 체크
			} else if(keepLogin == true && autoLogin != true) {
				// cookie 생성
				Cookie cookie = new Cookie("id", id);
				// 클라이언트가 종료가 되면 쿠키도 삭제. 쿠키 시간 설정 필요x
				// 쿠키 추가
				response.addCookie(cookie);
				
			// 자동로그인 체크 
			} else if(keepLogin != true && autoLogin == true) {
				// cookie 생성
				Cookie cookie = new Cookie("id", id);
				// 쿠키 종료 시간 설정
				// 클라이언트와 서버가 종료되어도 설정한 시간만큼 쿠키 유지 
				cookie.setMaxAge(20*60);
				// 쿠키 추가
				response.addCookie(cookie);
				
			// 유지 및 자동로그인 모두 체크 
			} else {
				// cookie 생성
				Cookie cookie = new Cookie("id", id);
				// 쿠키 종료 시간 설정
				// 자동로그인이 유지되는 시간만큼만 유지되는 것이 맞을 듯
				cookie.setMaxAge(20*60);
				// 쿠키 추가
				response.addCookie(cookie);
			}
					
//			// 로그인유지
//			if(loging == true) {
//			// cookie 생성
//			Cookie cookie = new Cookie("id", id);
//			// 쿠키 종료 시간 설정(클라이언트가 종료될 때까지만 유지하고 싶으면 시간설정을 하지 않는다.)
//			// cookie.setMaxAge(10*60);
//			// 쿠키 추가
//			response.addCookie(cookie);
//			} else {
//				// cookie 생성
//				Cookie cookie = new Cookie("id", null);
//				// 쿠키 종료 시간 설정
//				cookie.setMaxAge(0);
//				// 쿠키 추가
//				response.addCookie(cookie);
//			}
			
//			// 자동로그인
//			if(autoLogin == true) {
//			// cookie 생성
//			Cookie cookie = new Cookie("id", id);
//			// 쿠키 종료 시간 설정
//			cookie.setMaxAge(20*60);
//			// 쿠키 추가
//			response.addCookie(cookie);
//			} else {
//				// cookie 생성
//				Cookie cookie = new Cookie("id", null);
//				// 쿠키 종료 시간 설정
//				cookie.setMaxAge(0);
//				// 쿠키 추가
//				response.addCookie(cookie);
//			}
			
//			Cookie userPwd = new Cookie("pwd", user.getPwd());
//			
//			userPwd.setMaxAge(60*60);
//			
//			response.addCookie(userPwd);
//			
			return "redirect:/board/boardAll";
		
		// 서비스 처리(user 객체가 null이면 select id가 없으므로 로그인 실패임)
		} else {
			return "board/loginView";
		}
		
		
		// 세션 가지고 오기  // todo 더 찾아서 공부
//		HttpSession session = request.getSession();
		// 세션 값 set
//		session.setAttribute("id", id);
		// 세션 타임아웃 후 새로 고침 했을 때 다시 로그인 화면으로 옴(확인)
//		session.setMaxInactiveInterval(2*60);
		
//		return "redirect:/board/boardAll";
	}

		
//	public boolean loginCheck(String id, String pwd) {
//		// 입력한 id와 pwd를 확인  
//		// TODO sql select로 로그인 확인 만들기
//	    UserVo userVo = null;
//	    userVo = userService.userSelect(id);
//	    // userVo 값 널이 아니고  셀렉트한 id의 pwd를 equals로 비교
//	    if (userVo != null && userVo.getPwd().equals(pwd)) {
//			return true;
//		} 
//	    
//	    return false;
//	}
	
	// 로그아웃 >> 로그아웃 바로 로그인 화면으로 가도록 만듬
	@RequestMapping(value ="/board/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		
		// 세션 바로 종료
		session.invalidate();
		
		// 쿠키 종료 하기
//		Cookie[] cookie = request.getCookies();
		// 쿠키에 값이 있으면
//		if (cookie != null) {
			
//			logger.debug("******************cookie********************* :{}", cookie);
//			for (int i = 0; i < cookie.length; i++) {
//			// 쿠키 유효시간0으로 종료
//			cookie[i].setMaxAge(0); 
//			// 쿠키 추가하여 만료
//			response.addCookie(cookie[i]); 
//			}
//			logger.debug("******************cookie********************* :{}", cookie);
//		}
		Cookie cookie = new Cookie("id", null);
		cookie.setMaxAge(0); 
		response.addCookie(cookie);
		return "board/loginView"; 
	}
}

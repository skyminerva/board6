package com.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// HandlerInterceptor와 HandlerInterceptorAdapter 사용법은 동일하다.
// HandlerInterceptor는 implements로 HandlerInterceptorAdapter은 extends 해주면 된다.
public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	// preHandle은 컨트롤러보다 먼저 수행된다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		// 세션 가져오기
		HttpSession session = request.getSession();
		
		// 세션 obj에 담기 setAttribute key 맞춰주는 것 잊지말자!!!
		Object obj = session.getAttribute("user");
		
		// 세션이 담긴 obj  체크 (로그인 체크)
		// obj가 null 이면 로그인이 안된 상태이므로 로그인 화면으로
		if (obj == null) {
			
			// interceptor에서는 redirect가 아닌 sendRedirect 사용한다.
			response.sendRedirect("/board/loginView");
			
			// 로그인 실패이므로 false 리턴
			return false;
		}
		// 세션 타임아웃 설정  게시판목록, 게시판 작성, 게시판 조회에서 타임아웃되는 것 확인.
		session.setMaxInactiveInterval(2*60);
		
		// obj가 null이 아닐 시는 로그인 성공이므로 true 리턴
		// preHandle의 return은 컨트롤러 요청 uri로 이동하는 것의 여부를 뜻한다.
		return true;
	}
	
	// posthandle - view 실행 전 수행, 
	// aftercomplete에 - view 실행 후 수행.  이 두가지 더 찾아보기 

}

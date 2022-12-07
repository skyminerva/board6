package com.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.service.BoardService;
import com.board.vo.BoardVo;

@Controller
@RequestMapping("/board/*")
public class BoardController<httpHttpServletRequest> {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	// home 화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws Exception {
		
		logger.info("this is home view");
		
		Date dt = new Date();
		
		// instance 생성
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		// formattedDate 에 dateFormat 형태로 저장.
		String formattedDate = dateFormat.format(dt);
		// model 에 serverTime (key=string) formattedDate (value = object) 확장해서 생각.
		model.addAttribute("serverTime", formattedDate );
		
		// 서비스 처리 값
		String result = boardService.selectNow();
		// model add
		model.addAttribute("selectNow", result);
		
		
		return "home";
	}
	
	// 게시판 전체 조회
	@RequestMapping(value = "/boardAll", method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request) throws Exception{
		logger.info("boardAll");
		
		// getSession
		HttpSession session = request.getSession();
		// user 객체 get
		session.getAttribute("user");
		// 로그인체크 세션 정보 유무에 따라서
//		if(loginCheck(request) == false) {
//		
//			// 세션이 없으면 로그인 화면을 보여준다. 세션이 타임아웃으로 끝나도 로그인 화면을 보여준다.
//			return "redirect:/board/loginView";
//		}
			
		// 서비스 처리
		List<BoardVo> result =  boardService.selectBoardAll();
		
		// model 에 add
		model.addAttribute("boardAll",result);
	
		// 보여줄 jsp 화면
		return "board/boardAll";
		
	}
	
	// 로그인 체크
//	private boolean loginCheck(HttpServletRequest request) {
//		// TODO Auto-generated method stub
//		// 세션을 가지고 온다
//		HttpSession session = request.getSession();
//		session.getAttribute("id");
//		// 세션을 getAttribute id 값이 존재하면 true, 없으면 false  
//		if(session.getAttribute("id") != null) {
//			return true;
//		}
//		
//		
//		return false;
//	}
	
	
	// 게시판 조회
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String read(BoardVo boardVo, Model model) throws Exception{
		logger.info("select");
		// 서비스 처리
		BoardVo result = boardService.selectBoard(boardVo.getId());
		// model 에 add
		model.addAttribute("select", result);
		// 보여줄 jsp 화면
		return "board/select";
	}

	// 게시판 글 작성 화면
	@RequestMapping(value = "/board/insert", method = RequestMethod.GET)
	public void insertView() throws Exception{
		// get만 만들거나 post만 만들어서 실패.
		// get에서 사용하는 것이 아니라 post로 만들어서 사용. 
//		boardService.write(boardVo);
//		
	}
	
	// 게시판 글 작성
	@RequestMapping(value = "/board/insert", method = RequestMethod.POST)
	public String insert(BoardVo boardVo) throws Exception{
		logger.info("insert");
		
		// insert는 결과를 model 에 add하지 않아도 된다.
		boardService.insert(boardVo);
		
		// list로 돌아가서 insert를 확인. redirect 사용한다.
		return "redirect:/board/boardAll";
	}
	
	
	// 게시판 수정
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public String updateView(BoardVo boardVo, Model model) throws Exception{
		logger.info("updateView");
		// 서비스 처리
		BoardVo result =  boardService.selectBoard(boardVo.getId());
		// model에 add
		model.addAttribute("update", result);
		
		return "board/updateView";
	}
	
	// 게시판 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVo boardVo) throws Exception{
		logger.info("update");
		
		// 서비스 처리
		boardService.update(boardVo);
		
		// 업데이트 확인 boardAll로 
		return "redirect:/board/boardAll";
	}

	// 게시판 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(BoardVo boardVo) throws Exception{
		logger.info("delete");
		// 서비스 처리
		boardService.delete(boardVo.getId());
		// 삭제 확인
		return "redirect:/board/boardAll";
	}
}

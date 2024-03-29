package com.board.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.service.BoardService;
import com.board.service.CommentService;
import com.board.service.UserService;
import com.board.util.BoardUtill;
import com.board.vo.BoardVo;
import com.board.vo.CommentVo;
import com.board.vo.PageHandler;
import com.board.vo.Search;

@Controller
@RequestMapping("/board/*")
public class BoardController<httpHttpServletRequest> {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private CommentService commentService;
	
	// home 화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws Exception {
		
		logger.info("this is home view");
		
		Date dt = new Date();
		
		// instance 생성
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		DateFormat format4 = DateFormat.getDateInstance(DateFormat.SHORT);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		// formattedDate 에 dateFormat 형태로 저장.
		String formattedDate = format.format(dt);
		
		// model 에 serverTime (key=string) formattedDate (value = object) 확장해서 생각.
		model.addAttribute("serverTime", formattedDate );
		
		// 서비스 처리 값
		String result = boardService.selectNow();
		// model add
		model.addAttribute("selectNow", result);
		
		
		return "home";
	}
	
	// 게시판 전체 조회
	// page와 pageSize는 integer 타입으로 설정, int 타입시 null 상태를 표시할 수 없다.화면 오류 발생
	@RequestMapping(value = "/boardAll", method = RequestMethod.GET)
	public String listAll(Search search, Model model, HttpServletRequest request) throws Exception{
		logger.info("boardAll");
		
//		// getSession
//		HttpSession session = request.getSession();
//		// user 객체 get
//		session.getAttribute("user");
		// 로그인체크 세션 정보 유무에 따라서
//		if(loginCheck(request) == false) {
//		
//			// 세션이 없으면 로그인 화면을 보여준다. 세션이 타임아웃으로 끝나도 로그인 화면을 보여준다.
//			return "redirect:/board/loginView";
//		}
		// page가 null 일경우 page set
//		if(page == null) {
//			page = 1;
//		}
		
		// pagesize가 null일경우 pagesize set
//		if(pageSize == null) {
//			pageSize = 10;
//		}
		
		// 총 게시물 수를 가져와서 pagesize로 나누고 pagenumber를 구한다.
		// 총 게시물 수 서비스 처리
		int totalCnt = boardService.selectResultCnt(search);
		PageHandler pageHandler = new PageHandler(totalCnt, search);
		
		// 페이지를 나누기 위한 값을 map으로 put하고 서비스처리로 넘긴다.
		// sql에서 parametertype을 map으로 설정
//		Map<String, Object> pageMap = new HashMap<String, Object>();
//		pageMap.put("offset", (page -1) * pageSize);
//		pageMap.put("pageSize", pageSize);
		// 페이징 서비스 처리
		List<BoardVo> result = boardService.searchSelectPage(search);
		
		// 서비스 처리 --- 이전의 전체 게시판 리스트를 가져올 때 사용
//		List<BoardVo> result =  boardService.selectBoardAll();
//		logger.info("==============result=============== : {} ", result);
		
		// model 에 add
		model.addAttribute("boardAll",result);
		model.addAttribute("pageHandler", pageHandler);
		
		
		return "board/boardAll";
		
	}
	
	// 로그인 체크
//	private boolean loginCheck(HttpServletRequest request) {
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
		
		logger.debug("==============result=============== : {} ", result);
		// model 에 add
		model.addAttribute("select", result);
		// 보여줄 jsp 화면
		
		// 댓글 조회 서비스 처리 boardVo에서 id를 가져온다. board 테이블의 id와 연결된 댓글을 조회 처리
		List<CommentVo> commentList = commentService.listCmt(boardVo.getId());
		// model에 commnetList(댓글 리스트) 를 add
		model.addAttribute("commentList", commentList);
		
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
	public String updateBoard(BoardVo boardVo) throws Exception{
		logger.info("update");
		
		// 서비스 처리
		boardService.updateBoard(boardVo);
		
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
	
	//댓글 작성
	@RequestMapping(value="/commentWrite", method = RequestMethod.POST)
	public String replyWrite(CommentVo commentVo, Search search, RedirectAttributes redirect) throws Exception {
			
		commentService.insertCmt(commentVo);
		// redirectAttributes를 이용해서 작성한 게시물의 id를 가져와서 댓글 작성 후 게시글을 다시 셀렉트	
		// redirect로 반환할 수 있는 것들을 생각해보자  --- search 의 정보들을 반환하면 조회 화면에서 추가 정보를 표시할 수 있지 않을까??
		redirect.addAttribute("id", commentVo.getId());
		
		return "redirect:/board/select";
	}
	
	//댓글 수정 
	@RequestMapping(value="/commentUpdateView", method = RequestMethod.GET)
	public String replyUpdateView(CommentVo commentVo, Model model) throws Exception {
		logger.info("reply Write");
		
		model.addAttribute("commentUpdate", commentService.selectCmt(commentVo.getCmtNo()));
		
		return "board/commentUpdateView";
	}
	
	// 댓글 수정
	@RequestMapping(value="/commentUpdate", method = RequestMethod.POST)
	public String replyUpdate(CommentVo commentVo, RedirectAttributes redirect) throws Exception {
		
		commentService.updateCmt(commentVo);
		
		redirect.addAttribute("id", commentVo.getId());
		
		return "redirect:/board/select";
	}
}

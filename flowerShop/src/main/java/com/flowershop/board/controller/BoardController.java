package com.flowershop.board.controller;

//주석 변경해보기 2017/09/26 배영철
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flowershop.board.domain.BoardList;
import com.flowershop.board.domain.BoardVo;
import com.flowershop.board.service.BoardService;

@Controller
public class BoardController {
	
	private Log log = LogFactory.getLog(BoardController.class);

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/write")
	private String writeFrom() throws Exception{
		return "board/writeForm";
	}
	
	@RequestMapping(value = "/writeOK", method = RequestMethod.POST)
	private String writeInBoard(BoardVo vo) throws Exception {
		boardService.insert(vo);
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model)throws Exception {
		
	int pageNo = 1;
	try {
		pageNo = Integer.parseInt(request.getParameter("pageNo"));
	} catch (Exception e) {}
	BoardList list = boardService.getBoardList(pageNo);
	
	model.addAttribute("R", list);
	model.addAttribute("pageNo", pageNo);
	return "board/list";
	}
	
	@RequestMapping("/increment") // 게시글을 확인할 때 조회수를 1 증가시킨다.
	public String increment(HttpServletRequest request, Model model)throws Exception {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));

		boardService.increment(board_no);
		model.addAttribute("board_no", board_no);
		model.addAttribute("pageNo", pageNo);

		return "redirect:content_view"; // @RequestMapping("/content_view") 메소드를 호출한다.
	}
	
	@RequestMapping("/content_view") // 게시글 한 건을 불러온다.
	public String view(HttpServletRequest request, Model model)throws Exception {
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		model.addAttribute("vo", boardService.selectContent(board_no));
//		RboardCommentList comment = new RboardCommentList();
//		comment.setList(dao.commentList(idx));

//		model.addAttribute("comment", comment);
		model.addAttribute("pageNo", pageNo);
		return "board/content_view";
	}
	
	@RequestMapping("/reply") // 답글을 쓸 폼을 띄운다.
	public String reply(BoardVo vo, HttpServletRequest request, Model model)throws Exception {
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		model.addAttribute("vo", vo);
		model.addAttribute("pageNo", pageNo);
		return "board/reply";
	}
	
	@RequestMapping("/replyOK") // 답글을 저장한다.
	public String replyOK(BoardVo vo, HttpServletRequest request, Model model)throws Exception {
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		//boardService.incrementSeq(vo);
		boardService.replyInsert(vo);
		return "redirect:list"; // @RequestMapping("/list") 메소드를 호출한다.
	}
	
	
	
	
	
	
	
}

















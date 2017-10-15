package com.flowershop.comment.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flowershop.board.service.BoardService;
import com.flowershop.comment.domain.CommentVo;
import com.flowershop.comment.service.CommentService;


@Controller
public class CommentController {

	
	private Log log = LogFactory.getLog(CommentController.class);
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/commentOK") // 댓글의 입력을 수행한다.
	public String commentOK(CommentVo commentVo, HttpServletRequest request, Model model)throws Exception {
		System.out.println("commentOK()");
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		
		commentService.insertComment(commentVo);
		commentService.incrementCommentCount(board_no);

		model.addAttribute("board_no", board_no);
		model.addAttribute("pageNo", pageNo);

		return "redirect:content_view"; // 메시지를 alert 할 수 있는 jsp파일로 이동한다.
		// return "redirect:view"; // @RequestMapping("/view") 메소드를 호출한다.
	}
	
	
	
}

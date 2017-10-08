package com.flowershop.comment.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flowershop.comment.domain.CommentVo;
import com.flowershop.comment.service.CommentService;


@Controller
public class CommentController {

	private Log log = LogFactory.getLog(CommentController.class);
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/commentOK") // 댓글의 입력/수정/삭제를 수행한다.
	public String commentOK(CommentVo commentVo, HttpServletRequest request, Model model)throws Exception {
		System.out.println("commentOK()");
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		int mode = Integer.parseInt(request.getParameter("mode"));
		
		switch (mode) {
		case 1: // 댓글 입력
			commentService.insertComment(commentVo);
			break;

		case 2: // 댓글 수정
			commentService.updateComment(commentVo);
			break;

		case 3: // 댓글 삭제
//			RboardCommentVO vo1 = dao.selectCommentByIdx(idx);
//			if (vo1.getPassword().trim().equals(password)) {
//				dao.deleteComment(idx);
//				// 비밀번호가 맞았다.
//				System.out.println("댓글 삭제 성공");
//				model.addAttribute("message", "댓글 삭제 성공!");
//			} else {
//				// 비밀번호가 틀렸다.
//				System.out.println("댓글 삭제 실패");
//				model.addAttribute("message", "댓글 삭제 실패!");
//			}
//			break;
		}
		model.addAttribute("board_no", commentVo.getBoard_no());
		model.addAttribute("pageNo", pageNo);

		return "redirect:content_view"; // 메시지를 alert 할 수 있는 jsp파일로 이동한다.
		// return "redirect:view"; // @RequestMapping("/view") 메소드를 호출한다.
	}
	
}

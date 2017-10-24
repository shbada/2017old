package com.flowershop.comment.service.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowershop.board.service.BoardService;
import com.flowershop.comment.domain.CommentVo;
import com.flowershop.comment.repository.CommentDao;
import com.flowershop.comment.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao commentDao;
	
	@Autowired
	BoardService boardService;

	@Override
	public void insertComment(CommentVo vo) throws Exception {
		commentDao.insertComment(vo);
	}

	@Override
	public void updateComment(Map<String, String> map) throws Exception {
		commentDao.updateComment(map);
	}

	@Override
	public ArrayList<CommentVo> selectComentList(int board_no) throws Exception {
		return commentDao.selectComentList(board_no);
	}

	@Override
	public void incrementCommentCount(int board_no) throws Exception {
		boardService.incrementCommentCount(board_no);
	}

	@Override
	public void del_comment(int comment_no, int board_no, int comment_reply_count) throws Exception {
		
		if(comment_reply_count == 0) {
			commentDao.del_comment(comment_no);
			commentDao.del_comment_count(board_no);
		} else {
			commentDao.fix_comment(comment_no);
		}
	}
	

	
}

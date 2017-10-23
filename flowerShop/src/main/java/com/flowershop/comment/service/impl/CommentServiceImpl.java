package com.flowershop.comment.service.impl;

import java.util.ArrayList;

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
	public void updateComment(CommentVo vo) throws Exception {
		commentDao.updateComment(vo);
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
	public void del_comment(CommentVo commentVo) throws Exception {
		
		if(commentVo.getComment_reply_count() == 0) {
			System.out.println("commentVo.getComment_no() : " + commentVo.getComment_no());
			commentDao.del_comment(commentVo.getComment_no());
			commentDao.del_comment_count(commentVo.getBoard_no());
		} else {
			commentDao.fix_comment(commentVo.getComment_no());
		}
	}
	

	
}

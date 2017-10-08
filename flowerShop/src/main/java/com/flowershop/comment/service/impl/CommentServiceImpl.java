package com.flowershop.comment.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowershop.comment.domain.CommentVo;
import com.flowershop.comment.repository.CommentDao;
import com.flowershop.comment.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao commentDao;

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
	
	

	
}

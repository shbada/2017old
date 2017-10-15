package com.flowershop.comment.service;

import java.util.ArrayList;

import com.flowershop.comment.domain.CommentVo;

public interface CommentService {

	void insertComment(CommentVo vo)throws Exception;

	void updateComment(CommentVo vo)throws Exception;

	ArrayList<CommentVo> selectComentList(int board_no)throws Exception;

	void incrementCommentCount(int board_no)throws Exception;
	
	


}

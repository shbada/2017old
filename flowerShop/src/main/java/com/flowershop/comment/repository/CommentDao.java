package com.flowershop.comment.repository;

import java.util.ArrayList;

import com.flowershop.comment.domain.CommentVo;

public interface CommentDao {

	void insertComment(CommentVo vo)throws Exception;

	void updateComment(CommentVo vo)throws Exception;

	ArrayList<CommentVo> selectComentList(int board_no)throws Exception;
	
	
}

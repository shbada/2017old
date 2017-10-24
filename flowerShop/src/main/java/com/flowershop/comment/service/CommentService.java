package com.flowershop.comment.service;

import java.util.ArrayList;
import java.util.Map;

import com.flowershop.comment.domain.CommentVo;

public interface CommentService {

	void insertComment(CommentVo vo)throws Exception;

	void updateComment(Map<String, String> map)throws Exception;

	ArrayList<CommentVo> selectComentList(int board_no)throws Exception;

	void incrementCommentCount(int board_no)throws Exception;

	void del_comment(int comment_no, int borad_no, int comment_reply_count)throws Exception;
	
	


}

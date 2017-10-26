package com.flowershop.comment.repository;

import java.util.ArrayList;
import java.util.Map;

import com.flowershop.comment.domain.CommentVo;

public interface CommentDao {

	void insertComment(CommentVo vo)throws Exception;

	void updateComment(Map<String, String> map)throws Exception;

	ArrayList<CommentVo> selectComentList(int board_no)throws Exception;

	void del_comment(int comment_no)throws Exception;

	void fix_comment(int comment_no)throws Exception;

	void del_comment_count(int board_no)throws Exception;

	CommentVo getCommentVo(int comment_no)throws Exception;

	void incrementCRC(int comment_no)throws Exception;

	int getBefore_ref(int comment_no)throws Exception;

	int getReply_count(int comment_no)throws Exception;

	void incrementCommentSeq(CommentVo commentVo)throws Exception;

	void commentReplyInsert(CommentVo commentVo)throws Exception;

	void subCRC(int comment_no2)throws Exception;

	
}

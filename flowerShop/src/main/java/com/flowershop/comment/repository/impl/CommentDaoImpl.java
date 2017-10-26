package com.flowershop.comment.repository.impl;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flowershop.comment.domain.CommentVo;
import com.flowershop.comment.repository.CommentDao;


@Repository
public class CommentDaoImpl implements CommentDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insertComment(CommentVo vo) throws Exception {
		sqlSession.insert("comment.insertComment", vo);
	}

	@Override
	public void updateComment(Map<String, String> map) throws Exception {
		sqlSession.update("comment.updateComment", map);
	}

	@Override
	public ArrayList<CommentVo> selectComentList(int board_no) throws Exception {
		return (ArrayList) sqlSession.selectList("comment.selectComentList", board_no);
	}

	@Override
	public void del_comment(int comment_no) throws Exception {
		sqlSession.delete("comment.del_comment", comment_no);
	}

	@Override
	public void fix_comment(int comment_no) throws Exception {
		sqlSession.update("comment.fix_comment", comment_no);
	}

	@Override
	public void del_comment_count(int board_no) throws Exception {
		sqlSession.update("comment.del_comment_count", board_no);
	}

	@Override
	public CommentVo getCommentVo(int comment_no) throws Exception {
		return (CommentVo) sqlSession.selectOne("comment.getCommentVo", comment_no);
	}

	@Override
	public void incrementCRC(int comment_no) throws Exception {
		sqlSession.update("comment.incrementCRC", comment_no);
	}

	@Override
	public int getBefore_ref(int comment_no) throws Exception {
		return sqlSession.selectOne("comment.getBefore_ref", comment_no);
	}

	@Override
	public int getReply_count(int comment_no) throws Exception {
		return sqlSession.selectOne("comment.getReply_count", comment_no);
	}

	@Override
	public void incrementCommentSeq(CommentVo commentVo) throws Exception {
		sqlSession.update("comment.incrementCommentSeq", commentVo);
	}

	@Override
	public void commentReplyInsert(CommentVo commentVo) throws Exception {
		sqlSession.insert("comment.commentReplyInsert", commentVo);
	}

	@Override
	public void subCRC(int comment_no2) throws Exception {
		sqlSession.update("comment.subCRC", comment_no2);
	}



}

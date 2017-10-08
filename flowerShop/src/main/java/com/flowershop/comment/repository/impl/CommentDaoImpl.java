package com.flowershop.comment.repository.impl;

import java.util.ArrayList;

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
	public void updateComment(CommentVo vo) throws Exception {
		sqlSession.update("comment.updateComment", vo);
	}

	@Override
	public ArrayList<CommentVo> selectComentList(int board_no) throws Exception {
		return (ArrayList) sqlSession.selectList("comment.selectComentList", board_no);
	}


}

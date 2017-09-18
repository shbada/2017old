package com.flowershop.board.repository.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flowershop.board.domain.BoardVo;
import com.flowershop.board.repository.BoardDao;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insert(BoardVo vo) throws Exception {
		sqlSession.insert("board.write",vo);
	}



}

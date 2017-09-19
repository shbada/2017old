package com.flowershop.board.repository.impl;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flowershop.board.domain.BoardList;
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

	@Override
	public int totalCount() throws Exception{
		return sqlSession.selectOne("board.totalCount");
	}

	@Override
	public ArrayList<BoardVo> getBoardlist(Map<String, Integer> map) throws Exception{
		return (ArrayList)sqlSession.selectList("board.getBoardlist", map);
	}

}

package com.flowershop.join.repository.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flowershop.join.repository.JoinDao;
import com.flowershop.login.domain.UserVo;

@Repository
public class JoinDaoImpl implements JoinDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	@Transactional
	public void join(UserVo userVo) throws Exception {
		sqlSession.insert("join.userJoin", userVo);
	}

	@Override
	public int checkId(String user_id) throws Exception {
		return sqlSession.selectOne("join.checkId", user_id);
	}

}

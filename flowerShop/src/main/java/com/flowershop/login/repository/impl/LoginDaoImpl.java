package com.flowershop.login.repository.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flowershop.login.domain.UserVo;
import com.flowershop.login.repository.LoginDao;

@Repository
public class LoginDaoImpl implements LoginDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public UserVo login(UserVo userVo) throws Exception {
		return sqlSession.selectOne("login.userLogin", userVo);
	}


}

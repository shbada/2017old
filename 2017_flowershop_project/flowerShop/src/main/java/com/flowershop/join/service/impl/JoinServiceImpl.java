package com.flowershop.join.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.flowershop.join.repository.impl.JoinDaoImpl;
import com.flowershop.join.service.JoinService;
import com.flowershop.login.domain.UserVo;

@Service
public class JoinServiceImpl implements JoinService {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	JoinDaoImpl joinDao;

	@Override
	public void join(UserVo user) throws Exception {
		String pw = passwordEncoder.encode(user.getUser_pw());
		user.setUser_pw(pw);
		joinDao.join(user);
	}

	@Override
	public boolean checkId(String user_id) throws Exception {
		return (joinDao.checkId(user_id)) == 1 ? true : false;
	}

}

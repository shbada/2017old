package com.flowershop.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.flowershop.login.domain.UserVo;
import com.flowershop.login.repository.impl.LoginDaoImpl;
import com.flowershop.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	LoginDaoImpl loginDao;

	@Override
	public UserVo login(String user_id) throws Exception {
		return loginDao.login(user_id);
	}
}
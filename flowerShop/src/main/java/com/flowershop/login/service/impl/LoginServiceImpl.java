package com.flowershop.login.service.impl;

import java.util.Date;

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

	@Override
	public void keepLogin(String user_id, String sessionId, Date next) throws Exception {
		loginDao.keepLogin(user_id, sessionId, next);		
	}

	@Override
	public UserVo checkLoginBefore(String value) {
		return loginDao.checkUserWithSessionKey(value);
	}

	@Override
	public UserVo myInfo(String user_id) throws Exception {
		return loginDao.myInfo(user_id);
	}

	@Override
	public void changeInfo(UserVo userVo) throws Exception {
		loginDao.changeInfo(userVo);
	}
}
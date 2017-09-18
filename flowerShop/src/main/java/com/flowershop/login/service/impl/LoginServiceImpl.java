package com.flowershop.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.flowershop.login.domain.UserVo;
import com.flowershop.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserDetailsService userDetailService;
	
	@Override
	public UserDetails login(UserVo userVo) throws Exception {
		String user_id =  userVo.getUser_id();
		return userDetailService.loadUserByUsername(user_id);
	}

}

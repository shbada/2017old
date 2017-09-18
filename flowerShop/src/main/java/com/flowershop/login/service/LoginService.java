package com.flowershop.login.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.flowershop.login.domain.UserVo;

public interface LoginService {

	public UserDetails login(UserVo userVo) throws Exception;
	
}

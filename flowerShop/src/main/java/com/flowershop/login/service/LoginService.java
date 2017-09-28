package com.flowershop.login.service;

import java.util.Date;

import com.flowershop.login.domain.UserVo;

public interface LoginService {

	public UserVo login(String user_id) throws Exception;
	
	public void keepLogin(String user_id, String sessionId, Date next)throws Exception;
	
	public UserVo checkLoginBefore(String value);

}
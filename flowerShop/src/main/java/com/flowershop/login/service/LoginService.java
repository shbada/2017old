package com.flowershop.login.service;

import java.util.Date;

import com.flowershop.login.domain.UserVo;

public interface LoginService {

	public UserVo login(String user_id) throws Exception;
	
	public void keepLogin(String user_id, String sessionId, Date next)throws Exception;
	
	public UserVo checkLoginBefore(String value);
	
	public UserVo myInfo(String user_id)throws Exception;
	
	public void changeInfo(UserVo userVo)throws Exception;
	
	public void changePw(String user_id, String user_pw)throws Exception;
	
	public UserVo mailSending(String tomail) throws Exception;

	public UserVo mailSendingPw(String user_email, String user_id)throws Exception;
}
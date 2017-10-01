package com.flowershop.login.repository;

import java.util.Date;

import com.flowershop.login.domain.UserVo;

public interface LoginDao {
	
	public UserVo login(String user_id)throws Exception;
	
	public void keepLogin(String user_id, String sessionId, Date next);
	
	public UserVo checkUserWithSessionKey(String value);
	
	public UserVo myInfo(String user_id)throws Exception;
	
	public void changeInfo(UserVo userVo)throws Exception;
}

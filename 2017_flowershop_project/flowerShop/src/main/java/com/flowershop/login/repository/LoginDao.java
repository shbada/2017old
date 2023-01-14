package com.flowershop.login.repository;

import java.util.Date;

import com.flowershop.login.domain.UserVo;

public interface LoginDao {

	public UserVo login(String user_id) throws Exception;

	public void keepLogin(String user_id, String sessionId, Date next);

	public UserVo checkUserWithSessionKey(String value);

	public UserVo myInfo(String user_id) throws Exception;

	public void changeInfo(UserVo userVo) throws Exception;

	public void changePw(String user_pw, String user_id) throws Exception;

	public UserVo findUserId(String tomail) throws Exception;

	public UserVo findUserPw(String tomail, String user_id) throws Exception;
	
	public void userPwInit(String user_id, String user_pw)throws Exception;
}

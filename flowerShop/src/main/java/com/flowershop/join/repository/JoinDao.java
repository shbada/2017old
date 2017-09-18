package com.flowershop.join.repository;

import com.flowershop.login.domain.UserVo;
import com.flowershop.util.JSONResult;

public interface JoinDao {

	public void join(UserVo userVo) throws Exception;
	
	public int checkId(String user_id) throws Exception;

}
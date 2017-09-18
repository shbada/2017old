package com.flowershop.join.service;

import com.flowershop.login.domain.UserVo;
import com.flowershop.util.JSONResult;

public interface JoinService {

	public void join(UserVo userVo) throws Exception;
	
	public boolean checkId(String user_id) throws Exception;

}

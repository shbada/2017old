package com.flowershop.login.repository;

import com.flowershop.login.domain.UserVo;

public interface LoginDao {
	
	public UserVo login(UserVo userVo)throws Exception;

}

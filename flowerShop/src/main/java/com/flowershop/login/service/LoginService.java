package com.flowershop.login.service;

import com.flowershop.login.domain.UserVo;

public interface LoginService {

	public UserVo login(UserVo userVo) throws Exception;

}
package com.flowershop.point.repository;

import java.util.Map;

import com.flowershop.login.domain.UserVo;

public interface PointDao {

	public int getPoint(String user_id)throws Exception;
	
	public void recordPoint(Map<String, Object> map) throws Exception;
	
	public void updatePoint(UserVo userVo) throws Exception;
}

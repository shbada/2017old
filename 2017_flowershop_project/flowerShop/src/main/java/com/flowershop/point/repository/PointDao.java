package com.flowershop.point.repository;

import java.util.List;
import java.util.Map;

import com.flowershop.login.domain.UserVo;
import com.flowershop.point.domain.ListVo;

public interface PointDao {

	public int getPoint(String user_id) throws Exception;

	public void recordPoint(Map<String, Object> map) throws Exception;

	public void updatePoint(UserVo userVo) throws Exception;

	public List<ListVo> getPointList(String user_id) throws Exception;
}

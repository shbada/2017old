package com.flowershop.point.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowershop.login.domain.UserVo;
import com.flowershop.point.repository.impl.PointDaoImpl;
import com.flowershop.point.service.PointService;

@Service
public class PointServiceImpl implements PointService {

	@Autowired
	private PointDaoImpl pointDao;

	@Override
	public int getPoint(String user_id) throws Exception {
		return pointDao.getPoint(user_id);
	}

	@Override
	public void recordPoint(Map<String, Object> map) throws Exception {
		pointDao.recordPoint(map);
	}

	@Override
	public void updatePoint(UserVo userVo) throws Exception {
		pointDao.updatePoint(userVo);

	}

}

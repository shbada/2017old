package com.flowershop.point.repository.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flowershop.buy.domain.BuyVo;
import com.flowershop.login.domain.UserVo;
import com.flowershop.point.domain.PointVo;
import com.flowershop.point.repository.PointDao;

@Repository
public class PointDaoImpl implements PointDao {

	@Autowired
	private SqlSession session;

	@Override
	public int getPoint(String user_id) throws Exception {
		return session.selectOne("point.getPoint", user_id);
	}

	@Override
	public void recordPoint(Map<String, Object> map) throws Exception {
		session.insert("point.recordPoint", map);
	}

	@Override
	public void updatePoint(UserVo userVo) throws Exception {
		session.update("point.updatePoint", userVo);
	}

}

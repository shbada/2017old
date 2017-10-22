package com.flowershop.point.repository.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flowershop.point.repository.PointDao;

@Repository
public class PointDaoImpl implements PointDao{

	@Autowired
	private SqlSession session;

	@Override
	public int getPoint(String user_id) throws Exception {
		return session.selectOne("point.getPoint", user_id);
	}
	
}

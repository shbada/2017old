package com.flowershop.buy.repository.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flowershop.buy.repository.BuyDao;

@Repository
public class BuyDaoImpl implements BuyDao {

	@Autowired
	SqlSession sqlSession;
	
}

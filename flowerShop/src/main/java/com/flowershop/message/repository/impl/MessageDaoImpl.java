package com.flowershop.message.repository.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flowershop.message.repository.MessageDao;

@Repository
public class MessageDaoImpl implements MessageDao{
	
	@Autowired
	private SqlSession session;

}

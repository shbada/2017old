package com.flowershop.afterReply.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flowershop.afterReply.domain.AfterReplyVo;
import com.flowershop.afterReply.repository.AfterReplyDao;

@Repository
public class AfterReplyDaoImpl implements AfterReplyDao{
	
	@Autowired
	private SqlSession session;

	@Override
	public List<AfterReplyVo> afterReplyList(int productNo) {
		return session.selectList("afterReply.afterReplyList", productNo);
	}
}

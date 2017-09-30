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
	public List<AfterReplyVo> afterReplyList(AfterReplyVo afterReplyVo) {
		return session.selectList("afterReply.afterReplyList", afterReplyVo);
	}

	@Override
	public AfterReplyVo afterReplyUpdate(AfterReplyVo afterReplyVo) {
		return (AfterReplyVo) session.selectList("afterReply.afterReplyList", afterReplyVo);
	}

	@Override
	public void afterReplyUpdateSave(AfterReplyVo afterReplyVo) {
		session.update("afterReply.afterReplyUpdateSave", afterReplyVo);
	}

	@Override
	public void afterReplyDelete(AfterReplyVo afterReplyVo) {
		session.delete("afterReply.afterReplyDelete", afterReplyVo);
	}

	@Override
	public void afterReplyWriteSave(AfterReplyVo afterReplyVo) {
		session.insert("afterReply.afterReplyWriteSave", afterReplyVo);
	}
}

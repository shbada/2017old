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

	public void afterReplyWrite(AfterReplyVo afterReplyVo) {
		session.insert("reply.afterReplyWrite",afterReplyVo);
	}
	
	public void AfterReplyDelete(int freeBorReplyIdx) {
		session.delete("reply.AfterReplyDelete", freeBorReplyIdx);
	}
	
	public void AfterReplyUpdate(AfterReplyVo afterReplyVo) {
		session.update("reply.AfterReplyUpdate", afterReplyVo);
	}
	
	public int afterReplyCount(AfterReplyVo afterReplyVo) {
		return (int) session.selectOne("reply.afterReplyCount", afterReplyVo);
	}

	public List<AfterReplyVo> afterReplyList(AfterReplyVo afterReplyVo) {
		return session.selectList("reply.afterReplyList", afterReplyVo);
	}

}

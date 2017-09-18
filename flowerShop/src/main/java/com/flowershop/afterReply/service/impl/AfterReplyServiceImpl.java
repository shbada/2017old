package com.flowershop.afterReply.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowershop.afterReply.domain.AfterReplyVo;
import com.flowershop.afterReply.repository.AfterReplyDao;
import com.flowershop.afterReply.service.AfterReplyService;

@Service
public class AfterReplyServiceImpl implements AfterReplyService {
	
	@Autowired
	private AfterReplyDao afterReplyDao;
	
	@Override
	public List<AfterReplyVo> afterReplyList(int productNo) {
		return afterReplyDao.afterReplyList(productNo);
	}

}

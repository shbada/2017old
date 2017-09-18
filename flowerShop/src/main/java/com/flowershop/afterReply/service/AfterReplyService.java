package com.flowershop.afterReply.service;

import java.util.List;

import com.flowershop.afterReply.domain.AfterReplyVo;

public interface AfterReplyService {
	
	List<AfterReplyVo> afterReplyList(int productNo);
}

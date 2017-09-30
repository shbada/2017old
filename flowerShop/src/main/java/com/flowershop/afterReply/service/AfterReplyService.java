package com.flowershop.afterReply.service;

import java.util.List;

import com.flowershop.afterReply.domain.AfterReplyVo;

public interface AfterReplyService {
	
	List<AfterReplyVo> afterReplyList(AfterReplyVo afterReplyVo);

	AfterReplyVo afterReplyUpdate(AfterReplyVo afterReplyVo);

	void afterReplyUpdateSave(AfterReplyVo afterReplyVo);

	void afterReplyDelete(AfterReplyVo afterReplyVo);

	void afterReplyWriteSave(AfterReplyVo afterReplyVo);
}

package com.flowershop.afterReply.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.flowershop.afterReply.domain.AfterReplyVo;

public interface AfterReplyService {
	
	void afterReplyWrite(AfterReplyVo afterReplyVo);
	
	void AfterReplyDelete(int freeBorReplyIdx);
	
	void AfterReplyUpdate(AfterReplyVo afterReplyVo);

	int afterReplyCount(AfterReplyVo afterReplyVo);

	List<AfterReplyVo> afterReplyList(AfterReplyVo afterReplyVo, HttpSession session);

}

package com.flowershop.afterReply.repository;

import java.util.List;

import com.flowershop.afterReply.domain.AfterReplyVo;

public interface AfterReplyDao {

	List<AfterReplyVo> afterReplyList(AfterReplyVo afterReplyVo);

	AfterReplyVo afterReplyUpdate(AfterReplyVo afterReplyVo);

	void afterReplyUpdateSave(AfterReplyVo afterReplyVo);

	void afterReplyDelete(AfterReplyVo afterReplyVo);

	void afterReplyWriteSave(AfterReplyVo afterReplyVo);

}

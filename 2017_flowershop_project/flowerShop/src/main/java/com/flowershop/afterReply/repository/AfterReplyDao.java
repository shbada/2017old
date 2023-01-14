package com.flowershop.afterReply.repository;

import java.util.List;

import com.flowershop.afterReply.domain.AfterReplyVo;

public interface AfterReplyDao {

	void afterReplyWrite(AfterReplyVo afterReplyVo);

	void AfterReplyDelete(int freeBorReplyIdx);

	void AfterReplyUpdate(AfterReplyVo afterReplyVo);

	int afterReplyCount(AfterReplyVo afterReplyVo);

	List<AfterReplyVo> afterReplyList(AfterReplyVo afterReplyVo);

}

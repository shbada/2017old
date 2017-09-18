package com.flowershop.afterReply.repository;

import java.util.List;

import com.flowershop.afterReply.domain.AfterReplyVo;

public interface AfterReplyDao {

	List<AfterReplyVo> afterReplyList(int productNo);

}

package com.flowershop.message.repository;

import java.util.List;

import com.flowershop.message.domain.MessageVo;

public interface MessageDao {

	void MessageWriteSave(MessageVo messageVo);

	List<MessageVo> messageList(MessageVo messageVo);

	List<MessageVo> MessageSendList(MessageVo messageVo);

	void MessageSendDelete(MessageVo messageVo);

	void MessageGetDelete(MessageVo messageVo);

	void messageGetListDel(MessageVo messageVo);

	void messageSendListDel(MessageVo messageVo);

	MessageVo messageDetail(MessageVo messageVo);

	void messageReadYn(MessageVo messageVo);

	int MessageIdCheck(String idCheck);

	int messageNewCount(String user_id);

}

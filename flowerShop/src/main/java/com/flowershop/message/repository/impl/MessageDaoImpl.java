package com.flowershop.message.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flowershop.message.domain.MessageVo;
import com.flowershop.message.repository.MessageDao;

@Repository
public class MessageDaoImpl implements MessageDao{
	
	@Autowired
	private SqlSession session;

	@Override
	public void MessageWriteSave(MessageVo messageVo) {
		session.insert("message.MessageWriteSave", messageVo);
	}

	@Override
	public List<MessageVo> messageList(MessageVo messageVo) {
		return session.selectList("message.messageList", messageVo);
	}

	@Override
	public List<MessageVo> MessageSendList(MessageVo messageVo) {
		return session.selectList("message.MessageSendList", messageVo);
	}

	@Override
	public void MessageSendDelete(MessageVo messageVo) {
		session.update("message.MessageSendDelete", messageVo);
	}

	@Override
	public void MessageGetDelete(MessageVo messageVo) {
		session.update("message.MessageGetDelete", messageVo);
	}

	@Override
	public void messageGetListDel(MessageVo messageVo) {
		session.update("message.MessageGetDelete", messageVo);
	}

	@Override
	public void messageSendListDel(MessageVo messageVo) {
		session.update("message.MessageSendDelete", messageVo);
	}

	@Override
	public MessageVo messageDetail(MessageVo messageVo) {
		return session.selectOne("message.messageDetail", messageVo);
	}

	@Override
	public void messageReadYn(MessageVo messageVo) {
		session.update("message.messageReadYn", messageVo);
	}

	@Override
	public int MessageIdCheck(String idCheck) {
		return session.selectOne("message.MessageIdCheck", idCheck);
	}

	@Override
	public int messageNewCount(String user_id) {
		return session.selectOne("message.messageNewCount", user_id);
	}

}

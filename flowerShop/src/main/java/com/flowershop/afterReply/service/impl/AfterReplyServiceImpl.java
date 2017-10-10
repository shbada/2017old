package com.flowershop.afterReply.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowershop.afterReply.domain.AfterReplyVo;
import com.flowershop.afterReply.repository.AfterReplyDao;
import com.flowershop.afterReply.service.AfterReplyService;
import com.flowershop.login.domain.UserVo;

@Service
public class AfterReplyServiceImpl implements AfterReplyService {
	
	@Autowired
	private AfterReplyDao afterReplyDao;
	
	@Override
	public void afterReplyWrite(AfterReplyVo afterReplyVo) {
		afterReplyDao.afterReplyWrite(afterReplyVo);
	}
	
	@Override
	public void AfterReplyDelete(int freeBorReplyIdx) {
		afterReplyDao.AfterReplyDelete(freeBorReplyIdx);
	}
	
	@Override
	public void AfterReplyUpdate(AfterReplyVo afterReplyVo) {
		afterReplyDao.AfterReplyUpdate(afterReplyVo);
	}
	
	@Override
	public int afterReplyCount(AfterReplyVo afterReplyVo) {
		return afterReplyDao.afterReplyCount(afterReplyVo);
	}

	@Override
	public List<AfterReplyVo> afterReplyList(AfterReplyVo afterReplyVo, HttpSession session) {
		
		if (session.getAttribute("authUser") != null){
			UserVo userVo = (UserVo)session.getAttribute("authUser");
			String user_id = userVo.getUser_id();
			
			afterReplyVo.setUser_id(user_id);
		}
		
		List<AfterReplyVo> items = afterReplyDao.afterReplyList(afterReplyVo);
		
		for(AfterReplyVo vo : items){
			vo.setAfter_content(vo.getAfter_content().replaceAll("<", "&lt;").replaceAll("&lt;br>", "<br>"));
		}
		
		return items;
	}

}

package com.flowershop.admin.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.flowershop.admin.domain.RequestVo;
import com.flowershop.admin.repository.AdminDAO;
import com.flowershop.admin.service.AdminService;
import com.flowershop.login.domain.UserVo;

@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	AdminDAO adminDAO;
	
	//1:1문의글 전체 목록
	@Override
	public List<RequestVo> one_to_oneAll() throws Exception {
		
		return adminDAO.one_to_oneAll();
	}

	//1:1문의글 작성
	@Override
	public void requestCreate(RequestVo vo) throws Exception {				
		int request_no = vo.getRequest_no();
		String request_title = vo.getRequest_title();
		String request_content = vo.getRequest_content();
		String request_kind = vo.getRequest_kind();		
		vo.setRequest_no(request_no);
		vo.setRequest_title(request_title);
		vo.setRequest_content(request_content);
		vo.setRequest_kind(request_kind);
		adminDAO.requestCreate(vo);
	}
		
	
	//1:1문의글 상세 보기
	@Override
	public RequestVo requestRead(int request_no) throws Exception {
		
		return adminDAO.requestRead(request_no);
	}

	//1:1문의글 수정
	@Override
	public void requestUpdate(RequestVo vo) throws Exception {
		
		adminDAO.requestUpdate(vo);
	}
	
	//1:1문의글 삭제
	@Override
	public void requestDelete(int request_no) throws Exception {
		
		adminDAO.requestDelete(request_no);
	}

	@Override
	public List<UserVo> allMemberList() throws Exception {
		
		return adminDAO.allMemberList();
	}

	@Override
	public void allListDelete(List<UserVo> data) throws Exception {
		for(int i=0; i<data.size(); i++)
			adminDAO.allListDelete(data.get(i));
		
	}

	@Override
	public UserVo memberDetail(UserVo userVo) {
		return adminDAO.memberDetail(userVo);
	}

	@Override
	public void memberDelete(UserVo userVo) {
		adminDAO.memberDelete(userVo);
	}

	@Override
	public void memberDown(UserVo userVo) {
		adminDAO.memberDown(userVo);
	}

	@Override
	public void memberUp(UserVo userVo) {
		adminDAO.memberUp(userVo);
	}

	
}

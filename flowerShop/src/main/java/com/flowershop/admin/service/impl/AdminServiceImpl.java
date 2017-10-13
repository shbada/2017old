package com.flowershop.admin.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.flowershop.admin.repository.AdminDAO;
import com.flowershop.admin.service.AdminService;
import com.flowershop.login.domain.UserVo;

@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	AdminDAO adminDAO;
	
	@Override
	public List<UserVo> allMemberList() {
		
		return adminDAO.allMemberList();
	}

	@Override
	public void deleteMember(String user_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember(UserVo vo) {
		// TODO Auto-generated method stub
		
	}
	
}

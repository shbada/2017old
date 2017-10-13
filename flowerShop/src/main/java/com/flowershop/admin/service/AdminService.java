package com.flowershop.admin.service;

import java.util.List;

import com.flowershop.login.domain.UserVo;

public interface AdminService {
	
		//회원 전체 목록
		public List<UserVo> allMemberList();
		
		//회원 삭제
		public void deleteMember(String user_id);
		
		//회원 수정
		public void updateMember(UserVo vo);
}

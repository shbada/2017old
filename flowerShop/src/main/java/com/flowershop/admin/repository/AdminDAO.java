package com.flowershop.admin.repository;

import java.util.List;

import com.flowershop.login.domain.UserVo;

public interface AdminDAO {
	
	//회원 전체 목록
	public List<UserVo> allMemberList();
	
	//회원 삭제
	public void deleteMember(String user_id);
	
	//회원 수정
	public void updateMember(UserVo vo);
}

package com.flowershop.admin.service;

import java.util.List;

import com.flowershop.admin.domain.RequestVo;
import com.flowershop.login.domain.UserVo;

public interface AdminService {
	
		//전체 회원 관리
		public List<UserVo> allMemberList() throws Exception;
		
		//1:1문의 목록
		public List<RequestVo> one_to_oneAll() throws Exception;
		
		//고객센터 문의 작성
		public void requestCreate(RequestVo vo) throws Exception;
		
		//1:1문의 상세보기
		public RequestVo requestRead(int request_no) throws Exception;
		
		//1:1문의 삭제
		public void requestDelete(int request_no) throws Exception;
		
		//1:1문의 수정
		public void requestUpdate(RequestVo vo) throws Exception;
		
		//전체 목록
		public void allListDelete(List<UserVo> data) throws Exception;
		
		//회원 등급 변경
		public void usersUpdate(UserVo vo) throws Exception;
				
}

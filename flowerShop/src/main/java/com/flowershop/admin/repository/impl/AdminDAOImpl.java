package com.flowershop.admin.repository.impl;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.flowershop.admin.domain.RequestVo;
import com.flowershop.admin.repository.AdminDAO;
import com.flowershop.login.domain.UserVo;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Inject
	SqlSession sqlSession; //마이바티스 xml 연동 객체 자동 주입

	@Override
	public List<UserVo> allMemberList() throws Exception {
		
		return sqlSession.selectList("admin.allMemberList");
	}

	//1:1전체 목록
	@Override
	public List<RequestVo> one_to_oneAll() throws Exception {
		
		return sqlSession.selectList("admin.one_to_oneAll");
	}

	//1:1문의글 작성
	@Override
	public void requestCreate(RequestVo vo) throws Exception {
		
		sqlSession.insert("admin.requestCreate", vo);
	}

	//1:1문의 상세보기
	@Override
	public RequestVo requestRead(int request_no) throws Exception {
		
		return sqlSession.selectOne("admin.requestRead", request_no);
	}
	
	//1:1문의글 삭제
	@Override
	public void requestDelete(int request_no) throws Exception {
		
		sqlSession.delete("admin.requestDelete", request_no);
	}

	//1:1문의글 수정
	@Override
	public void requestUpdate(RequestVo vo) throws Exception {
		
		sqlSession.update("admin.requestUpdate", vo);
	}

	@Override
	public void allListDelete(UserVo userVo) throws Exception {
		sqlSession.delete("admin.allListDelete", userVo);
		
	}

	@Override
	public void usersUpdate(UserVo vo) throws Exception {
		sqlSession.update("admin.usersUpdate", vo);
		
	}	


}

package com.flowershop.admin.repository.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.flowershop.admin.repository.AdminDAO;
import com.flowershop.login.domain.UserVo;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Inject
	SqlSession sqlSession; //마이바티스 xml 연동 객체 자동 주입

	@Override
	public List<UserVo> allMemberList() {
		
		return sqlSession.selectList("admin.allMemberList");
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

package com.flowershop.like.repository.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flowershop.like.repository.LikeDao;

@Repository
public class LikeDaoImpl implements LikeDao{
	
	/*@Autowired
	private SqlSession session;

	@Override
	public int LikeSelect(int productNo) {
		return (int) session.selectOne("like.LikeSelect", productNo);
	}

	@Override
	public ProductVo LikeUpSelect(ProductVo productVo) {
		return (ProductVo) session.selectOne("like.LikeUpSelect", productVo);
	}

	@Override
	public void likeUpSave(ProductVo productVo) {
		session.insert("like.likeUpSave", productVo);
	}*/

}

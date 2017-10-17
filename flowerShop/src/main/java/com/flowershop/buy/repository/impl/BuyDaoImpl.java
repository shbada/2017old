package com.flowershop.buy.repository.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flowershop.buy.domain.BuyVo;
import com.flowershop.buy.repository.BuyDao;
import com.flowershop.cart.domain.CartVo;

@Repository
public class BuyDaoImpl implements BuyDao {

	@Autowired
	SqlSession sqlSession;

	public void buyInsert(BuyVo buyVo)throws Exception{
		sqlSession.insert("buy.buyInsert", buyVo);
	}

	@Override
	public CartVo cartList(String cartNo) throws Exception {
		return (CartVo)sqlSession.selectList("buy.cartList", cartNo);
	}
	
}

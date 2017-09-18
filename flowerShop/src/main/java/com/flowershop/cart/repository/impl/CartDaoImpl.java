package com.flowershop.cart.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flowershop.cart.domain.CartVo;
import com.flowershop.cart.repository.CartDao;

@Repository
public class CartDaoImpl implements CartDao{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<CartVo> cartList(String userId) {
		return session.selectList("cart.cartList", userId);
	}

	@Override
	public int sumMoney(String userId) {
		return session.selectOne("cart.sumMoney", userId);
	}

}

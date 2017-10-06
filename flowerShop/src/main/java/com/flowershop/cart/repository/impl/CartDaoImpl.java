package com.flowershop.cart.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public void cartInsert(CartVo cartVo) {
		session.insert("cart.cartInsert", cartVo);
	}

	@Override
	public void cartUpdate(CartVo cartVo) {
		session.update("cart.cartUpdate", cartVo);
	}

	@Override
	public int countCart(int productNo, String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("productNo", productNo);
        map.put("userId", userId);
        return (int)session.selectOne("cart.countCart", map);
	}

	@Override
	public void UpdateCount(CartVo cartVo) {
		session.update("cart.UpdateCount", cartVo);
	}
}

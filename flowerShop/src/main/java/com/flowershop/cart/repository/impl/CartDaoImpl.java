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
	public List<CartVo> cartList(String user_id) {
		return session.selectList("cart.cartList", user_id);
	}

	@Override
	public int sumMoney(String user_id) {
		return session.selectOne("cart.sumMoney", user_id);
	}

	@Override
	public void cartInsert(CartVo cartVo) {
		session.insert("cart.cartInsert", cartVo);
	}

	@Override
	public void cartDelete(int product_no) {
		session.delete("cart.cartDelete", product_no);
	}

	@Override
	public void cartUpdate(CartVo cartVo) {
		session.update("cart.cartUpdate", cartVo);
	}

	@Override
	public int countCart(int product_no, String user_id) {
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("product_no", product_no);
        map.put("user_id", user_id);
        return (int)session.selectOne("cart.countCart", map);
	}

	@Override
	public void UpdateCount(CartVo cartVo) {
		session.update("cart.UpdateCount", cartVo);
	}
	
	public void cartListDelete(CartVo cartVo) {
		session.delete("cart.cartListDelete", cartVo);
	}
}

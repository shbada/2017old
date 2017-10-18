package com.flowershop.buy.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public List<CartVo> cartList(String cartNo) throws Exception {
		return sqlSession.selectList("buy.cartList", cartNo);
	}

	@Override
	public void buyInfo_insert(Map<String, Integer> map) throws Exception {
		sqlSession.insert("buy.buyInfo_insert", map);
	}

	@Override
	public int getBuy_no(String user_id) throws Exception {
		return sqlSession.selectOne("buy.getBuy_no", user_id);
	}

	@Override
	public void delete_product(String cart_no) throws Exception {
		sqlSession.delete("buy.delete_product", cart_no);
	}
	
}

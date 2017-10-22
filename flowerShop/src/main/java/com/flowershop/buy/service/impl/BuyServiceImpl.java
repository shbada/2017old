package com.flowershop.buy.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowershop.buy.domain.BuyVo;
import com.flowershop.buy.repository.BuyDao;
import com.flowershop.buy.service.BuyService;
import com.flowershop.cart.domain.CartVo;

@Service
public class BuyServiceImpl implements BuyService{
	
	@Autowired
	BuyDao buyDao;

	
	@Override
	public void buyInsert(BuyVo buyVo) throws Exception {
		buyDao.buyInsert(buyVo);
	}

	@Override
	public void cartList(String[] cartNo, int getBuy_no) throws Exception {
		
		List<CartVo> cartVo = null;
		Map<String, Integer> map = new HashMap<>(); 
		for(int i=0; i<cartNo.length; i++) {
			cartVo = buyDao.cartList(cartNo[i]);				// 해당 cart_no 로 정보 cart table의 정보를 가져온다.
			map.put("product_amount", cartVo.get(0).getProduct_amount());
			map.put("product_no", cartVo.get(0).getProduct_no());
			map.put("buy_no", getBuy_no);
			buyDao.buyInfo_insert(map);						// 가지고온 cartVo, getBuy_no를 가지고 buyInfo 에 insert 해준다.
			buyDao.delete_product(cartNo[i]);
		}
	}

	@Override
	public int getBuy_no(String user_id) throws Exception {
		return buyDao.getBuy_no(user_id);
	}

	@Override
	public List<CartVo> getCartList(String[] cartNo) throws Exception {
		List<CartVo> list = new ArrayList<CartVo>();
		
		for(int i = 0; i<cartNo.length; i++) {
			list.addAll(buyDao.getCartList(cartNo[i]));
			System.out.println("list : " + list);
		}
		return list;
	}

	@Override
	public int getPartSumMoney(String[] cartNo) throws Exception {
		int sumMoney = 0;
		for(int i=0; i<cartNo.length; i++) {
			sumMoney += buyDao.getPartSumMoney(cartNo[i]);			// cart_no 로 상품의 개수 * 상품가격을 해서 가져온다 (상품종류 1건씩) 
		}
		
		return sumMoney;
	}	
	
}

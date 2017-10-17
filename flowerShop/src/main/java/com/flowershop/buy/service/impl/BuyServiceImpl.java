package com.flowershop.buy.service.impl;

import java.util.List;

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
	public List<CartVo> cartList(String[] cartNo) throws Exception {
		
		List<CartVo> cartList = null;
		 
//		for(int i=0; i<cartNo.length; i++) {
//			cartList.set(i, buyDao.cartList(cartNo[i]));
//		}
		
		
		return null;
	}

	
	
}

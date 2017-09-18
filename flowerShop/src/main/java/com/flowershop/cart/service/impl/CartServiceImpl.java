package com.flowershop.cart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowershop.cart.domain.CartVo;
import com.flowershop.cart.repository.CartDao;
import com.flowershop.cart.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao cartDao;

	@Override
	public List<CartVo> cartList(String userId) {
		return cartDao.cartList(userId);
	}

	@Override
	public int sumMoney(String userId) {
		return cartDao.sumMoney(userId);
	}

}

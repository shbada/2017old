package com.flowershop.cart.service;

import java.util.List;

import com.flowershop.cart.domain.CartVo;

public interface CartService {

	List<CartVo> cartList(String userId);

	int sumMoney(String userId);

}

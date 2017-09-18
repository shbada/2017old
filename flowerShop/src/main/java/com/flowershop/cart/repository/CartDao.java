package com.flowershop.cart.repository;

import java.util.List;

import com.flowershop.cart.domain.CartVo;

public interface CartDao {

	List<CartVo> cartList(String userId);

	int sumMoney(String userId);

}

package com.flowershop.buy.service;

import java.util.List;

import com.flowershop.buy.domain.BuyVo;
import com.flowershop.cart.domain.CartVo;

public interface BuyService {

	void buyInsert(BuyVo buyVo)throws Exception;

	List<CartVo> cartList(String[] cartNo)throws Exception;

}

package com.flowershop.buy.repository;

import com.flowershop.buy.domain.BuyVo;
import com.flowershop.cart.domain.CartVo;

public interface BuyDao {

	void buyInsert(BuyVo buyVo)throws Exception;

	CartVo cartList(String cartNo)throws Exception;

}

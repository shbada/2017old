package com.flowershop.buy.service;

import java.util.List;

import com.flowershop.buy.domain.BuyVo;
import com.flowershop.cart.domain.CartVo;

public interface BuyService {

	void buyInsert(BuyVo buyVo)throws Exception;

	void cartList(String[] cartNo, int getBuy_no)throws Exception;

	int getBuy_no(String user_id)throws Exception;

	List<CartVo> getCartList(String[] cartNo)throws Exception;

}

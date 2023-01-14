package com.flowershop.cart.service;

import java.util.List;

import com.flowershop.cart.domain.CartVo;

public interface CartService {

	List<CartVo> cartList(String user_id);

	void cartDelete(int product_no);
	
	void cartInsert(CartVo cartVo);
	
	void cartUpdate(CartVo cartVo);
	
	int countCart(int product_no, String user_id);
	
	void UpdateCount(CartVo cartVo);

	void cartListDelete(List<CartVo> data);

}

package com.flowershop.cart.repository;

import java.util.List;

import com.flowershop.cart.domain.CartVo;

public interface CartDao {

	List<CartVo> cartList(String user_id);

	void cartInsert(CartVo cartVo);

	void cartDelete(int product_no);

	void cartUpdate(CartVo cartVo);

	int countCart(int product_no, String user_id);

	void UpdateCount(CartVo cartVo);

	void cartListDelete(CartVo cartVo);
}

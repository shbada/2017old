package com.flowershop.buy.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.flowershop.buy.domain.BuyVo;
import com.flowershop.cart.domain.CartVo;

public interface BuyDao {

	void buyInsert(BuyVo buyVo)throws Exception;

	List<CartVo> cartList(String cartNo)throws Exception;

	void buyInfo_insert(Map<String, Integer> map)throws Exception;

	int getBuy_no(String user_id)throws Exception;

	void delete_product(String cart_no)throws Exception;

	List<CartVo> getCartList(String cart_no)throws Exception;

}

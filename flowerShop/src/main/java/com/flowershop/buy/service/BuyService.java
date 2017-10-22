package com.flowershop.buy.service;

import java.util.List;

import com.flowershop.buy.domain.BuyVo;
import com.flowershop.cart.domain.CartVo;

public interface BuyService {

	void buyInsert(BuyVo buyVo)throws Exception;						// 구매 테이블에 buyVo 삽입

	void cartList(String[] cartNo, int getBuy_no)throws Exception;		// 구매상품정보  테이블에 insert & cart 테이블 에서 해당삼품 삭제

	int getBuy_no(String user_id)throws Exception;						//  buyInsert실행후 buy_no를 가지고 온다.

	List<CartVo> getCartList(String[] cartNo)throws Exception;			//   cart_no를 가지고  반복문을 통해서 list를 가져온다.

	int getSalePrice(int product_no)throws Exception;

}

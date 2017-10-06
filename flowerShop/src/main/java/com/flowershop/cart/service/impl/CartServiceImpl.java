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

	/** 장바구니안에 상품 넣기 */
    @Override
    public void cartInsert(CartVo cartVo) {
        cartDao.cartInsert(cartVo);
    }
    
    /** 장바구니 목록 가져오기 */
    @Override
    public List<CartVo> cartList(String userId) {
        return cartDao.cartList(userId);
    }
    
    /** 장바구니에 담겨진 상품의 개수를 수정한 개수로 대체 */
    @Override
    public void cartUpdate(CartVo cartVo) {
        cartDao.cartUpdate(cartVo);
    }
    
    /** 장바구니 금액 합계 */
    @Override
    public int sumMoney(String userId) {
        return cartDao.sumMoney(userId);
    }
    
    /** 장바구니에 해당 상품이 존재하는지, 아닌지 여부 검사 */
    @Override
    public int countCart(int productNo, String userId) {
        return cartDao.countCart(productNo, userId);
    }
    
    /** 장바구니안에 원래 존재한 상품이면, 선택된 개수를 원래 개수에 더해야함 (원래개수+장바구니에 중복된 상품 추가 개수) */
	@Override
	public void UpdateCount(CartVo cartVo) {
		cartDao.UpdateCount(cartVo);
	}


}

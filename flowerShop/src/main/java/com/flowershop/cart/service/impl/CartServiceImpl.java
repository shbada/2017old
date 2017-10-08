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

    @Override
    public void cartInsert(CartVo cartVo) {
        cartDao.cartInsert(cartVo);
    }
    
    @Override
    public List<CartVo> cartList(String user_id) {
        return cartDao.cartList(user_id);
    }
    
    @Override
    public void cartDelete(int product_no) {
        cartDao.cartDelete(product_no);
    }
    
    @Override
    public void cartUpdate(CartVo cartVo) {
        cartDao.cartUpdate(cartVo);
    }
    
    @Override
    public int sumMoney(String user_id) {
        return cartDao.sumMoney(user_id);
    }
    
    @Override
    public int countCart(int product_no, String user_id) {
        return cartDao.countCart(product_no, user_id);
    }
    
	@Override
	public void UpdateCount(CartVo cartVo) {
		cartDao.UpdateCount(cartVo);
	}
	
	@Override
	public void cartListDelete(List<CartVo> data) {
		for(int i=0; i<data.size(); i++)
			cartDao.cartListDelete(data.get(i));
	}


}

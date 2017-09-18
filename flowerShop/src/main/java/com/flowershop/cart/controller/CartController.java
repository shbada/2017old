package com.flowershop.cart.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flowershop.cart.service.CartService;

@Controller
public class CartController {
	
	private Log log = LogFactory.getLog(CartController.class);

	@Autowired
	private CartService cartService;
	
	@RequestMapping("/cartList")
	public String CartList(HttpSession session, Model model){
		
		/*String userId = (String) session.getAttribute("userId");
        
        Map<String, Object> map = new HashMap<String, Object>();
        
        List<CartVo> list = cartService.cartList(userId);
        int sumMoney = cartService.sumMoney(userId); 

        int fee = sumMoney >= 100000 ? 0 : 2500;
        
        map.put("list", list);                
        map.put("count", list.size());       
        map.put("sumMoney", sumMoney);      
        map.put("fee", fee);                
        map.put("allSum", sumMoney+fee);   
        
        model.addAttribute("map", map); 
        
        log.info(list);*/
        
		return "cart/cartList";
	}
}

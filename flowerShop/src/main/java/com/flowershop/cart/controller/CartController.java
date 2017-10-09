package com.flowershop.cart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flowershop.cart.domain.CartVo;
import com.flowershop.cart.service.CartService;
import com.flowershop.login.domain.UserVo;

@Controller
public class CartController {

	private Log log = LogFactory.getLog(CartController.class);

	@Autowired
	private CartService cartService;
	
	@RequestMapping("/cartInsert")
    @ResponseBody
    public String CartInsert(@ModelAttribute CartVo cartVo, HttpSession session){
    	
		if (session.getAttribute("authUser") == null){
    		return "fal";
    	}
		
		UserVo userVo = (UserVo)session.getAttribute("authUser");
		String user_id = userVo.getUser_id();
		
    	if (user_id != null){
	       
    		cartVo.setUser_id(user_id); 
	        int count = cartService.countCart(cartVo.getProduct_no(), user_id);
	        if(count == 0){
	            cartService.cartInsert(cartVo);
	        } else {
	            cartService.UpdateCount(cartVo); 
	        }
    	}
        return "ok";
    }
	
	@RequestMapping("/cartList")
	public String CartList(HttpSession session, Model model) {
		
		UserVo userVo = (UserVo)session.getAttribute("authUser");
		String user_id = userVo.getUser_id();
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<CartVo> list = cartService.cartList(user_id);
		
		int sumMoney = cartService.sumMoney(user_id);
		int fee = sumMoney >= 100000 ? 0 : 2500;

		map.put("list", list);
		map.put("count", list.size());
		map.put("sumMoney", sumMoney);
		map.put("fee", fee);
		map.put("allSum", sumMoney + fee);

		model.addAttribute("map", map);

		return "cart/cartList";
	}

	@RequestMapping("/cartDelete")
	public String CartDelete(@RequestParam int product_no) {
		cartService.cartDelete(product_no); 
		return "redirect:/cartList";
	}

	@RequestMapping(value = "/cartUpdate", method = RequestMethod.POST)
	public String CartUpdate(@RequestParam int[] product_amount, @RequestParam int[] product_no, HttpSession session) {

		UserVo userVo = (UserVo)session.getAttribute("authUser");
		String user_id = userVo.getUser_id();
		
		for (int i = 0; i < product_no.length; i++) {
			CartVo cartVo = new CartVo();
			cartVo.setUser_id(user_id); 
			cartVo.setProduct_amount(product_amount[i]); 
			cartVo.setProduct_no(product_no[i]); 
			cartService.cartUpdate(cartVo); 
		}
		return "redirect:/cartList";
	}
	
	@RequestMapping(value="/cartListDelete", method=RequestMethod.POST, consumes="application/json")	 
	public void CartListDelete(@RequestBody List<CartVo> data) {
		cartService.cartListDelete(data);
	}
}

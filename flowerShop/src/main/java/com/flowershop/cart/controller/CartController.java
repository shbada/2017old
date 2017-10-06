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
    	
		Object obj = session.getAttribute("authUser");
		
		UserVo vo = (UserVo) obj;
		String userId = vo.getUser_id();
		
    	if (userId == null){
    		return "fal";
    	}
    	
    	if (userId != null){
    		
	        cartVo.setUserId(userId); 
	        int count = cartService.countCart(cartVo.getProductNo(), userId);
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
		System.out.println(session.getAttribute("authUser"));
		
		Object obj = session.getAttribute("authUser");
		
		UserVo vo = (UserVo) obj;
		String userId = vo.getUser_id();
		
		Map<String, Object> map = new HashMap<String, Object>();

		List<CartVo> list = cartService.cartList(userId);
		int sumMoney = cartService.sumMoney(userId);

		int fee = sumMoney >= 100000 ? 0 : 2500;

		map.put("list", list);
		map.put("count", list.size());
		map.put("sumMoney", sumMoney);
		map.put("fee", fee);
		map.put("allSum", sumMoney + fee);

		model.addAttribute("map", map);

		log.info(list);

		return "cart/cartList";
	}

	@RequestMapping(value = "/cartUpdate", method = RequestMethod.POST)
	public String CartUpdate(@RequestParam int[] amount, @RequestParam int[] productNo, HttpSession session) {

		Object obj = session.getAttribute("authUser");
		
		UserVo vo = (UserVo) obj;
		String userId = vo.getUser_id();
		
		// 레코드의 갯수 만큼 반복문 실행
		for (int i = 0; i < productNo.length; i++) {
			CartVo cartVo = new CartVo();
			cartVo.setUserId(userId); 
			cartVo.setProductAmount(amount[i]); 
			cartVo.setProductNo(productNo[i]); 
			cartService.cartUpdate(cartVo); 
		}

		return "redirect:/cartList.do";
	}
}

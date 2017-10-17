package com.flowershop.buy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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

import com.flowershop.buy.domain.BuyVo;
import com.flowershop.buy.service.BuyService;
import com.flowershop.buy.service.impl.BuyServiceImpl;
import com.flowershop.cart.controller.CartController;
import com.flowershop.cart.domain.CartVo;
import com.flowershop.cart.service.CartService;
import com.flowershop.login.domain.UserVo;

@Controller
public class BuyController {
	
	private Log log = LogFactory.getLog(BuyController.class);
	
	@Autowired
	private BuyService buyService;
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/buyAll")
	public String  buyAll(HttpServletRequest request, Model model)throws Exception{
		
		String user_id = request.getParameter("user_id"); 
		Map<String, Object> map = new HashMap<String, Object>();
		List<CartVo> list = cartService.cartList(user_id);
		
		int sumMoney = Integer.parseInt(request.getParameter("sumMoney")); 
		int fee = sumMoney >= 50000 ? 0 : 2500;
	
		map.put("list", list);
		map.put("count", list.size());
		map.put("sumMoney", sumMoney);
		map.put("fee", fee);
		map.put("allSum", sumMoney + fee);
		map.put("user_id", user_id);
		
		model.addAttribute("map", map);
		return "buy/buyForm";
	}
	
	@RequestMapping("/payment")
	public String payMent(HttpServletRequest request, BuyVo buyVo)throws Exception{
		String totalCartNo = request.getParameter("totalCartNo");
		String[] cartNo = totalCartNo.split(",");  
		List<CartVo> list = buyService.cartList(cartNo);
		buyService.buyInsert(buyVo);
		
		
		return "";
	}
}

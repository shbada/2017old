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
import com.flowershop.product.domain.ProductVo;
import com.flowershop.product.domain.SaleVo;
import com.flowershop.product.service.ProductService;

@Controller
public class CartController {

	private Log log = LogFactory.getLog(CartController.class);

	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
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
		
		int OriginalMoney = 0; //세일x
		int saleSumMoney = 0;//세일o
		
		for (CartVo cartVo : list) { //list: 장바구니 목록을 list형식으로 담았음, 이 list를 cartVo에 반복문으로 담아서 ,
			if(cartVo.getProduct_saleyn().equals("Y")){ //세일상품이면?
				ProductVo productVo = new ProductVo();
				productVo.setProduct_no(cartVo.getProduct_no()); //상품 번호를 productVo에 담고,
 				SaleVo saleVo = productService.selectSaleInfo(productVo); //담은 번호를 파라미터로 보내서 세일상품의 가격을 조회해와서,
 				cartVo.setSale_price(saleVo.getSale_price()); //조회된 세일가격을 cartVo에 담음
 				saleSumMoney += cartVo.getSale_price() * cartVo.getProduct_amount();
			}
			
			if(cartVo.getProduct_saleyn().equals("N")){
				OriginalMoney += cartVo.getProduct_price() * cartVo.getProduct_amount();
			}
		}
		
		int sumMoney = saleSumMoney + OriginalMoney;
		int fee = sumMoney >= 50000 ? 0 : 2500;
		
		map.put("list", list);
		map.put("count", list.size());
		map.put("sumMoney", sumMoney);
		map.put("fee", fee);
		map.put("allSum", sumMoney + fee);
		map.put("user_id", user_id);

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

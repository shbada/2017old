package com.flowershop.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
	
	//상품 목록 
	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public String productList() {
		
		return "product/productList";
	}
	
	//상품 상세화면1
	@RequestMapping(value = "/flower1", method = RequestMethod.GET)
	public String flower1() {
		
		return "product/flower1";
	}
	@RequestMapping(value = "/flower2", method = RequestMethod.GET)
	public String flower2() {
		
		return "product/flower2";
	}
	@RequestMapping(value = "/flower3", method = RequestMethod.GET)
	public String flower3() {
		
		return "product/flower3";
	}
	@RequestMapping(value = "/flower4", method = RequestMethod.GET)
	public String flower4() {
		
		return "product/flower4";
	}
	@RequestMapping(value = "/flower5", method = RequestMethod.GET)
	public String flower5() {
		
		return "product/flower5";
	}
	@RequestMapping(value = "/flower6", method = RequestMethod.GET)
	public String flower6() {
		
		return "product/flower6";
	}
	@RequestMapping(value = "/flower7", method = RequestMethod.GET)
	public String flower7() {
		
		return "product/flower7";
	}
	@RequestMapping(value = "/flower8", method = RequestMethod.GET)
	public String flower8() {
		
		return "product/flower8";
	}
	@RequestMapping(value = "/flower9", method = RequestMethod.GET)
	public String flower9() {
		
		return "product/flower9";
	}
	
	
	//바로 구매 작성
	@RequestMapping("/buyForm")
	public String buyForm() {
		
		return "buy/buyForm";
	}
	
}

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
	
	@RequestMapping("/buy")
	public String  buy(HttpSession session, HttpServletRequest request, Model model)throws Exception{
		if(session.getAttribute("authUser") == null) {
			model.addAttribute("msg", "로그인 후 사용 가능합니다.");
			model.addAttribute("url", "login");
			return"board/alert"; 
		}
		String buyChoice = request.getParameter("buyChoice");				// 구매종류 선택시 필요!! 
		
		String user_id = request.getParameter("user_id"); 
		int sumMoney = Integer.parseInt(request.getParameter("sumMoney")); 
		int fee = sumMoney >= 50000 ? 0 : 2500;
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<CartVo> list = null;
		
		if(buyChoice.trim().equals("buyAll")) {								// 전체구매시!!!
			list = cartService.cartList(user_id);
		} else {															// 선택 구매시!!!
			String totalCartNo = request.getParameter("totalCartNo");      // 결제할 cart_no 를 가지고 있는 문자열  콤마로(,) 구분돼 있다.
			String[] cartNo = totalCartNo.split(",");						// split() 메소드를 이용해서 문자열 자르기
			list = buyService.getCartList(cartNo);
			System.out.println("buyPart");
		}
		System.out.println("list2 : " + list);
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
		buyService.buyInsert(buyVo);									// buy table에 insert (배송정보등등...)
		
		int getBuy_no  = buyService.getBuy_no(buyVo.getUser_id());		// buyinfo table 에 buy_no를 넣어주기 위해서 buy_no를 가져온다.
		String totalCartNo = request.getParameter("totalCartNo");      // 결제할 cart_no 를 가지고 있는 문자열  콤마로(,) 구분돼 있다.
		String[] cartNo = totalCartNo.split(",");						// split() 메소드를 이용해서 문자열 자르기
		
		for(int i=0; i<cartNo.length; i++) {
			System.out.println("cartNo["+ i +"] : " + cartNo[i]);
		}
		buyService.cartList(cartNo, getBuy_no);									// 결제할 카트 번호와 저장된 구매번호 를 가져가서 3가지 일을 해준다 (1. 카트 번호로 해당정보 select, 
//																												 2. 해당 정보로 buy_info 에 insert
//																												 3. 결제한 목록 장바구니에서 삭제하기)
		return "redirect:/cartList";
	}
	
	@RequestMapping("/purchaseHistory")
	public String PurchaseHistory(HttpSession session, Model model) {
		if(session.getAttribute("authUser") == null) {
			model.addAttribute("msg", "로그인 후 사용 가능합니다.");
			model.addAttribute("url", "login");
			return"board/alert"; 
		}
		
		
		
		return "buy/purchaseHistory";
	}
	
	
}







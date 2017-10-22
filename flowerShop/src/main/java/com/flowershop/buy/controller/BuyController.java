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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flowershop.buy.domain.BuyVo;
import com.flowershop.buy.service.BuyService;
import com.flowershop.cart.domain.CartVo;
import com.flowershop.cart.service.CartService;
import com.flowershop.login.domain.UserVo;
import com.flowershop.point.domain.PointVo;
import com.flowershop.point.service.impl.PointServiceImpl;

@Controller
public class BuyController {

	private Log log = LogFactory.getLog(BuyController.class);

	public static final float rate = 0.05f;
	
	@Autowired
	private BuyService buyService;

	@Autowired
	private PointServiceImpl pointService;
	
	@Autowired
	private CartService cartService;

	@RequestMapping("/buy")
	public String  buy(HttpSession session, HttpServletRequest request, Model model)throws Exception{
		if(session.getAttribute("authUser") == null) {
			model.addAttribute("msg", "로그인 후 사용 가능합니다.");
			model.addAttribute("url", "login");
			return "board/alert";
		}
		String buyChoice = request.getParameter("buyChoice");				// 구매종류 선택시 필요!! 
		String user_id = request.getParameter("user_id"); 
		String totalCartNo = request.getParameter("totalCartNo");      // 콤마(,) 를 구분자로해서 cart_no를 가지고 있다.  
		String[] cartNo = totalCartNo.split(",");						// split() 메소드를 이용해서 문자열 자르기
		int sumMoney = 0;  
		Map<String, Object> map = new HashMap<String, Object>();
		List<CartVo> list = null;
		
		if(buyChoice.trim().equals("buyAll")) {								// 전체구매시!!!
			list = buyService.getCartList(cartNo);
			for(int i=0; i<list.size(); i++) {								// 구매시 세일상품&일반상품을 합산하는 과정
				if(list.get(i).getProduct_saleyn().equals("Y")) {
					list.get(i).setSale_price(buyService.getSalePrice(list.get(i).getProduct_no()));
					sumMoney += list.get(i).getSale_price() * list.get(i).getProduct_amount();
				} else {
					sumMoney += list.get(i).getProduct_price() * list.get(i).getProduct_amount();
				}
			}
		} else {															// 선택 구매시!!!
			list = buyService.getCartList(cartNo);
			for(int i=0; i<list.size(); i++) {								//  구매시 세일상품&일반상품을 합산하는 과정
				if(list.get(i).getProduct_saleyn().equals("Y")) {
					list.get(i).setSale_price(buyService.getSalePrice(list.get(i).getProduct_no()));
					sumMoney += list.get(i).getSale_price() * list.get(i).getProduct_amount();
				} else {
					sumMoney += list.get(i).getProduct_price() * list.get(i).getProduct_amount();
				}
			}
		}
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
	
	@RequestMapping(value="/payment")
	public String payMent(HttpServletRequest request, BuyVo buyVo,HttpSession session,PointVo pointVo) throws Exception {
		buyService.buyInsert(buyVo); // buy table에 insert (배송정보등등...)
		
		int getBuy_no = buyService.getBuy_no(buyVo.getUser_id()); // buyinfo table에 buy_no를 넣어주기 위해서 buy_no를 가져온다.
		String totalCartNo = request.getParameter("totalCartNo"); // 결제할 cart_no 를 가지고 있는 문자열을 받는다.  
		String[] cartNo = totalCartNo.split(","); // split() 메소드를 이용해서 문자열 자르기
		buyService.cartList(cartNo, getBuy_no);									// 결제할 카트 번호와 저장된 구매번호 를 가져가서 3가지 일을 해준다 (1. 카트 번호로 해당정보 select, 
//																												 2. 해당 정보로 buy_info 에 insert
//																												 3. 결제한 목록 장바구니에서 삭제하기)
		UserVo userVo = (UserVo)session.getAttribute("authUser");
		int userPoint = pointService.getPoint(userVo.getUser_id());
		int buyTotalPrice = Integer.parseInt(request.getParameter("buy_totalPrice"));
		int usedPoint = Integer.parseInt(request.getParameter("point"));
		int buy_addPoint = (int)(buyTotalPrice * rate);
		if(usedPoint > 0){
			//포인트를 사용 할 경우
			pointVo.setPoint_yn("Y");
			pointVo.setPoint(usedPoint);
			userVo.setUser_point(userPoint - usedPoint + buy_addPoint);
			buyTotalPrice = buyTotalPrice - usedPoint;
			buyVo.setBuy_no(getBuy_no);
			pointService.updatePoint(userVo);
		} else {
			//포인트를 사용하지 않을 경우
			buyVo.setBuy_no(getBuy_no);
			pointVo.setPoint_yn("N");
			userVo.setUser_point(userPoint + buy_addPoint);
			pointService.updatePoint(userVo);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("buyVo", buyVo);
		map.put("pointVo", pointVo);
		map.put("userVo", userVo);
		pointService.recordPoint(map);

		return "redirect:/cartList";
	}

	@RequestMapping("/purchaseHistory")
	public String PurchaseHistory(HttpSession session, Model model) {
		if (session.getAttribute("authUser") == null) {
			model.addAttribute("msg", "로그인 후 사용 가능합니다.");
			model.addAttribute("url", "login");
			return "board/alert";
		}

		return "buy/purchaseHistory";
	}
   
	@RequestMapping("/buyDeliveryCheck")
	@ResponseBody
	public Object buyDeliveryCheck(HttpSession session) throws Exception {
		UserVo userVo = (UserVo) session.getAttribute("authUser");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", userVo);
		return map;
	}

}

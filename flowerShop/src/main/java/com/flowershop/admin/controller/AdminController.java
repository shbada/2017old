package com.flowershop.admin.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.flowershop.admin.domain.RequestVo;
import com.flowershop.admin.service.AdminService;
import com.flowershop.cart.domain.CartVo;
import com.flowershop.login.domain.UserVo;

@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService; //서비스 객체 자동 주입
	
	//전체 회원 관리
	@RequestMapping("/allMemberList")
	public String allMemberList(Model model) throws Exception {
		List<UserVo> list = adminService.allMemberList();
		model.addAttribute("list", list);
		
		return "admin/allMemberList";
	}
	
	//고객 센터 문의 작성 화면
	@RequestMapping(value = "/customerCenter", method = RequestMethod.GET)
	public String customerCenter() {
		return "admin/customerCenter";
	}
	
	//고객센터 문의 처리
	@RequestMapping(value = "/requestCreate", method = RequestMethod.POST)
	public String requestCreate(@ModelAttribute RequestVo vo) throws Exception {						
		adminService.requestCreate(vo);
		return "redirect:/one_to_one";
	}
	
	//1:1문의 목록
	@RequestMapping("/one_to_one")
	public ModelAndView one_to_one() throws Exception {
		List<RequestVo> one_to_one = adminService.one_to_oneAll();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/one_to_one");
		mav.addObject("one_to_one", one_to_one);
		return mav;
	}
	
	//1:1문의 상세보기
	@RequestMapping(value = "/requestView", method = RequestMethod.GET)
	public ModelAndView requestView(@RequestParam int request_no, HttpSession session) throws Exception {		
		
		//데이터와 뷰를 한번에 처리하는 객체
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("admin/requestView");
		mav.addObject("dto", adminService.requestRead(request_no));
		return mav;
	}		
	
	//1:1문의 수정
	@RequestMapping(value = "/requestUpdate", method = RequestMethod.GET)
	public void requestUpdateGET(int request_no, Model model) throws Exception {
		model.addAttribute(adminService.requestRead(request_no));
	}	
	@RequestMapping(value = "/requestUpdate", method = RequestMethod.POST)
	public String requestUpdate(RequestVo vo, RedirectAttributes rttr) throws Exception {
		
		logger.info("mod post................");
		
		adminService.requestUpdate(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");		
		return "redirect:/one_to_one";
	}
	
	//1:1문의 삭제
	@RequestMapping("/requestDelete")
	public String requestDelete(@RequestParam int request_no, RedirectAttributes rttr) throws Exception {
		adminService.requestDelete(request_no);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/one_to_one";
	}
	@RequestMapping("/requestDelete2")
	public String requestDelete2(@RequestParam int user_no, RedirectAttributes rttr) throws Exception {
		adminService.requestDelete(user_no);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/allMemberList";
	}
	
	//관리자모드 회원 삭제
	@RequestMapping(value="/allListDelete", method=RequestMethod.POST, consumes="application/json")	 
	public void allListDelete(@RequestBody List<UserVo> data) throws Exception {
		adminService.allListDelete(data);
	}
	
}

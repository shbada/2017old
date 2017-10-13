package com.flowershop.admin.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flowershop.admin.service.AdminService;
import com.flowershop.login.domain.UserVo;

@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService; //서비스 객체 자동 주입

	@RequestMapping("/allMemberList")
	public String allMemberList(Model model) {
		List<UserVo> list = adminService.allMemberList();
		model.addAttribute("list", list);
		
		return "admin/allMemberList";
	}
	
	@RequestMapping("/customerCenter")
	public String customerCenter() {
		return "admin/customerCenter";
	}
}

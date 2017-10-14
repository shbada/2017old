package com.flowershop.main.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flowershop.login.domain.UserVo;
import com.flowershop.message.domain.MessageVo;
import com.flowershop.message.service.MessageService;

@Controller
public class MainController {

	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private MessageService messageService;

	// 이부분 수정해서 넣어봤어요!!
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainPage() {
		
		return "main/main";
	}
	
	@RequestMapping(value = "/top", method={RequestMethod.GET, RequestMethod.POST})
	public String mainTopPage(@ModelAttribute MessageVo messageVo, HttpSession session, Model model) {
		
		UserVo userVo = (UserVo)session.getAttribute("authUser");
		String user_id = userVo.getUser_id();
		
		int messageCount = messageService.messageNewCount(user_id);
		System.out.println(messageCount);
		
		model.addAttribute("messageCount", messageCount);
		return "main/top";
	}
}

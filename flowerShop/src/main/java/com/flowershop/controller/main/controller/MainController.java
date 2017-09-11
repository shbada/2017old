package com.flowershop.controller.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	// 이부분 수정해서 넣어봤어요!! 
	@RequestMapping("/main")
	public String mainPage(){
		return "main/main";
	}
}

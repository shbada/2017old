package com.flowershop.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flowershop.HomeController;

@Controller
public class MainController {

	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	// 이부분 수정해서 넣어봤어요!!
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainPage() {

		return "main/main";
	}
}

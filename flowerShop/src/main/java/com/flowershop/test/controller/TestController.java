package com.flowershop.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flowershop.test.domain.CustomVO;
import com.flowershop.test.service.TestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	private String writeFrom() throws Exception{
		return "search";
	}
	
	@RequestMapping(value = "/writeOK", method = RequestMethod.POST)
	private String writeInBoard(CustomVO vo) throws Exception {
//		TestBoardService.insert(vo);
		return "redirect:list";
	}
	
	
	
}

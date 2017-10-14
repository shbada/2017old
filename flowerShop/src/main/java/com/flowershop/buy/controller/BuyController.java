package com.flowershop.buy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.flowershop.buy.service.impl.BuyServiceImpl;

@Controller
public class BuyController {
	
	@Autowired
	BuyServiceImpl buyService;
	
}

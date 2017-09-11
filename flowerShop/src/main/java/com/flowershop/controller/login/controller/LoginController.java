package com.flowershop.controller.login.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.flowershop.controller.login.service.LoginService;

@Controller
public class LoginController {
	
	private Log log = LogFactory.getLog(LoginController.class);

	@Autowired
	private LoginService loginService;
}

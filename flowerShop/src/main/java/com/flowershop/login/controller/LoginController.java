package com.flowershop.login.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.flowershop.login.domain.UserVo;
import com.flowershop.login.service.LoginService;

@RequestMapping("/login")
@Controller
public class LoginController {
	
	

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/loginform")
	public String loginform(){
		return "login/loginform";
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public ModelAndView login(UserVo userVo) throws Exception{
		
		loginService.login(userVo);
		
		ModelAndView model = new ModelAndView("index");
		model.addObject("user", userVo);
		return model;
	}

	
}

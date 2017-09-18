package com.flowershop.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flowershop.login.service.impl.LoginServiceImpl;

@RequestMapping("/login")
@Controller
public class LoginController {
   
   @Autowired
   LoginServiceImpl loginService;
   
   @RequestMapping("/loginform")
   public String loginform(){
      return "login/loginform";
   }
   
}
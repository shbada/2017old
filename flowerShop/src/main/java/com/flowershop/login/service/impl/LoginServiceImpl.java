package com.flowershop.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowershop.login.repository.impl.LoginDaoImpl;
import com.flowershop.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

   @Autowired
   LoginDaoImpl loginDao;
   

}
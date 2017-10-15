package com.flowershop.buy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowershop.buy.repository.impl.BuyDaoImpl;
import com.flowershop.buy.service.BuyService;

@Service
public class BuyServiceImpl implements BuyService{
	
	@Autowired
	BuyDaoImpl buyDao;
	
	
}

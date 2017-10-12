package com.flowershop.message.controller;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.flowershop.message.service.MessageService;

@Controller
public class MessageController {

	private Log log = LogFactory.getLog(MessageController.class);

	@Autowired
	private MessageService messageService;

}

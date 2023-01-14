package com.flowershop.message.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flowershop.login.domain.UserVo;
import com.flowershop.message.domain.MessageVo;
import com.flowershop.message.service.MessageService;

@Controller
public class MessageController {

	private Log log = LogFactory.getLog(MessageController.class);

	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value="/messageList", method={RequestMethod.GET, RequestMethod.POST})
	public String MessageList(@ModelAttribute MessageVo messageVo, Model model, HttpSession session) {
		
		UserVo userVo = (UserVo)session.getAttribute("authUser");
		messageVo.setUser_id(userVo.getUser_id());
		
		Map<String, Object> map = messageService.messageList(messageVo); 
		
		model.addAttribute("list", map.get("list"));
		return "message/messageList";
	}
	
	@RequestMapping(value="/messageSendList", method={RequestMethod.GET, RequestMethod.POST})
	public String MessageSendList(@ModelAttribute MessageVo messageVo, Model model, HttpSession session) {
		
		UserVo userVo = (UserVo)session.getAttribute("authUser");
		messageVo.setUser_id(userVo.getUser_id());
		System.out.println(messageVo.getUser_id());
		
		Map<String, Object> map = messageService.MessageSendList(messageVo); 
		
		model.addAttribute("list", map.get("list"));
		return "message/messageSendList";
	}
	
	@RequestMapping(value="/messageWrite", method={RequestMethod.GET, RequestMethod.POST})
	public String MessageWrite() {
		return "message/messageWrite";
	}
	
	@RequestMapping(value="/messageSendWrite", method=RequestMethod.POST)
	public String MessageSendWrite(@ModelAttribute("MessageVo") MessageVo messageVo, Model model) {
		System.out.println(messageVo);
		model.addAttribute("sender", messageVo.getMsg_send());
		return "message/messageSendWrite";
	}
	
	@RequestMapping(value="/messageWriteSave", method=RequestMethod.POST)
	@ResponseBody
	public String MessageWriteSave(@ModelAttribute MessageVo messageVo, HttpSession session) {
		UserVo userVo = (UserVo)session.getAttribute("authUser");
		messageVo.setUser_id(userVo.getUser_id());
		
		String idCheck = messageVo.getMsg_get();
		int count = messageService.MessageIdCheck(idCheck);
		
		if(count == 0){
			return "fal";
		}
	
		messageService.MessageWriteSave(messageVo);
		
		return "ok";
	}
	
	@RequestMapping(value="/messageSendWriteSave", method=RequestMethod.POST)
	@ResponseBody
	public String MessageSendWriteSave(@ModelAttribute MessageVo messageVo, HttpSession session) {
		UserVo userVo = (UserVo)session.getAttribute("authUser");
		messageVo.setUser_id(userVo.getUser_id());
		messageService.MessageWriteSave(messageVo);
		
		return "ok";
	}
	
	@RequestMapping(value="/messageSendDelete", method=RequestMethod.POST)
	public String MessageDelete(@ModelAttribute MessageVo messageVo) {
		messageService.MessageSendDelete(messageVo);
		return "redirect:/messageSendList";
	}
	
	@RequestMapping(value="/messageGetDelete", method=RequestMethod.POST)
	public String MessageGetDelete(@ModelAttribute MessageVo messageVo) {
		messageService.MessageGetDelete(messageVo);
		return "redirect:/messageList";
	}
	
	@RequestMapping(value="/messageGetListDel", method=RequestMethod.POST, consumes="application/json")	 
	public void MessageGetListDel(@RequestBody List<MessageVo> data) {
		messageService.messageGetListDel(data);
	}
	
	@RequestMapping(value="/messageSendListDel", method=RequestMethod.POST, consumes="application/json")	 
	public void MessageSendListDel(@RequestBody List<MessageVo> data) {
		System.out.println(data);
		messageService.messageSendListDel(data);
	}
	
	@RequestMapping(value="/messageDetail", method=RequestMethod.POST)
	public String MessageDetail(@ModelAttribute("MessageVo") MessageVo messageVo, Model model, HttpSession session){
		MessageVo list = messageService.messageDetail(messageVo); 
		if(list.getMsg_readyn().equals("N")){
			messageService.messageReadYn(messageVo);
		}
		model.addAttribute("MessageVo", list);
		return "message/messageDetail";
	}
	
	@RequestMapping(value="/messageSendDetail", method=RequestMethod.POST)
	public String MessageSendDetail(@ModelAttribute("MessageVo") MessageVo messageVo, Model model, HttpSession session){
		MessageVo list = messageService.messageDetail(messageVo); 

		model.addAttribute("MessageVo", list);
		return "message/messageSendDetail";
	}

}

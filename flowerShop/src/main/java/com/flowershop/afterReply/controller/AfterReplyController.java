package com.flowershop.afterReply.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flowershop.afterReply.domain.AfterReplyVo;
import com.flowershop.afterReply.service.AfterReplyService;

@Controller
public class AfterReplyController {
	
	private Log log = LogFactory.getLog(AfterReplyController.class);

	@Autowired
	private AfterReplyService afterReplyService;
	
	@RequestMapping("/afterReplyList")
	public String AfterReplyList(HttpSession session, Model model){
        
        /*Map<String, Object> map = new HashMap<String, Object>();
        
        List<AfterReplyVo> list = afterReplyService.afterReplyList(productNo);

        map.put("list", list);                
        map.put("count", list.size());       
        
        model.addAttribute("map", map); 
        
        log.info(list);*/
		
		return "afterReply/afterReplyList";
	}
	
	@RequestMapping("/afterReplyWrite")
	public String AfterReplyWrite(HttpSession session, Model model){
		return "afterReply/afterReplyWrite";
	}
	
	@RequestMapping(value="/afterReplyWriteSave", method=RequestMethod.POST)
	public String AfterReplyWriteSave(@ModelAttribute("AfterReplyVo") AfterReplyVo afterReplyVo, Model model, HttpServletResponse response, HttpServletRequest request) throws Exception{
		
		/*HttpSession session = request.getSession(false);

		afterReplyVo.setUserId((String) session.getAttribute("userId")); // 현재 로그인한 아이디를 작성자 아이디에 저장
		afterReplyVo.setUserName((String) session.getAttribute("userNm")); // 현재 로그인한 이름을 작성자 이름에 저장
		afterReplyService.afterReplyWriteSave(afterReplyVo); // 새로 쓴 글을 sql에 저장.
*/		
		return "afterReply/afterReplyList";
	}
}

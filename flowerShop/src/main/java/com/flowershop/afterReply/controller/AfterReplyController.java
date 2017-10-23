package com.flowershop.afterReply.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flowershop.afterReply.domain.AfterReplyVo;
import com.flowershop.afterReply.service.AfterReplyService;
import com.flowershop.login.domain.UserVo;

@Controller
public class AfterReplyController {
	
	private Log log = LogFactory.getLog(AfterReplyController.class);

	@Autowired
	private AfterReplyService afterReplyService;
	
	@RequestMapping(value="/afterReplyWrite", method=RequestMethod.POST)
	@ResponseBody
	public String AfterReplyWrite(@ModelAttribute AfterReplyVo afterReplyVo, HttpSession session){
		
		if (session.getAttribute("authUser") == null){
    		return "fal";
    	}
		
		UserVo userVo = (UserVo)session.getAttribute("authUser");
		afterReplyVo.setUser_id(userVo.getUser_id());
		
		System.out.println(afterReplyVo);
		
		afterReplyService.afterReplyWrite(afterReplyVo);
		
		return "ok";
	} 
	
	@RequestMapping(value="/afterReplyList", method=RequestMethod.POST)
	public String AfterReplyList(@ModelAttribute AfterReplyVo afterReplyVo, Model model, HttpSession session){
		
		int totalCount = afterReplyService.afterReplyCount(afterReplyVo);
		
		if(afterReplyVo.getPageCnt() == null) afterReplyVo.setPageSize(5);
		else afterReplyVo.setPageSize(Integer.parseInt(afterReplyVo.getPageCnt()));
		
		afterReplyVo.setTotalCount(totalCount);
		
		model.addAttribute("pageVO", afterReplyVo);
		model.addAttribute("product_no", afterReplyVo);
		
		List<AfterReplyVo> replyList = afterReplyService.afterReplyList(afterReplyVo, session);

		model.addAttribute("replyList", replyList);
		
		if (session.getAttribute("authUser") != null){
			UserVo userVo = (UserVo)session.getAttribute("authUser");
			String user_id = userVo.getUser_id();
			
			model.addAttribute("userVo", userVo);
			model.addAttribute("sessionUser_id", user_id);
    	}
		
		return "product/replyList";
	}

	
	@RequestMapping(value="/AfterReplyDelete", method=RequestMethod.PATCH)
	@ResponseBody
	public ResponseEntity<String> QreplyOneDelete(@RequestParam int after_no){ 
		
		ResponseEntity<String> entity = null; 
		
		try{
			afterReplyService.AfterReplyDelete(after_no); 
			entity = new ResponseEntity<String>("ok", HttpStatus.OK); 
		} catch (Exception e){ // 에러처리
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST); //에러 발생시 
		}
		return entity; 
	}
	
	@RequestMapping(value="/AfterReplyUpdate", method=RequestMethod.PUT)
	@ResponseBody
	public String QreplyOneUpdate(@RequestParam int after_no, @RequestParam String after_content){ 
		
		AfterReplyVo afterReplyVo = new AfterReplyVo(); 
		
		System.out.println(after_no);
		System.out.println(after_content);
		/** .jsp에서 입력된 수정할 데이터들을 Vo에 담아온다. */
		afterReplyVo.setAfter_no(after_no);
		afterReplyVo.setAfter_content(after_content);
		
		afterReplyService.AfterReplyUpdate(afterReplyVo); 
		
		return "ok";
	}
}

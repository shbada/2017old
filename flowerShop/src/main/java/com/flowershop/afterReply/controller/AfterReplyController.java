package com.flowershop.afterReply.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public String AfterReplyList(@ModelAttribute AfterReplyVo afterReplyVo, HttpSession session, Model model){
        
        Map<String, Object> map = new HashMap<String, Object>();
        
        List<AfterReplyVo> list = afterReplyService.afterReplyList(afterReplyVo);

        map.put("list", list);                
        map.put("count", list.size());       
        
        model.addAttribute("map", map); 
        
        log.info(list);
		
		return "afterReply/afterReplyList";
	}
	
	@RequestMapping("/afterReplyWrite")
	public String AfterReplyWrite(HttpSession session, Model model){
		return "afterReply/afterReplyWrite";
	}
	
	/** 후기댓글 작성 */
	@RequestMapping(value="/afterReplyWriteSave", method=RequestMethod.POST)
	public String AfterReplyWriteSave(@ModelAttribute("AfterReplyVo") AfterReplyVo afterReplyVo, Model model, HttpServletResponse response, HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession(false);

		afterReplyVo.setUserId((String) session.getAttribute("userId"));
		afterReplyVo.setUserName((String) session.getAttribute("userNm")); 
		afterReplyService.afterReplyWriteSave(afterReplyVo);
		
		return "afterReply/afterReplyList";
	}
	
	/** 후기댓글 수정 */
	//수정페이지
	@RequestMapping(value="/afterReplyUpdate", method=RequestMethod.POST)
	public String QUpdateView(@ModelAttribute AfterReplyVo afterReplyVo, Model model){
		AfterReplyVo list = afterReplyService.afterReplyUpdate(afterReplyVo); 
		model.addAttribute("afterReplyVo", list);
		/*model.addAttribute("pageVO", afterReplyVo);*/
		return "afterReply/afterReplyUpdate";
	}
	
	//수정완료
	@RequestMapping(value="/afterReplyUpdateSave", method=RequestMethod.POST)
	public String QUpdate(@ModelAttribute("AfterReplyVo") AfterReplyVo afterReplyVo, Model model, HttpServletResponse response, HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession(false);

		afterReplyVo.setUserId((String) session.getAttribute("userId")); 
		afterReplyVo.setUserName((String) session.getAttribute("userName")); 
		afterReplyService.afterReplyUpdateSave(afterReplyVo); 
		/*model.addAttribute("pageVO", afterReplyVo);
*/		
		return "afterReply/afterReplyList";
	}
	
	/** 후기댓글 삭제 */
	@RequestMapping(value="/afterReplyDelete", method=RequestMethod.POST)
	public String QDelete(@ModelAttribute AfterReplyVo afterReplyVo) throws IOException{
		/** FK로 이어져있는 테이블은 차례대로 삭제해준다. */
		afterReplyService.afterReplyDelete(afterReplyVo);
		
		return "afterReply/afterReplyList";
	}
}

package com.flowershop.like.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flowershop.like.service.LikeService;
import com.flowershop.login.domain.UserVo;

public class LikeController {
	
	/*private Log log = LogFactory.getLog(LikeController.class);

	@Autowired
	private LikeService likeService;

	@RequestMapping(value="/likeSelect", method=RequestMethod.GET)
	@ResponseBody
	public int LikeSelect(@RequestParam int productNo) {
		int resultCnt = likeService.LikeSelect(productNo); //추천수 가져옴
		return resultCnt;
	}
	
	@RequestMapping(value="/likeUpSave", method=RequestMethod.POST)
	@ResponseBody
	public String LikeUpSave(@ModelAttribute ProductVo productVo, HttpSession session) throws IOException{
		
		Object obj = session.getAttribute("authUser");
		
		ProductVo productVo = (ProductVo) obj;
		String userId = productVo.getUser_id();
		
		ProductVo productLike= likeService.LikeUpSelect(productVo);
		if(productLike == null){
			likeService.likeUpSave(productVo); 
			return "ok";
		}
		else return "fal";
	}*/
}

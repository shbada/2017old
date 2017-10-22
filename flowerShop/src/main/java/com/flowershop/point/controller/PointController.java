package com.flowershop.point.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flowershop.login.domain.UserVo;
import com.flowershop.point.service.impl.PointServiceImpl;

@Controller
public class PointController {

	@Autowired
	private PointServiceImpl pointService;

	@RequestMapping(value = "/getpoint", method = RequestMethod.POST)
	@ResponseBody
	public Object getPoint(HttpSession session) throws Exception {
		UserVo userVo = (UserVo) session.getAttribute("authUser");
		int point = pointService.getPoint(userVo.getUser_id());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", point);
		return map;
	}

}

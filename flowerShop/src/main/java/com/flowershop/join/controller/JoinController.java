package com.flowershop.join.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.flowershop.join.service.impl.JoinServiceImpl;
import com.flowershop.login.domain.UserVo;
import com.flowershop.util.JSONResult;

@Controller
@RequestMapping("/join")
public class JoinController {

	private static final Logger log = LoggerFactory.getLogger(JoinController.class);

	@Autowired
	JoinServiceImpl joinService;

	@RequestMapping("")
	public String joinForm() throws Exception {
		return "join/joinform";
	}

	@RequestMapping("/postPup")
	public String postPup() throws Exception {
		return "join/jusoPopup";
	}

	@RequestMapping(value = "/checkid", method = RequestMethod.POST)
	@ResponseBody
	public JSONResult checkId(String user_id) throws Exception {
		boolean result = joinService.checkId(user_id);
		return JSONResult.success(result ? "true" : "false");
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView join(@ModelAttribute @Valid UserVo user, BindingResult result) throws Exception {

		ModelAndView view = new ModelAndView();
		joinService.join(user);
	
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError e : list) {
				log.debug(e.getDefaultMessage());
			}
			view.setView(new RedirectView("/main"));
			return view;
		}
		view.setViewName("join/joinsuccess");
		return view;
	}

}

package com.flowershop.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flowershop.login.domain.UserVo;
import com.flowershop.login.service.impl.LoginServiceImpl;

@Controller
public class LoginController {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	LoginServiceImpl loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET(@ModelAttribute("vo") UserVo userVo) throws Exception {
		return "login/login";
	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public String loginPOST(UserVo userVo, HttpSession session, Model model) throws Exception {
		UserVo vo = loginService.login(userVo);
		// boolean result =passwordEncoder.matches(userVo.getUser_pw(),
		// vo.getUser_pw());
		if (vo == null) {
			String msg = "올바른 아이디와 비밀번호를 입력해주세요";
			model.addAttribute("msg", msg);
			return "login/login";
		} else if (vo != null && passwordEncoder.matches(userVo.getUser_pw(), vo.getUser_pw()) == true) {
			model.addAttribute("userVo", vo);
		} else if (passwordEncoder.matches(userVo.getUser_pw(), vo.getUser_pw()) == false) {
			String msg = "올바른 아이디와 비밀번호를 입력해주세요";
			model.addAttribute("msg", msg);
		}
		return "login/login";
	}

	// @RequestMapping(value="/logout", method=RequestMethod.GET)
	// public String logout(HttpServletRequest request, HttpServletResponse
	// response, HttpSession session)throws Exception{
	//
	// Object obj = session.getAttribute("login");
	// if(obj != null){
	// UserVo vo = (UserVo)obj;
	// session.removeAttribute("login");
	// session.invalidate();
	//
	// Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
	// if(loginCookie != null){
	// loginCookie.setPath("/main");
	// loginCookie.setMaxAge(0);
	// response.addCookie(loginCookie);
	// loginService.keepLogin(vo.getUser_id(), session.getId(), new Date());
	// }
	// }
	//
	// return "main/main";
	// }

	@RequestMapping(value = "/kakaologin", produces = "application/json", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String kakaoLogin(@RequestParam("code") String code, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("code : : : :" + code);

		return "main/main";
	}

}
package com.flowershop.login.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

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
	public String loginPOST(@ModelAttribute("vn") UserVo userVo, HttpSession session, Model model,
			HttpServletResponse response) throws Exception {

		UserVo vo = loginService.login(userVo.getUser_id());

		if ((vo == null) || (vo != null && (passwordEncoder.matches(userVo.getUser_pw(), vo.getUser_pw()) == false))) {
			String msg = "아이디와 비밀번호가 올바르지 않습니다.";
			model.addAttribute("msg", msg);
			return "login/login";

		} else if (vo != null && (passwordEncoder.matches(userVo.getUser_pw(), vo.getUser_pw()) == true)) {
			model.addAttribute("userVo", vo);
			if (userVo.isUseCookie()) {
				int amount = 60 * 60 * 24 * 7;
				Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));
				loginService.keepLogin(vo.getUser_id(), session.getId(), sessionLimit);
			}
		}
		return "login/login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {

		Object obj = session.getAttribute("authUser");
		if (obj != null) {
			UserVo vo = (UserVo) obj;
			session.removeAttribute("authUser");
			session.invalidate();
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			if (loginCookie != null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				loginService.keepLogin(vo.getUser_id(), session.getId(), new Date());
			}
		}
		return "main/main";
	}

	@RequestMapping("/myInfo")
	public String infoForm() throws Exception {
		return "login/infoForm";
	}

	@RequestMapping(value = "/myInfo", method = RequestMethod.POST)
	@ResponseBody
	public Object myInfo(String user_id, Model model, HttpSession session) throws Exception {
		UserVo userVo = loginService.myInfo(user_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("data", userVo);

		return map;
	}

	@RequestMapping(value = "/changeInfo", method = RequestMethod.POST)
	public String changeInfo(UserVo userVo) throws Exception {
		loginService.changeInfo(userVo);
		return "main/main";
	}

	@RequestMapping("/changepwform")
	public String changePasswordForm() throws Exception {
		return "login/changepw";
	}

	@RequestMapping(value = "/changepw", method = RequestMethod.POST)

	public String changePassword(String user_pw, String user_id) throws Exception {
		loginService.changePw(user_id, user_pw);
		return "main/main";
	}

	@RequestMapping("/mailFormId")
	public String mailFormId() {
		return "login/mailFormId";
	}

	@RequestMapping(value = "/mailSendingId", method = RequestMethod.POST)
	public String mailSendingId(String user_email, Model model, HttpServletResponse response) throws Exception {
		UserVo userVo = loginService.mailSending(user_email);
		if (userVo == null) {
			String msg = "올바른 이메일을 입력해주세요.";
			model.addAttribute("msg", msg);
			return "login/mailFormId";
		}
		return "login/mailSending";
	}

	@RequestMapping("/mailFormPw")
	public String mailFormPw() {
		return "login/mailFormPw";
	}

	@RequestMapping(value = "/mailSendingPw", method = RequestMethod.POST)
	public String mailSendingPw(String user_id, String user_email, Model model) throws Exception {
		 UserVo userVo = loginService.mailSendingPw(user_id, user_email);
		
		if(userVo == null){
			String msg = "올바른 아이디와 이메일을 입력해주세요";
			model.addAttribute("msg", msg);
			return "login/mailFormPw";
		}

		return "login/mailSending";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminGET() throws Exception {
		return "login/admin";
	}

	@RequestMapping(value = "/adminPost", method = RequestMethod.POST)
	public String admin() {
		return "main/main";
	}

}
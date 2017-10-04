package com.flowershop.login.service.impl;

import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.flowershop.login.domain.UserVo;
import com.flowershop.login.repository.impl.LoginDaoImpl;
import com.flowershop.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	boolean result;	
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	LoginDaoImpl loginDao;

	@Autowired
	JavaMailSender mailSender;

	@Override
	public UserVo login(String user_id) throws Exception {
		return loginDao.login(user_id);
	}

	@Override
	public void keepLogin(String user_id, String sessionId, Date next) throws Exception {
		loginDao.keepLogin(user_id, sessionId, next);
	}

	@Override
	public UserVo checkLoginBefore(String value) {
		return loginDao.checkUserWithSessionKey(value);
	}

	@Override
	public UserVo myInfo(String user_id) throws Exception {
		return loginDao.myInfo(user_id);
	}

	@Override
	public void changeInfo(UserVo userVo) throws Exception {
		loginDao.changeInfo(userVo);
	}

	@Override
	public void changePw(String user_id, String user_pw) throws Exception {
		String pw = passwordEncoder.encode(user_pw);

		loginDao.changePw(pw, user_id);
	}

	@Override
	public boolean mailSending(String email) throws Exception {	

		String user_id = loginDao.findUserId(email).getUser_id();
		if (user_id != null) {
			String setfrom = "ghkd7426@gmail.com";
			String tomail = email;
			String title = "FlowerShop 계정 사용자 ID"; 
			String content = "고객님의 아이디는 " + user_id + " 입니다.";
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom(setfrom);
				messageHelper.setTo(tomail);
				messageHelper.setSubject(title);
				messageHelper.setText(content);
				mailSender.send(message);
				result = true;
			} catch (Exception e) {
				System.out.println(e);
			}
		}else{
			result = false;
		}
		return result;	
	}
	
}
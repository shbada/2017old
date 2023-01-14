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
	public UserVo mailSending(String user_email) throws Exception {
		UserVo user_id = loginDao.findUserId(user_email);
		
		if (user_id != null) {
			String setfrom = "ghkd7426@gmail.com";
			String tomail = user_email;
			String title = "FlowerShop 계정 사용자 ID";
			String content = "고객님의 아이디는 " + user_id.getUser_id() + " 입니다.";
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
		}
		return loginDao.findUserId(user_email);
	}

	@Override
	public UserVo mailSendingPw(String user_id, String user_email) throws Exception {
		String user_pw = getRamdomPassword(8);
		UserVo userVo = loginDao.findUserPw(user_id, user_email);
		loginDao.userPwInit(user_id, passwordEncoder.encode(user_pw));
		if (userVo != null) {
			String setfrom = "hwanggyeongjin369@gmail.com";
			String tomail = user_email;
			String title = "FlowerShop 계정 사용자 ID";
			String content = "고객님의 비밀번호가 " + user_pw + " 로 초기화 되었습니다.\n 로그인 후 비밀번호를 변경해주세요";
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
		}
		return userVo;
	}

	public String getRamdomPassword(int len) {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		int idx = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len; i++) {
			idx = (int) (charSet.length * Math.random());
			sb.append(charSet[idx]);
		}
		return sb.toString();
	}

}
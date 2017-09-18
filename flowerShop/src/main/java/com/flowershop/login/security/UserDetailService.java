package com.flowershop.login.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flowershop.login.domain.UserVo;
import com.flowershop.login.repository.LoginDao;
import com.flowershop.login.repository.impl.LoginDaoImpl;

@Service
public class UserDetailService implements UserDetailsService {

	UserVo userVo;

	@Autowired
	private LoginDaoImpl loginDao;

	@Override
	public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
		try {
			userVo = new UserVo(loginDao.login(user_id));
			
			if (userVo == null) {
				throw new UsernameNotFoundException("다음 유저이름을 찾을 수 없습니다 : " + user_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		UserVo user = createUser(userVo);
		
		System.out.println("리턴 user: " + user);
		
		return user;
	}

	private UserVo createUser(UserVo userVo) {
		UserVo loginUser = new UserVo(userVo);

		System.out.println("loginUser : " + loginUser);
		
		if (loginUser.getIsadmin().equals("Y")) {
			loginUser.setRoles(Arrays.asList("ROLE_ADMIN"));
		} else {
			loginUser.setRoles(Arrays.asList("ROLE_USER"));
		}
		return loginUser;
	}

}

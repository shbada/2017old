package com.flowershop.join.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.flowershop.login.domain.UserVo;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return (UserVo.class.isAssignableFrom(clazz));
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserVo user = (UserVo)target;
				
	}

}

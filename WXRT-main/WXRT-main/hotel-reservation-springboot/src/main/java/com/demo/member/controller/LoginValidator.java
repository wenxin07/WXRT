package com.demo.member.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.demo.member.entity.Member;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "帳號欄不能為空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "密碼欄不能為空白");
	}

}

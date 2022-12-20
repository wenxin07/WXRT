package com.demo.member.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.demo.member.entity.Member;

public class SignUpValidator {

	// @Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	// @Override
	public void validate(Object target, Errors errors) {
		Member mb = (Member) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "電子郵件欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "密碼欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "checkpassword", "", "確認密碼欄不能空白");

//		if (! mb.getEmail().matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")) {
//		errors.rejectValue("email","", "帳號欄必須為電子郵件格式，須包含英文或數字及特殊字元");
//		}
//	
//		if (! mb.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&+=])(?=\\S+$).{6,}$")) {
//		errors.rejectValue("password","", "密碼至少6個字元，且須包含英數及特殊字元");
//		}

//		"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$"

		if (!mb.getCheckpassword().equals(mb.getCheckpassword())) {
			errors.rejectValue("checkpassword", "", "密碼欄與確認密碼不一致");
		}
	}

}

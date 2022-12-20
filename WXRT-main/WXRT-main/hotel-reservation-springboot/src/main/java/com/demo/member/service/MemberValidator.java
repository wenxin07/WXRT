package com.demo.member.service;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.demo.member.entity.Member;

public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Member mb = (Member) target;
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", 		"", "姓氏不能空白");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", 		"", "名字不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "電子郵件欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "密碼欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "checkpassword", "", "確認密碼欄不能空白");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", 		"", "電話欄不能空白");
//		ValidationUtils.rejectIfEmpty(errors, "memberMultipartFile", "", "必須挑選圖片");
		if (!mb.getEmail().matches("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$")) {
			System.out.println(123);
			errors.rejectValue("email", "", "電子郵件欄格式不正確");
		}

		if (!mb.getPassword().equals(mb.getCheckpassword())) {
			errors.rejectValue("checkpassword", "", "密碼欄與確認密碼欄不一致");
		}

//		String emailMatcher="^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
//		Pattern.matches(emailMatcher,ent.getEmail());

	}

}

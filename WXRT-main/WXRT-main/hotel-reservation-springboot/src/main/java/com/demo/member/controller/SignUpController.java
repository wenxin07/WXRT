package com.demo.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.member.entity.Member;
import com.demo.member.service.MemberService;

@Controller
public class SignUpController {

	@Autowired
	private MemberService MemberService;

	// 註冊

	@GetMapping("/member/signup")
	public String sendingEmptyForm(Model model) {
		Member member = new Member();
		Member member2 = new Member();
//		member.setPassword("member!123");
//		member.setCheckpassword("member!123");
//		member.setEmail("wxrt1118@gmail.com");
		model.addAttribute("signup_member", member);
		model.addAttribute("login_member", member2);
		return "jsp/member/signup";
	}

	@PostMapping("/member/signup")
	public String signUp(@ModelAttribute("signup_member") Member member1, 
			@ModelAttribute("login_member") Member member2,
			BindingResult result,
			Model model,
			HttpServletRequest request) {
		SignUpValidator validator = new SignUpValidator();
		validator.validate(member1, result);
		if (result.hasErrors()) {
//			System.out.println("----------------");
//			System.out.println("error發生");
//			System.out.println("----------------");
			return "jsp/member/signup";
		}

		// 檢查帳號email是否重複
		if (MemberService.findByEmail(member1.getEmail()) != null) {
			result.rejectValue("email", "", "帳號已存在，請重新輸入");

			return "jsp/member/signup";
		}

		model.addAttribute("email", member1.getEmail());
		model.addAttribute("password", member1.getPassword());
		model.addAttribute("checkpassword", member1.getCheckpassword());

		MemberService.addMember(member1);

		return "jsp/member/signupsuccess";
	}

}
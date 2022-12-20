package com.demo.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.demo.member.entity.Member;
import com.demo.member.service.MemberService;

@Controller
@SessionAttributes({ "LoginOK", "servletPath" })
public class LoginController {

	@Autowired
	private MemberService MemberService;

	// 登入
	@GetMapping("/member/login")
	public String loginPage(HttpServletRequest request, Model model,
			@CookieValue(value = "email", defaultValue = "") String email,
			@CookieValue(value = "password", defaultValue = "") String password) {
//		if (password.length() > 0) {
//			password = WebService.decryptString(GlobalService.KEY, password);
//		}

		Member member = new Member();
		Member member2 = new Member();
		model.addAttribute("login_member", member);
		model.addAttribute("signup_member", member2);
		return "jsp/member/login";
	}

	@PostMapping("/member/login")
	public String login(@RequestParam String email, @RequestParam String password,
			@ModelAttribute("login_member") Member member, BindingResult result, Model model, HttpSession session) {

		LoginValidator validator = new LoginValidator();
		validator.validate(member, result);
		if (result.hasErrors()) {

			System.out.println("-----------------------------------------------------");
			System.out.println("錯誤發生");
			return "jsp/member/login";
		}

		Member loginMember = MemberService.findByEmailAndPassword(member.getEmail(), member.getPassword());
		if (loginMember == null) {

			result.rejectValue("email", "", "該帳號不存在或密碼錯誤");
			result.rejectValue("password", "", "該帳號不存在或密碼錯誤");

			return "redirect:/member/signup";
		}

		// 設置Session
		session.setAttribute("LoginOK", loginMember);

		return "jsp/member/loginsuccess";
	}

//		
//	}
//	//刪除會員帳號
//	@GetMapping("/member/delete/{id}")
//	public String deleteMember(@PathVariable("id") Long id , Model model) {
//		
//		MemberService.deleteMemberById(id);
//		return "index";
//
//	}

}

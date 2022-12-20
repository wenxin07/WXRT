package com.demo.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.demo.member.entity.Member;

@Controller
@SessionAttributes({ "LoginOK" })
public class LogoutController {
	@GetMapping("/member/logout")
	public String logout(HttpSession session, SessionStatus status, Model model) {

		if (session.getAttribute("LoginOK") != null) {
			// 登出時執行下列兩敘述
			session.removeAttribute("LoginOK");
			status.setComplete(); // 移除@SessionAttributes({"LoginOK"}) 標示的屬性物件
			session.invalidate(); // 此敘述不能省略
			// String farewellMessage = "您已成功登出";
			// redirectAtt.addFlashAttribute("FlashMSG_farewell", farewellMessage);
			return "jsp/member/logoutsuccess"; // 跳轉回http://localhost:8080/Context_Path/
		} else {
			Member member = new Member();
			Member member2 = new Member();
			model.addAttribute("login_member", member);
			model.addAttribute("signup_member", member2);
			return "jsp/member/login";
		}

	}
}

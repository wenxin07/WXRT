package com.demo.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.demo.member.entity.Member;
import com.demo.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService MemberService;

	// 編輯會員資料

	@GetMapping("/member/memberprofile")
	public String editMmeberPage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		Member loginMember = (Member) session.getAttribute("LoginOK");
		
		if (loginMember != null) {
			model.addAttribute("member", loginMember);
			return "jsp/member/memberprofile";
		} else {
			session.removeAttribute("email");
			session.removeAttribute("password");
			return "redirect:/member/login";
		}

	}

	@PostMapping("/member/memberprofile/{id}")
	public String editMmeber(@PathVariable("id") Long id, HttpServletRequest request,
			@ModelAttribute("member") Member member, Model model) {

		HttpSession session = request.getSession();
		// 更新member
		session.setAttribute("LoginOK", member);

		// 檢查member id是否有取得
		// System.out.println("id:" + member.getId());

		if (member != null) {
			System.out.println("更新成功");
			MemberService.addMember(member);
			return "jsp/member/editsuccess";

		} else {
			return "jsp/member/memberprofile";
		}
	}

//		model.addAttribute("firstname", member.getfirstname());
//		model.addAttribute("lastname", member.getlastname());
//		model.addAttribute("birth", member.getBirth());
//		model.addAttribute("phone", member.getPhone());
//		model.addAttribute("email", member.getEmail());
//		model.addAttribute("password", member.getPassword());

//	//刪除會員帳號
//	@GetMapping("/member/deletemember/{id}")
//	public String deleteMember(@PathVariable("id") Long id , Model model) {
//		
//		MemberService.deleteMemberById(id);
//		return "/index";

}

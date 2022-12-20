package com.demo.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	
	@GetMapping("/dashboard")
	public String getDashBoardPage() {
		return "dashboard/dashboard";
	}
	
	@GetMapping("/manage_reservation")
	public String getManageMemberPage() {
		return "dashboard/manage_reservation";
	}
	
	
}

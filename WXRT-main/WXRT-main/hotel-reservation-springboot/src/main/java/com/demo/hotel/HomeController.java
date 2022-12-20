package com.demo.hotel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String getHomePage() {
		return "jsp/index";
	}

	@GetMapping("/index")
	public String getHomePage2() {
		return "jsp/index";
	}

	@GetMapping("/about")
	public String getAboutPage() {
		return "jsp/about";
	}

	@GetMapping("/contact")
	public String getContactPage() {
		return "jsp/contact";
	}

	@GetMapping("/reservation/index")
	public String getSearchPage() {
		return "hotel/search";
	}

	@GetMapping("/test")
	public String test() {
		return "/hotel/test";
	}
}

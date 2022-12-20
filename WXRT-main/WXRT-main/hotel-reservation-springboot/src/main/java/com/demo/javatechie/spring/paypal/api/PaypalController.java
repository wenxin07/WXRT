package com.demo.javatechie.spring.paypal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@Controller
public class PaypalController {

	@Autowired
	PaypalService service;

	public static final String SUCCESS_URL = "/success";
	public static final String CANCEL_URL = "/cancel";
//
//	@GetMapping("/")
//	public String home() {
//		return "home";
//	}

	@PostMapping("/pay")
	public String payment(@ModelAttribute("order") Order order) {
		try {

			System.out.println(order.getPrice());
			System.out.println(order.getCurrency());
			System.out.println(order.getMethod());
			System.out.println(order.getIntent());
			System.out.println(order.getIntent());

			Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
					order.getIntent(), order.getDescription(), "http://localhost:8080" + CANCEL_URL,
					"http://localhost:8080" + SUCCESS_URL);
			for (Links link : payment.getLinks()) {
				if (link.getRel().equals("approval_url")) {
					return "redirect:" + link.getHref();
				}
			}

		} catch (PayPalRESTException e) {

			e.printStackTrace();
		}
		return "redirect:/";
	}

	@GetMapping(value = CANCEL_URL)
	public String cancelPay() {
		return "cancel";
	}

	@GetMapping(value = SUCCESS_URL)
	public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
		try {
			Payment payment = service.executePayment(paymentId, payerId);
			System.out.println(payment.toJSON());
			if (payment.getState().equals("approved")) {
				System.out.println("-----------------------------------");
				System.out.println("成功付款");

				return "payment_result/success";
			}
		} catch (PayPalRESTException e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/";
	}

}

package com.example.demo.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ForgotController {

	//email id form open handler..
	@GetMapping("/forgot")
	public String openEmailForm() {
		
		return"forgot_email_form";
	}
	
	@PostMapping("/send-otp")
	public String sendOTP(@RequestParam("email") String email) {
		
		System.out.println("EMAIL->>> "+ email);
		
		//generating otp of 4 digit
		
		Random random = new Random();
		
		int otp = random.nextInt(999999);
		
		System.out.println("OTP->>>"+ otp);
		
		return"verify_otp";
	}
}

package com.example.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.helper.Message;
import com.example.demo.service.EmailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ForgotController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	// open form
	@GetMapping("/forgot")
	public String openForgotPage(Model model, HttpSession session) {

	    Object message = session.getAttribute("message");
	    if (message != null) {
	        model.addAttribute("message", message);
	        session.removeAttribute("message"); // ✅ remove here
	    }

	    return "forgot_email_form";
	}
	
	// send otp
	@PostMapping("/send-otp")
	public String sendOTP(@RequestParam("email") String email, HttpSession session) {

	    Random random = new Random();
	    int otp = 100000 + random.nextInt(900000);

	    String subject = "OTP From SCM";
	    String message = "<h1>OTP = " + otp + "</h1>";
	    String to = email;

	    boolean flag = this.emailService.sendEmail(to,subject, message);

	    if (flag) {
	        session.setAttribute("myotp", otp);
	        session.setAttribute("email", email);
	        return "verify-otp";
	    } else {
	        session.setAttribute("message", "❌ Invalid Email or Email not sent!");
	        return "redirect:/forgot";
	    }
	}
	
	
	@PostMapping("/verify-otp")
	public String verifyotp(@RequestParam("otp") int otp, HttpSession session, RedirectAttributes redirectAttributes) {
		
		int myotp = (int)session.getAttribute("myotp");
		String email = (String)session.getAttribute("email");
		
		if(myotp == otp) {
			//password change form
			User user = this.userRepository.getUserByEmail(email);
			
			if(user == null) {
				//send error message
				redirectAttributes.addFlashAttribute("message",
			            new Message("User does not exits this email !!", "danger"));
				
				return"redirect:/forgot";
				
			} else {
				//send change password form
				return"password_change_form";
			}
			 
			
		} else {
			
			 redirectAttributes.addFlashAttribute("message", new
					 	Message("You have entered wrong otp", "danger")); 
			 return "redirect:/forgot";
			
		}
	}
	
	@PostMapping("/change-password")
	public String changePassword(@RequestParam("newpassword") String newpassword,
	                             HttpSession session,
	                             RedirectAttributes redirectAttributes) {

	    String email = (String) session.getAttribute("email");

	    if (email == null) {
	        redirectAttributes.addFlashAttribute("message",
	                new Message("Session expired. Please try again.", "danger"));
	        return "redirect:/forgot";
	    }

	    User user = this.userRepository.getUserByEmail(email);

	    if (user == null) {
	        redirectAttributes.addFlashAttribute("message",
	                new Message("User not found!", "danger"));
	        return "redirect:/forgot";
	    }

	    user.setPassword(this.bcryptPasswordEncoder.encode(newpassword));
	    this.userRepository.save(user);

	    session.removeAttribute("email");

	    redirectAttributes.addFlashAttribute("message",
	            new Message("Password changed successfully!", "success"));

	    return "redirect:/signin";
	}}
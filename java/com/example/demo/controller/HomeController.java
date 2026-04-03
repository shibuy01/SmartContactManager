package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("title","Home - Smart Contact Manager");
		System.out.println("this is home controller");
		return "home";
	}
	
	@GetMapping("/about")
	public String about(Model m) {
		m.addAttribute("title","About - Smart Contact Manager");
		System.out.println("this is about controller");
		return "about";
	}
	
	@GetMapping("/signup")
	public String signup(Model m, HttpSession session) {
		m.addAttribute("title","Signup - Smart Contact Manager");
		 m.addAttribute("user", new User());
		 m.addAttribute("session", session);
		System.out.println("this is signup controller");
		return "signup";
	}
	
	
	@PostMapping("/do_register")
	public String registerUser(@Valid  @ModelAttribute User user,BindingResult result ,
	                           @RequestParam(defaultValue="false") boolean agreement,
	                          RedirectAttributes redirectAttributes,Model m) {

	    try {
	        if (!agreement) {
	            redirectAttributes.addFlashAttribute("message",
	                    new Message("You have not agreed the terms and condition", "alert-danger"));
	            return "redirect:/signup";
	        }
	        
	        if(result.hasErrors()) {
	        	System.out.println("ERROR"+ result.toString());
	        	m.addAttribute("user",user);
	        	return"signup";
	        }

	        user.setRole("USER");
	        user.setEnabled(true);
	        user.setImageUrl("../image/profile.png");
	        user.setPassword(passwordEncoder.encode(user.getPassword()));

	        this.userRepository.save(user);

	        redirectAttributes.addFlashAttribute("message",
	                new Message("Successfully Registered", "alert-success"));
	        
	        

	        return "redirect:/signup";

	    } catch (Exception e) {
	        e.printStackTrace();

	        redirectAttributes.addFlashAttribute("message",
	                new Message("Something went wrong !! " + e.getMessage(), "alert-danger"));

	        return "redirect:/signup";
	    }
	}
	
	@GetMapping("/signin")
	public String login(Model m) {
		m.addAttribute("title","Login - Smart Contact Manager");
		System.out.println("this is Login controller");
		return "login";
	}	
}

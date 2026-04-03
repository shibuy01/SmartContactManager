package com.example.demo.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.ContactRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.Contact;
import com.example.demo.entity.User;
import com.example.demo.helper.Message;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
    
    @Autowired
    public UserRepository userRepository;
    
    @Autowired
    private ContactRepository contactRepository;
    
    @ModelAttribute
    public void addCommonData(Model m, Principal principal) {
        String userName = principal.getName();
        User user = this.userRepository.getUserByEmail(userName);
        m.addAttribute("user", user);
    }

    @GetMapping("/index")
    public String dashboard(Model m , Principal principal) {
        return "normal/user_dashboard";
    }
    
    @GetMapping("/add-contact")
    public String addContact(Model m) {
        m.addAttribute("title","Add Contact - Smart Contact Manager");
        m.addAttribute("contact", new Contact());
        return "normal/add_contact_form";
    }
    
    @PostMapping("/process-contact")
    public String processContact(
            @ModelAttribute Contact contact,
            @RequestParam("profileImage") MultipartFile file,
            Principal principal,
            RedirectAttributes redirectAttributes) {

        try {

            String userName = principal.getName();
            User user = this.userRepository.getUserByEmail(userName);

            if (!file.isEmpty()) {

                // ✅ unique file name
                String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

                // ✅ correct path
                String uploadDir = "src/main/resources/static/image/";

                // directory create (important)
                File dir = new File(uploadDir);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                // file save
                Path path = Paths.get(uploadDir + fileName);
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                // save in DB
                contact.setImage(fileName);

            } else {
                contact.setImage("default.png");
            }

            contact.setUser(user);
            user.getContacts().add(contact);

            this.userRepository.save(user);

            redirectAttributes.addFlashAttribute("message",
                    new Message("Successfully added contact!", "success"));

        } catch (Exception e) {
            e.printStackTrace();

            redirectAttributes.addFlashAttribute("message",
                    new Message("Something went wrong!", "danger"));
        }

        return "redirect:/user/add-contact";
    }
    
    @GetMapping("/show-contact/{page}")
    public String showContact(@PathVariable("page") Integer page, Model m, Principal principal) {

        m.addAttribute("title","Show Contact - Smart Contact Manager");

        String userName = principal.getName();
        User user = this.userRepository.getUserByEmail(userName);

        if (user == null) {
            return "redirect:/signin";
        }

        Pageable pageable = PageRequest.of(page , 5);

        Page<Contact> contacts = this.contactRepository.findContactsByUser(user.getId(), pageable);

        m.addAttribute("contacts", contacts);
        m.addAttribute("currentPage", page);
        m.addAttribute("totalPage", contacts.getTotalPages());

        return "normal/show_contact";
    }
    
    @GetMapping("/contact/{cId}")
    public String showContactDetail(@PathVariable("cId") Integer cId,Model m, Principal principal) {
    	
    	m.addAttribute("title", "Show Contact Details - Smart Contact Manager");
    	
    	Optional<Contact> contactOptional = this.contactRepository.findById(cId);
    	Contact contact = contactOptional.get();
    	
    	String userName = principal.getName();
    	User user = this.userRepository.getUserByEmail(userName);
    	
    	if(user.getId() == contact.getUser().getId()) {
    		m.addAttribute("contact", contact);
    	}
    	
    	return"normal/contact_detail";
    }
    
    @GetMapping("/delete/{cId}")
    public String deleteContact(@PathVariable("cId") Integer cId , HttpSession session) {
    	
    	Optional<Contact> contactOptional = this.contactRepository.findById(cId);
    	Contact contact = contactOptional.get();
    	
    	contact.setUser(null);
    	
    	this.contactRepository.delete(contact);
    	session.setAttribute("Contact deleted successfully...", "success");
    	
    	return "redirect:/user/show-contact/0";
    }
    
    @PostMapping("/update-contact/{cId}")
    public String updateContact(@PathVariable("cId") Integer cId, Model m) {
    	
    	m.addAttribute("title", "Update Contact Details - Smart Contact Manager");
    	
    	Contact contact = this.contactRepository.findById(cId).get();
    	
    	m.addAttribute("contact",contact);
    	
    	return"normal/update_form";
    }
    
    @PostMapping("/process-update")
    public String updateHandler(@ModelAttribute Contact contact,
                                @RequestParam("profileImage") MultipartFile file,
                                Model m,
                                HttpSession session,
                                Principal principal) {

        try {

            Contact oldContact = this.contactRepository.findById(contact.getcId()).get();

           
            oldContact.setName(contact.getName());
            oldContact.setSecondName(contact.getSecondName());
            oldContact.setEmail(contact.getEmail());
            oldContact.setPhone(contact.getPhone());
            oldContact.setWork(contact.getWork());
            oldContact.setDescription(contact.getDescription());

            if (!file.isEmpty()) {
                oldContact.setImage(file.getOriginalFilename());
            }

            User user = this.userRepository.getUserByEmail(principal.getName());
            oldContact.setUser(user);

            this.contactRepository.save(oldContact);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("ContactName " + contact.getName());
        System.out.println("ContactId " + contact.getcId());

        return "redirect:/user/show-contact";
    }
    
    @GetMapping("/profile")
    public String yourProfile() {
    	return"normal/profile";
    }
    
    @GetMapping("/settings")
    public String openSettings(Model m, HttpSession session) {
    	
    	m.addAttribute("title","Settings - Smart Contact Manager");
    	return"normal/settings";
    }
    
    
    
    @PostMapping("/change-password")
    public String changePassword(@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, Principal principal, HttpSession session,RedirectAttributes redirectAttributes) {
    	
    	System.out.println("oldPassword"+ oldPassword);
    	System.out.println("newPassword"+ newPassword);
    	
    	String userName = principal.getName();
    	User currentUser = this.userRepository.getUserByEmail(userName);
    	
    	System.out.println(currentUser);
    	
    	
    	if(this.bcryptPasswordEncoder.matches(oldPassword, currentUser.getPassword())) {
    		//change password..
    		
    		currentUser.setPassword(this.bcryptPasswordEncoder.encode(newPassword));
    		this.userRepository.save(currentUser);
    		
    		redirectAttributes.addFlashAttribute("message",
    	            new Message("Password changed successfully!", "success"));
    		
    		
    		
    		
    	} else {
    		//error..
    		
    		redirectAttributes.addFlashAttribute("message",
    	            new Message("Password changed successfully!", "success"));
    		
    		return"redirect:/user/settings";
    	}
    	
    	return"redirect:/user/settings";
    }
    
    
    @GetMapping("/login-fail")
    public String loginFail(RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("message",
                new Message("Invalid Username or Password", "danger"));

        return "redirect:/signin";
    }
    
    
    
    
    
    
    
}
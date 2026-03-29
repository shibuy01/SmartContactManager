package com.example.demo.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


@Controller
@RequestMapping("/user")
public class UserController {
    
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
    public String showContactDetail(@PathVariable("cId") Integer cId) {
    	
    	return"normal/contact_detail";
    }
}
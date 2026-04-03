package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean sendEmail(String to, String subject, String body) {

        try {

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

            helper.setTo(to);  
            helper.setSubject(subject);
            helper.setText(body, true); 

            helper.setFrom("shibukumarkumar3@gmail.com");  

            javaMailSender.send(mimeMessage);

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}
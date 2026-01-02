package com.TVKAssessmentBackend.Assessment_Backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail() {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("receiver@gmail.com");      // receiver
        message.setSubject("Spring Boot Email");
        message.setText("Hello! This email is sent using Spring Boot.");
        message.setFrom("Sakthiboopathi26@gamil.com");

        mailSender.send(message);
        System.out.println("Email sent successfully!");
    }
}

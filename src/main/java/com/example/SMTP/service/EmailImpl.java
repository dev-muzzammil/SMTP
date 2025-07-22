package com.example.SMTP.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.SMTP.dto.EmailDTO;
import com.example.SMTP.entity.Email;
import com.example.SMTP.repository.EmailRepo;

@Service

public class EmailImpl implements EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private EmailRepo emailRepo;
	
	
	
	@Override
	public void sendEmail(EmailDTO dto) {
		
		if (dto.getTo() == null || dto.getTo().length == 0) {
			throw new IllegalArgumentException("Recipient email cannot be empty");
		}
		
		try {
		// -> 1. Send the email
			SimpleMailMessage message = new SimpleMailMessage();
			
			message.setFrom("khanmuzzammil815@gmail.com");       // Sender's email
			message.setTo(dto.getTo());                          // Set recipient(s) — an array of emails
			message.setSubject(dto.getSubject());                // Email subject
			message.setText(dto.getBody());                      // Email body text

		
			mailSender.send(message);
		
		// 2. Save to database
		
			Email email = new Email();
			
			email.setRecipient(String.join(",", dto.getTo()));   // Join all emails into one string (e.g., "a@gmail.com,b@gmail.com")
			email.setSubject(dto.getSubject());
			email.setBody(dto.getBody());
			email.setSentAt(LocalDateTime.now());
		
			emailRepo.save(email);
		}
		catch (Exception e) {
			throw new RuntimeException("Failed to send email: " + e.getMessage());
		}
					
	}

	
	
}

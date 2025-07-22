package com.example.SMTP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SMTP.dto.EmailDTO;
import com.example.SMTP.service.EmailService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/email")

public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	
	@PostMapping
	public ResponseEntity<String> sendEmail(@Valid  @RequestBody EmailDTO dto) {
	    emailService.sendEmail(dto);
	    return ResponseEntity.ok("Email Sent Successfully!");
	}


}

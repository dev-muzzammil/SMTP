package com.example.SMTP.service;

import com.example.SMTP.dto.EmailDTO;

public interface EmailService {

	public void sendEmail(EmailDTO dto);
	
}

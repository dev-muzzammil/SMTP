package com.example.SMTP.scheduler;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.SMTP.dto.EmailDTO;
import com.example.SMTP.service.EmailService;

@Component	// -> ✅ Makes this class a Spring-managed bean

public class MyScheduler {
	
	
	@Autowired
	private EmailService emailService;
	

	// -> ✅ This method will run every 50 seconds
	@Scheduled(fixedRate = 5000) // -> MilliSecond
	
	public void sendScheduledEmail() {
		
		EmailDTO email = new EmailDTO();
		
		email.setTo(new String[] {
		    "syed8081hamza@gmail.com",
		    "qureshiarfiyan11@gmail.com",
		    "kmaaz5237@gmail.com",
		    "bilalmaqsood408@gmail.com"
		});
		email.setSubject("Stop talk the talk");
		email.setBody("My Brother's ,\r\n"
				+ "\r\n"
				+ "Let’s be real for a second — the way you’re living right now, you’re not going anywhere. You say you want to be a millionaire, but you’re not doing anything that even points in that direction.\r\n"
				+ "\r\n"
				+ "You’re lazy. You talk the talk all day, but when it comes to actually doing the work, you disappear. Big dreams don’t mean anything without action. And right now, all you’re doing is dreaming — not building, not grinding, not improving.\r\n"
				+ "\r\n"
				+ "If you keep living like this, nothing is going to change. You won’t be successful, you won’t make money, and you definitely won’t get to where you say you want to be. Harsh truth, but someone’s gotta say it.\r\n"
				+ "\r\n"
				+ "I’m not saying this to break you down — I’m saying it because I want you to wake up. You’ve got potential, but potential means nothing if it’s wasted. It’s time to stop playing and start moving.\r\n"
				+ "\r\n"
				+ "Get serious — or stop pretending you are.\r\n"
				+ "\r\n"
				+ "");
		
		emailService.sendEmail(email);
        
		System.out.println(LocalDateTime.now() + " " + "📨 Email sent by scheduler.");
	}
	
	
}

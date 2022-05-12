package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class serviceEmail {
	@Autowired
	private JavaMailSender mailSender ;
	public void sendEmail(String toEmail,
			String subject,
			String body)
	{
		SimpleMailMessage message =new SimpleMailMessage() ;
		message.setFrom("rached.bouyahi@esprit.tn");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);

		mailSender.send(message);
	
	}

}

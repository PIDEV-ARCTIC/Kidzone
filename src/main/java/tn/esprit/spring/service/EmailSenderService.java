package tn.esprit.spring.service;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailSenderService {
	@Autowired
	private JavaMailSender mailsender;
 
	public  EmailSenderService(JavaMailSender mailsender ){
		this.mailsender=mailsender;
	}
	public void  sendEmail(String toEmail,String subject, String body){
		Properties props = new Properties();
		props.put("mail.smtp.ssl.enable", "true");
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("arwa.esprit@esprit.tn");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailsender.send(message);
		
		System.out.println("mail sent syccessfully ...");
	}
}

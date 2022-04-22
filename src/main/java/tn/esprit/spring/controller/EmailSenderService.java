package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailSenderService {
@Autowired 
JavaMailSender mailSender ;
public void SendEmail(String toEmail,String subject , String Body) {
	SimpleMailMessage message = new SimpleMailMessage()	;
	message.setFrom("nourelhouda.fdhila@esprit.tn");
	message.setTo(toEmail);
	message.setText(Body);
	message.setSubject(subject);
	mailSender.send(message);
	System.out.print("Mail Send succesfully ...");
}



}

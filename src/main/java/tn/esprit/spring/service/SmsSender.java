package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.SmsRequest;
import tn.esprit.spring.Entity.TwilioSmsSender;

@Service
public interface SmsSender {
	void sendSms(SmsRequest smsRequest) ;
	 void SmsService( TwilioSmsSender smsSender);
	    // or maybe void sendSms(String phoneNumber, String message);
}

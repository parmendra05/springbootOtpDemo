package com.pack.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioService {
	
	private final static Logger log=LoggerFactory.getLogger(TwilioService.class);
	
	@Value("${app.twillio.accountSID}")
	String twilioSid;
	
	@Value("${app.twillio.authToken}")
	String twilioToken;

	public void sendOtp(String to, String from, String msg) {
		try {
			Twilio.init(twilioSid, twilioToken);
			Message message = Message.creator(new PhoneNumber(to), new PhoneNumber(from), msg).create();
			log.info("Twilio Message "+message);
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}

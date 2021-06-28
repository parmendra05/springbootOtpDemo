package com.pack.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pack.bean.LoginData;
import com.pack.entity.MyUsers;
import com.pack.service.MyService;
import com.pack.service.TwilioService;

@SpringBootTest
class MyControllerTest {
	
	@InjectMocks
	private MyController controller;

	@Autowired
	private MyService service;

	@Mock
	private TwilioService twilioService;

	
	
	@Test
	void emailVerifyTest() {
		
		//controller.emailVerify(loadLoginData());
		MyUsers user = service.findById(loadLoginData().getEmail());
		
		assertEquals("user@gmail.com",user.getEmail());
		
		
	}
	
	public LoginData loadLoginData() {
	 LoginData data=new LoginData();
	data.setEmail("user@gmail.com");
	data.setOtp(1234);
	return data;
	}
}

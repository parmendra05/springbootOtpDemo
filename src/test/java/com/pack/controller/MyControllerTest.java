package com.pack.controller;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.pack.service.MyService;
import com.pack.service.TwilioService;
@SpringBootTest
class MyControllerTest {
	
	@InjectMocks
	private MyController controller;

	@Mock
	private MyService service;

	@Mock
	private TwilioService twilioService;

	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}

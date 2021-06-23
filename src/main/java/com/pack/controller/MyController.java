package com.pack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pack.bean.LoginData;
import com.pack.entity.MyUsers;
import com.pack.service.MyService;

@Controller
public class MyController {
	@Autowired
	private MyService service;
	
	private final static Logger log=LoggerFactory.getLogger(MyController.class);
	private  static int otp;
	
	@RequestMapping("/")
	public String test() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("logindata", new LoginData());
		Integer newOtp=randomValue();
		otp=newOtp;
		log.info("OTP  : "+newOtp);
		return "login";
	}
	
	@PostMapping("/submit")
	public String submit(@ModelAttribute ("logindata") LoginData data){
		MyUsers user=service.findById(data.getEmail());
		if(user.getEmail().equals( data.getEmail()) && otp==data.getOtp() )return "loginSuccess";
		else return "error";
	}
	
	@RequestMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("myuser", new MyUsers());
		return "register";
	}
	
	@PostMapping("/save")
	public String saveData(@ModelAttribute ("myuser") MyUsers user){
		service.saveUser(user);
		return "registrationSuccess";
	}
	
	
	static int randomValue() {
		int b = (int)(Math.random()*(9999-1000+1)+1000);
		return b;
	}

}

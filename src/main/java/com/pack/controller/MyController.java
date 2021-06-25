package com.pack.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pack.bean.LoginData;
import com.pack.entity.MyUsers;
import com.pack.service.MyService;
import com.pack.service.TwilioService;

@Controller
public class MyController {
	@Autowired
	private MyService service;

	@Autowired
	private TwilioService twilioService;

	@Value("${app.twillio.from}")
	private String from;
	@Value("${app.twillio.to}")
	private String to;
	private String msg = "Springboot API OTP : ";

	private final static Logger log = LoggerFactory.getLogger(MyController.class);
	private static int otp;

	@RequestMapping("/")
	public String test() {
		return "index";
	}

	@RequestMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("logindata", new LoginData());

		return "login";
	}

	@PostMapping("/submit")
	public String emailVerify(@ModelAttribute("logindata") LoginData data) {

		MyUsers user = service.findById(data.getEmail());

		if (user.getEmail().equals(data.getEmail())) {

			Integer newOtp = randomValue();
			otp = newOtp;
			log.info("OTP  : " + newOtp);
			twilioService.sendOtp(to + user.getMobile(), from, msg + " " + newOtp);
			// twilioService.sendOtp("+917047273554", from, msg + " " + newOtp);

			return "otpValidation";
		}

		else
			return "error";
	}

	@PostMapping("/enterOtp")
	public String otpVerify(Model model, @ModelAttribute("logindata") LoginData data) {
		if (otp == data.getOtp()) {
			MyUsers user = service.findById(data.getEmail());
			if (user.getRole().equals("user")) {
				List<MyUsers> userlist = service.findOnlyUsers();
				model.addAttribute("users", userlist);
                return "usersList";
			} else if (user.getRole().equals("admin")) {
				List<MyUsers> userlist = service.findAllAdminUsers();
				model.addAttribute("users", userlist);
                return "usersList";

			} else {
				List<MyUsers> userlist = service.findAllUsers();

				model.addAttribute("users", userlist);

				return "usersList";
			}
			
		} else
			return "error";
	}

	@RequestMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("myuser", new MyUsers());
		return "register";
	}

	@PostMapping("/save")
	public String saveData(@ModelAttribute("myuser") MyUsers user) {
		service.saveUser(user);
		return "registrationSuccess";
	}

	/*
	 * @RequestMapping("/list")
	 * 
	 * public String listPage(Model model) { List<MyUsers> userlist =
	 * service.findOnlyUsers("user"); model.addAttribute("users", userlist);
	 * 
	 * return "usersList"; }
	 */

	static int randomValue() {
		int b = (int) (Math.random() * (9999 - 1000 + 1) + 1000);
		return b;
	}

}

package project.wintercom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping(value = "/user/login")
	public String loginPage() throws Exception {
		return "/user/login";
	}
	
	@GetMapping(value = "/user/signUp")
	public String signUppage() throws Exception {
		return "/user/signUp";
	}

}

package project.wintercom.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.wintercom.domain.UserVO;
import project.wintercom.service.UserService;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService uService;
	
	// 로그인 뷰 페이지
	@GetMapping(value = "/user/login")
	public String loginPage() throws Exception {
		return "/user/login";
	}
	
	// 로그인 처리
	@PostMapping(value = "/user/loginProc")
	public String loginProc(UserVO uvo, RedirectAttributes rttr, HttpSession session) throws Exception {
		int result = uService.loginProc(uvo);
		if(result == 1) {
			UserVO user = uService.searchUser(uvo);
			if(user.getMail_auth() != 1) {
				rttr.addFlashAttribute("user",user);
				return "redirect:/user/emailAuthFail";
			}
			session.setAttribute("userId", user.getId());
			logger.info("Login Success!");
			return "redirect:/main";
		} else {
			return "redirect:/user/login";
		}
	}
	
	// 회원가입 뷰 페이지
	@GetMapping(value = "/user/signUp")
	public String signUpPage() throws Exception {
		return "/user/signUp";
	}
	
	// 회원가입 처리
	@PostMapping(value = "/user/signUpProc")
	public String signUpProc(@Valid UserVO uvo, RedirectAttributes rttr) throws Exception {
		uService.registerUser(uvo);
		rttr.addFlashAttribute("userId",uvo.getId());
		logger.info("Sign Up Success!");
		return "redirect:/user/signUpSuccess";
	}
	
	// 중복아이디 체크
	@PostMapping(value = "/user/dupIdCk")
	@ResponseBody
	public int dupIdCk(UserVO uvo) throws Exception {
		int result = uService.dupIdCk(uvo);
		return result;
	}
	
	// 중복이메일 체크
	@PostMapping(value = "/user/dupEmailCk")
	@ResponseBody
	public int dupEmailCk(UserVO uvo) throws Exception {
		int result = uService.dupEmailCk(uvo);
		return result;
	}
	
	// 메일인증 확인
	@GetMapping(value = "/user/signUpEmail")
	public String emailConfirm(UserVO uvo, Model model) throws Exception {
		UserVO newUser = uService.searchUser(uvo);
		if(uvo.getMail_key().equals(newUser.getMail_key())) {
			uService.updateMailAuth(uvo);
			model.addAttribute("result",1);
		} else {
			model.addAttribute("result",0);
		}
		return "/user/emailAuthSuccess";
	}
	
	// 메일인증 실패
	@GetMapping(value = "/user/emailAuthFail")
	public String emailConfirmFail() throws Exception {
		return "/user/emailAuthFail";
	}
	
	// 메일 재전송
	@PostMapping(value = "/user/resend-mail")
	@ResponseBody
	public int resendMail(UserVO uvo) throws Exception {
		if(uvo != null) {
			uService.resendMail(uvo);
			logger.info("Re-Send Mail Success!");
			return 1;
		} else {
			logger.info("Re-Send Mail Fail.");
			return 0;
		}
	}
	
	// 회원가입 성공 뷰 페이지
	@GetMapping(value = "/user/signUpSuccess")
	public String signUpSuccessPage() throws Exception {
		return "/user/signUpSuccess";
	}

}

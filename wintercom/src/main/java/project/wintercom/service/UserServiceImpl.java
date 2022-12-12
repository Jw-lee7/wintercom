package project.wintercom.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import project.wintercom.domain.UserVO;
import project.wintercom.mail.TempKey;
import project.wintercom.mail.MailHandler;
import project.wintercom.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDAO udao;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// 회원등록
	@Override
	public void registerUser(UserVO uvo) throws Exception {
		String mail_key = new TempKey().getKey(30, false);
		
		uvo.setMail_key(mail_key);
		
		uvo.setPw(passwordEncoder.encode(uvo.getPw()));
		udao.registerUser(uvo);
		udao.updateMailKey(uvo);
		
		MailHandler sendMail = new MailHandler(mailSender);
		sendMail.setSubject("인증메일입니다.");
		sendMail.setText(
				"<h1>Wintercom 메일인증</h1>" +
				"<br>Wintercom 회원가입을 축하드립니다." +
				"<br><a href='http://localhost:8088/user/signUpEmail?email=" +
				uvo.getEmail() + "&mail_key=" + mail_key + "' target='_blank'>이메일 인증 확인</a>");
		sendMail.setFrom("finResLee@gmail.com","WINTERCOM");
		sendMail.setTo(uvo.getEmail());
		sendMail.send();
	}
	
	// 중복아이디 체크
	@Override
	public int dupIdCk(UserVO uvo) throws Exception {
		return udao.dupIdCk(uvo);
	}

	// 중복이메일 체크
	@Override
	public int dupEmailCk(UserVO uvo) throws Exception {
		return udao.dupEmailCk(uvo);
	}

	// 메일 재전송
	@Override
	public void resendMail(UserVO uvo) throws Exception {
		UserVO userInfo = udao.searchUser(uvo);
		String mail_key = new TempKey().getKey(30, false);
		
		userInfo.setMail_key(mail_key);
		udao.updateMailKey(userInfo);
		
		MailHandler sendMail = new MailHandler(mailSender);
		sendMail.setSubject("인증메일입니다.");
		sendMail.setText(
				"<h1>Wintercom 메일인증</h1>" +
				"<br>Wintercom 회원가입을 축하드립니다." +
				"<br><a href='http://localhost:8088/user/signUpEmail?email=" +
				userInfo.getEmail() + "&mail_key=" + mail_key + "' target='_blank'>이메일 인증 확인</a>");
		sendMail.setFrom("finResLee@gmail.com","WINTERCOM");
		sendMail.setTo(userInfo.getEmail());
		sendMail.send();
	}

	// 회원조회
	@Override
	public UserVO searchUser(UserVO uvo) throws Exception {
		return udao.searchUser(uvo);
	}

	// 메일인증키 생성
	@Override
	public int updateMailKey(UserVO uvo) throws Exception {
		return udao.updateMailKey(uvo);
	}

	// 메일인증 상태 변경
	@Override
	public int updateMailAuth(UserVO uvo) throws Exception {
		return udao.updateMailAuth(uvo);
	}

	// 이메일 인증 유/무 체크
	@Override
	public int emailAuthFail(String id) throws Exception {
		return udao.emailAuthFail(id);
	}

	// 로그인 처리
	@Override
	public int loginProc(UserVO uvo) throws Exception {
		if((uvo.getId() == null || uvo.getId() == "") || (uvo.getPw() == null || uvo.getPw() == "")) {
			logger.info("ID or PW Please input value.");
			return 0;
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		UserVO user = udao.searchUser(uvo);
		if(user != null) {
			if(encoder.matches(uvo.getPw(), user.getPw())) {
				return 1;
			}
		}		
		
		logger.info("ID or PW Check Please.");
		return 0;
	}

	
}

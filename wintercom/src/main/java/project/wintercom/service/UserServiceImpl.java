package project.wintercom.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.wintercom.domain.UserVO;
import project.wintercom.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDAO udao;
	
	// 회원등록
	@Override
	public void registerUser(UserVO uvo) throws Exception {
		udao.registerUser(uvo);		
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

	
}

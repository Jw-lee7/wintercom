package project.wintercom.service;

import project.wintercom.domain.UserVO;

public interface UserService {

	// 회원등록
	public void registerUser(UserVO uvo) throws Exception ;
	
	// 중복아이디 체크
	public int dupIdCk(UserVO uvo) throws Exception;
	
	// 중복이메일 체크
	public int dupEmailCk(UserVO uvo) throws Exception;
}

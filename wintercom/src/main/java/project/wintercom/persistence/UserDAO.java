package project.wintercom.persistence;

import project.wintercom.domain.UserVO;

public interface UserDAO {

	// 회원등록
	public void registerUser(UserVO uvo) throws Exception;
	
	// 회원조회
	public UserVO searchUser(UserVO uvo) throws Exception;
	
	// 중복아이디 체크
	public int dupIdCk(UserVO uvo) throws Exception;
	
	// 중복이메일 체크
	public int dupEmailCk(UserVO uvo) throws Exception;
	
	// 메일인증키 생성
	public int updateMailKey(UserVO uvo) throws Exception;
	
	// 메일인증 상태 변경
	public int updateMailAuth(UserVO uvo) throws Exception;
	
	// 이메일 인증 유/무 체크
	public int emailAuthFail(String id) throws Exception;
}

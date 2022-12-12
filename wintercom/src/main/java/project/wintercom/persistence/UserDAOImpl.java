package project.wintercom.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.wintercom.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private static final String namespace = "project.wintercom.mappers.userMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	// 회원등록
	@Override
	public void registerUser(UserVO uvo) throws Exception {
		sqlSession.insert(namespace + ".registerUser",uvo);
	}

	// 중복아이디 체크
	@Override
	public int dupIdCk(UserVO uvo) throws Exception {
		System.out.println(uvo.getId());
		return sqlSession.selectOne(namespace + ".dupIdCk",uvo);
	}

	// 중복이메일 체크
	@Override
	public int dupEmailCk(UserVO uvo) throws Exception {
		return sqlSession.selectOne(namespace + ".dupEmailCk",uvo);
	}

	// 회원조회
	@Override
	public UserVO searchUser(UserVO uvo) throws Exception {
		return sqlSession.selectOne(namespace + ".searchUser",uvo);
	}

	// 메일인증키 생성
	@Override
	public int updateMailKey(UserVO uvo) throws Exception {
		return sqlSession.update(namespace + ".updateMailKey",uvo);
	}

	// 메일인증 상태 변경
	@Override
	public int updateMailAuth(UserVO uvo) throws Exception {
		return sqlSession.update(namespace + ".updateMailAuth",uvo);
	}

	// 이메일 인증 유/무 체크
	@Override
	public int emailAuthFail(String id) throws Exception {
		return sqlSession.selectOne(namespace + ".emailAuthFail",id);
	}	
}

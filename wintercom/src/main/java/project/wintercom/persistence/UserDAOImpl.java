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
}

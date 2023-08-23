package org.spring.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.spring.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int idcheck(String id) {
		return this.sqlSession.selectOne("idcheck", id);
	}
	
	@Override
	public int emailcheck(String email) {
		return this.sqlSession.selectOne("emailcheck", email);
	}

	@Override
	public String admincheck(String id) {
		return null;
	}

	@Override
	public int join(UserDTO dto) {
		return this.sqlSession.insert("join", dto);
		
	}

	@Override
	public String pwdcheck(String id) {
		return this.sqlSession.selectOne("pwdcheck", id);
	}

	@Override
	public String email_search(String email) {
		return this.sqlSession.selectOne("emailsearch",email);
	}

	@Override
	public UserDTO userInfo(String id) {
		return this.sqlSession.selectOne("userinfo", id);
	}

	@Override
	public String pwd(String email) {
		return this.sqlSession.selectOne("pwd", email);
	}

	@Override
	public int userUpdate(UserDTO dto) {
		return this.sqlSession.update("userupdate", dto);
	}

	


}

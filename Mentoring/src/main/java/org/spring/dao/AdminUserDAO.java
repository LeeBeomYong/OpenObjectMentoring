package org.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.spring.dto.SearchCondition;
import org.spring.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminUserDAO {

	@Autowired
	private SqlSessionTemplate SqlSession;
	
	// 관리자로 사용자들 목록 불러오기
	public List<UserDTO> selectList(SearchCondition sc) {
		return this.SqlSession.selectList("userList", sc);
	}
	
	// 관리자로 사용자들 목록 불러올때 몇명인지 확인
	public int userListcount(SearchCondition sc) {
		return this.SqlSession.selectOne("userListcount", sc);
	}
	
	// 사용자 목록 dto에 반영
	public UserDTO admin_userInfo(int no) {
		return this.SqlSession.selectOne("admin_userInfo", no);
	}
	
	// 관리자로 사용자 삭제할 때
	public int userDelete(int no) {
		return this.SqlSession.delete("userDelete", no);
	}
	
	// 관리자가 유저 삭제할 때 user_num 하나씩 줄어들게
	public int userNumUpdate(int no) {
		return this.SqlSession.update("userNumUpdate", no);
	}
}

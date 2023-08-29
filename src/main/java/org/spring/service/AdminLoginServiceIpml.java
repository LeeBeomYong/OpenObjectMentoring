package org.spring.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spring.dao.AdminUserDAO;
import org.spring.dao.UserDAO;
import org.spring.dto.PageHandler;
import org.spring.dto.SearchCondition;
import org.spring.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminLoginServiceIpml implements AdminLoginService {
		
	@Autowired
	private AdminUserDAO auserDAO;
	@Autowired
	private UserDAO userDAO;
	
	//관리자로 유저 페이지 이동할 때 리스트 불러옴
	public Map<String, Object> user_list(SearchCondition sc) {
		
		int totalCnt = auserDAO.userListcount(sc);
		List<UserDTO> userList = auserDAO.selectList(sc);
		PageHandler pageHandler = new PageHandler(totalCnt, sc);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", totalCnt);
		map.put("List", userList);
		map.put("pageHandler", pageHandler);
		
		return map;
	}
	
	//관리자가 유저 목록에서 수정눌렀을 때
	public UserDTO user_update(int no) {
		return auserDAO.admin_userInfo(no);
	}
	
	//관리자가 유저 상세 목록에서 수정 눌렀을 때
	public void user_update_ok(UserDTO dto) {
		userDAO.userUpdate(dto);
	}
	
	//관리자가 유저 삭제버튼 눌렀을 때
	@Transactional
	public void user_delete_ok(int no) {
		auserDAO.userDelete(no);	//삭제쿼리
		auserDAO.userNumUpdate(no);	//업데이트쿼리
	}
	
	//관리자가 유저 삭제하면 user_num하나씩 줄어들게
//	public void user_num_update(int no) {
//		auserDAO.userNumUpdate(no); // 업데이트쿼리
//	}
	
	//관리자가 유저 등록함
	public String user_insert(UserDTO dto, String id, String pwd, String email, String name) {
		dto.setUser_email(email);
		dto.setUser_id(id);
		dto.setUser_pwd(pwd);
		dto.setUser_name(name);
		
		if(userDAO.idcheck(id) != 0 ) {return "아이디 실패";}
		else if(userDAO.emailcheck(email)!=0) {return "이메일 실패";}
		else {userDAO.join(dto);return "성공";}
	}

}

package org.spring.service;

import org.spring.dao.UserDAO;
import org.spring.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	@Autowired
	private UserDAO userDAO;

	// id 중복 체크 등 빈칸 있는지 js에서 처리하지 않고 service에서 처리해봄
	public String join(UserDTO dto, String pwd) {
		
		String test = "";
		
		int id_check = userDAO.idcheck(dto.getUser_id()); //중복아이디 확인
		int email_check = userDAO.emailcheck(dto.getUser_email()); //중복 이메일 확인
		
		// 회원가입 시 빈칸이 있을 경우
		if(dto.getUser_id().equals("") || dto.getUser_email().equals("") || dto.getUser_name().equals("") || 
		dto.getUser_pwd().equals("")) {
			test = "a";
		}
		
		// 회원가입 시 문제 사항들
		if(id_check != 0) {
			test = "b";
		}else if(email_check != 0) {
			test = "c";
		}else if(!pwd.equals(dto.getUser_pwd())) {
			test = "f";
		}else {
			int res = userDAO.join(dto);
			if(res>0) {
				test = "d";
			}else {
				test = "e";
			}
		}
		return test;
	}
	
}

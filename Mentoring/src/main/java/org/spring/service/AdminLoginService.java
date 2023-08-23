package org.spring.service;

import java.util.Map;

import org.spring.dto.SearchCondition;
import org.spring.dto.UserDTO;

public interface AdminLoginService {

	public Map<String, Object> user_list(SearchCondition sc);
	public UserDTO user_update(int no);
	public void user_delete_ok(int no);
	public void user_update_ok(UserDTO dto);
	public String user_insert(UserDTO dto, String id, String pwd, String email, String name);
}

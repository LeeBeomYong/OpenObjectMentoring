 package org.spring.dao;

import org.spring.dto.UserDTO;

public interface UserDAO {

	//ȸ�������Ҷ� ���̵� �ߺ�üũ
	public int idcheck(String id);
	
	//ȸ�������Ҷ� �̸��� �ߺ�üũ
	public int emailcheck(String email);
	
	//������ �������� Ȯ��
	public String admincheck(String id);
	
	//ȸ������ insert
	public int join(UserDTO dto);
	
	//�α��� �� ��й�ȣ Ȯ��
	public String pwdcheck(String id);
	
	//�α��� �� ��й�ȣ ã��
	public String email_search(String email);
	
	//ȸ�� ���� �޾ƿͼ� �������� �� �ѱ涧 �ʿ�
	public UserDTO userInfo(String id);
	
	//��й�ȣ ã�� �� ��й�ȣ �ʿ�
	public String pwd(String email);
	
	//ȸ�� ���� ������ �� �ʿ�
	public int userUpdate(UserDTO dto);
	
	
}

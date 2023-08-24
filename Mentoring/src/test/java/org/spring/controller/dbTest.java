package org.spring.controller;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class dbTest {
	
	 private static final String DRIVER = "org.mariadb.jdbc.Driver";
	 private static final String URL = "jdbc:mysql://127.0.0.1:3306/test"; 
	 private static final String USER = "root"; 
	 private static final String PW = "1234";   
	 
	@Test
	public void test() throws Exception {
		Class.forName(DRIVER);
		  
		  try(Connection con = DriverManager.getConnection(URL, USER, PW)){
		   System.out.println("����");
		   System.out.println(con);
		  }catch (Exception e) {
		   System.out.println("�����߻�");
		   e.printStackTrace();
		  }
	}

}

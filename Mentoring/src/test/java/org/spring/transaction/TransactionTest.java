package org.spring.transaction;

import javax.sql.DataSource;

import org.spring.dao.AdminUserDAO;
import org.spring.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public class TransactionTest {

	@Autowired
	AdminUserDAO auserDAO;
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	DataSource ds;
	
	@Autowired
	DataSourceTransactionManager tm = new DataSourceTransactionManager(ds);
	
	
}

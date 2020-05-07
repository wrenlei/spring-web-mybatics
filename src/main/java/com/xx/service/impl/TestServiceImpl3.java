package com.xx.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sl.dao.TestDao;
import com.sl.service.TestService;

@Service
public class TestServiceImpl3 implements TestService{

public static Logger logger=LoggerFactory.getLogger(TestServiceImpl3.class);

	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private TestDao testDao;
	
	//@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@Transactional
	public void addA() {
		logger.info("--------------addA---------------");
		testDao.insertA("11111");
	}
	
	public void addB() {
		logger.info("--------------addB---------------");
		testDao.insertB("11111");
	}

	@Transactional
	public void addC() throws SQLException {
		// TODO Auto-generated method stub
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		Connection connection = dataSource.getConnection();
		//connection.setAutoCommit(true);
		String sql="insert into t_testa(name) values('你好')";
		PreparedStatement stmt=connection.prepareStatement(sql);
		connection.prepareStatement(sql);
		stmt.execute(sql);
		System.out.println("22222222222222222222222"+connection.getAutoCommit());
	}

}

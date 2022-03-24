package com.training.pms.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.training.ers.model.User;

import dao.LoginDAO;
import dao.LoginDAOImpl;

class LoginDAOImplTest {
	LoginDAO loginDAO;

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		loginDAO = new LoginDAOImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetUsers() {
	List<User> uList = loginDAO.getUsers();
		
		for(User obj : uList)
			System.out.println(obj);
		
		assertTrue(uList.size() == 2 );

	}

}

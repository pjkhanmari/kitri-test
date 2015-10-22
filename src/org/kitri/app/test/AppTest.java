package org.kitri.app.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.kitri.app.domains.User;
import org.kitri.app.interfaces.RepositoryInterface;
import org.kitri.app.resources.TestRepositoryImpl;
import org.kitri.app.services.UserService;

public class AppTest {
	@Before
	public void before() throws InstantiationException, IllegalAccessException{
		RepositoryInterface.setRepository(TestRepositoryImpl.class);
	}
	
	@Test
	public void userTest(){
		System.out.println("User add and select");
		UserService service = new UserService();
		User user = new User();
		user.setId("testid");
		user.setPw("testpw");
		try {
			service.addUser(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		User result = service.getUser(user.getId(), user.getPw());
		assertEquals(user, result);
		System.out.println("secceed");
	}
}

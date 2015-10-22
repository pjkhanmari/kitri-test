package org.kitri.app.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.kitri.app.beans.User;
import org.kitri.app.interfaces.Repository;
import org.kitri.app.resources.TestRepository;
import org.kitri.app.services.UserService;

public class AppTest {
	@Before
	public void before() throws InstantiationException, IllegalAccessException{
		Repository.setRepository(TestRepository.class);
	}
	
	@Test
	public void userTest(){
		System.out.println("User add and select");
		UserService service = new UserService();
		User user = new User();
		user.setId("testid");
		user.setPw("testpw");
		service.addUser(user);
		User result = service.selectUser(user.getId(), user.getPw());
		assertEquals(user, result);
		System.out.println("secceed");
	}
}

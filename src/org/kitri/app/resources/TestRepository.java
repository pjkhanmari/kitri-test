package org.kitri.app.resources;

import java.util.HashMap;
import java.util.Map;

import org.kitri.app.beans.User;
import org.kitri.app.interfaces.Repository;

public class TestRepository extends Repository{
	
	public Map<String,User> users; // id, user 
	public TestRepository() {
		super();
		users = new HashMap<String, User>();
	}
	
	@Override
	public void insertUser(User user) {
		if(users.containsKey(user.getId()))
			return;
		else users.put(user.getId(), user);
	}

	@Override
	public User selectUser(String id, String pw) {
		User user = users.get(id);
		if(user.getPw().equals(pw))
			return user;
		else return null;
	}
}

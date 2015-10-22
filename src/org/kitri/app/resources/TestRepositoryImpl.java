package org.kitri.app.resources;

import java.util.HashMap;
import java.util.Map;

import org.kitri.app.domains.Employee;
import org.kitri.app.domains.User;
import org.kitri.app.interfaces.RepositoryInterface;
import org.kitri.app.message.ExceptionMessages;

public class TestRepositoryImpl extends RepositoryInterface{
	
	public Map<String,User> users; // id, user 
	public TestRepositoryImpl() {
		super();
		users = new HashMap<String, User>();
	}
	
	@Override
	public void insertUser(User user) throws Exception{
		if(users.containsKey(user.getId()))
			throw new Exception(ExceptionMessages.USER_EXISTS_ALREADY);
		else users.put(user.getId(), new User(user.getId(), user.getPw()));
	}

	@Override
	public User selectUser(String id, String pw) {
		User user = users.get(id);
		if(user.getPw().equals(pw))
			return user;
		else return null;
	}

	@Override
	public void updateUser(User user) throws Exception{
		User temp = users.get(user.getId());
		if(temp != null){
			users.remove(temp);
			users.put(temp.getId(), user);
		}else{
			throw new Exception(ExceptionMessages.USER_NOT_EXISTS);
		}
	}

	@Override
	public Employee addAuth(String id, int auth) throws Exception{
		User user = users.get(id);
		if(user == null)
			throw new Exception(ExceptionMessages.USER_NOT_EXISTS);
		if(user.getType() != User.TYPE_EMPLOYEE){
			throw new Exception(ExceptionMessages.IS_NOT_EMPLOYEE);
		}
		Employee temp = (Employee)user;
		temp.setAuths(temp.getAuths() | auth);
		return temp;
	}
	
	@Override
	public int selectAuth(String id) throws Exception {
		User user = users.get(id);
		if(user == null)
			throw new Exception(ExceptionMessages.USER_NOT_EXISTS);
		if(user.getType() != User.TYPE_EMPLOYEE){
			throw new Exception(ExceptionMessages.IS_NOT_EMPLOYEE);
		}
		return ((Employee)user).getAuths();
	}

	@Override
	public Employee removeAuth(String id, int auth) throws Exception {
		User user = users.get(id);
		if(user == null)
			throw new Exception(ExceptionMessages.USER_NOT_EXISTS);
		if(user.getType() != User.TYPE_EMPLOYEE){
			throw new Exception(ExceptionMessages.IS_NOT_EMPLOYEE);
		}
		Employee temp = (Employee)user;
		temp.setAuths(temp.getAuths() ^ auth);
		return temp;
	}
}

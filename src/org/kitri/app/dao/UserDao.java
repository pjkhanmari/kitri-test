package org.kitri.app.dao;

import org.kitri.app.beans.User;
import org.kitri.app.interfaces.Dao;
import org.kitri.app.interfaces.Repository;

/**
 * 사용자 정보
 * @author kitri
 *
 */
public class UserDao implements Dao{
	Repository rep = null;
	public UserDao() {
		rep = Repository.getInstance();
	}
	
	public User selectUser(User user){
		return selectUser(user.getId(), user.getPw());
	}
	
	public void insert(User user) {
		rep.insertUser(user);
	}

	public User selectUser(String id, String pw) {
		return rep.selectUser(id, pw);
	}
}
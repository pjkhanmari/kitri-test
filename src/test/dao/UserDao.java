package test.dao;

import test.beans.User;
import test.interfaces.Dao;
import test.interfaces.Repository;

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
		return rep.selectUser(user.getId(), user.getPw());
	}
	
	public void insert(User user) {
		rep.insertUser(user);
	}
}
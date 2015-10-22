package org.kitri.app.dao;

import org.kitri.app.domains.users.User;
import org.kitri.app.interfaces.Dao;
import org.kitri.app.interfaces.Repository;

/**
 * 사용자 정보
 * @author 김희택
 *
 */
public class UserDao extends Dao{
	Repository rep = null;
	public UserDao() {
		rep = Repository.getInstance();
	}
	
	public User selectUser(User user){
		return selectUser(user.getId(), user.getPw());
	}
	
	public void insert(User user) throws Exception{
		rep.insertUser(user);
	}

	public User selectUser(String id, String pw) {
		return rep.selectUser(id, pw);
	}

	public void updateUser(User user) throws Exception {
		rep.updateUser(user);
	}
}
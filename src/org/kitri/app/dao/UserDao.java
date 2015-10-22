package org.kitri.app.dao;

import org.kitri.app.domains.User;
import org.kitri.app.interfaces.Dao;
import org.kitri.app.interfaces.RepositoryInterface;

/**
 * 사용자 정보
 * @author kitri
 *
 */
public class UserDao extends Dao{
	RepositoryInterface rep = null;
	public UserDao() {
		rep = RepositoryInterface.getInstance();
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
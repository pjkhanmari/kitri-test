package org.kitri.app.services;

import org.kitri.app.beans.User;
import org.kitri.app.dao.UserDao;
import org.kitri.app.interfaces.Service;

/**
 * 사용자 정보 관리
 * @author kitri
 *
 */
public class UserService extends Service{
	public UserService() {
	}
	public void addUser(User user){
		UserDao dao = new UserDao();
		dao.insert(user);
	}
	public User selectUser(String id, String pw) {
		UserDao dao = new UserDao();
		return dao.selectUser(id, pw);
	}
}
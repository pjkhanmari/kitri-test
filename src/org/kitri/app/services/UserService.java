package org.kitri.app.services;

import org.kitri.app.dao.UserDao;
import org.kitri.app.domains.users.User;
import org.kitri.app.interfaces.Service;

/**
 * 사용자 정보 관리
 * @author 김희택
 *
 */
public class UserService extends Service{
	public UserService() {}
	public void addUser(User user) throws Exception{
		UserDao dao = new UserDao();
		dao.insert(user);
	}
	public User getUser(String id, String pw) {
		UserDao dao = new UserDao();
		return dao.selectUser(id, pw);
	}
	public void updateUser(User user) throws Exception{
		UserDao dao = new UserDao();
		dao.updateUser(user);
	}
}
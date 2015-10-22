package test.services;

import test.beans.User;
import test.dao.UserDao;
import test.interfaces.Service;

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
}
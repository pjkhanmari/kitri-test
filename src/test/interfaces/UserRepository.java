package test.interfaces;

import test.beans.User;

public interface UserRepository {
	void insertUser(User user);
	User selectUser(String id, String pw);
}

package org.kitri.app.interfaces;

import org.kitri.app.beans.User;

public interface UserRepository {
	void insertUser(User user);
	User selectUser(String id, String pw);
}

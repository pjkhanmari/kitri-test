package org.kitri.app.interfaces.repositories;

import org.kitri.app.domains.User;

public interface UserRepositoryInterface {
	void insertUser(User user) throws Exception;
	User selectUser(String id, String pw);
	void updateUser(User user) throws Exception;
}
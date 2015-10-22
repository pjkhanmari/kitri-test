package org.kitri.app.interfaces.repositories;

import org.kitri.app.domains.users.User;

public interface IUserRepository {
	void insertUser(User user) throws Exception;
	User selectUser(String id, String pw);
	void updateUser(User user) throws Exception;
}
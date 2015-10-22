package org.kitri.app.interfaces.repositories;

import org.kitri.app.domains.users.Employee;

public interface AuthorizationRepositoryInterface {
	Employee addAuth(String id, int auth) throws Exception;
	int selectAuth(String id) throws Exception;
	Employee removeAuth(String id, int auth) throws Exception;
}
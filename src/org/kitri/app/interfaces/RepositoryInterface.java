package org.kitri.app.interfaces;

import org.kitri.app.interfaces.repositories.AuthorizationRepositoryInterface;
import org.kitri.app.interfaces.repositories.CourseInfoRepositoryInterface;
import org.kitri.app.interfaces.repositories.UserRepositoryInterface;

public abstract class RepositoryInterface implements UserRepositoryInterface, AuthorizationRepositoryInterface, CourseInfoRepositoryInterface {
	private static RepositoryInterface instance = null;
	protected RepositoryInterface(){};
	public static RepositoryInterface getInstance() {
		return instance;
	}
	public static void setRepository(Class<? extends RepositoryInterface> c) throws InstantiationException, IllegalAccessException {
		instance = c.newInstance();
	}
}
package org.kitri.app.interfaces;

import org.kitri.app.interfaces.repositories.AuthorizationRepositoryInterface;
import org.kitri.app.interfaces.repositories.CourseInfoRepositoryInterface;
import org.kitri.app.interfaces.repositories.UserRepositoryInterface;

public abstract class Repository implements UserRepositoryInterface, AuthorizationRepositoryInterface, CourseInfoRepositoryInterface {
	private static Repository instance = null;
	public static Repository getInstance() {
		return instance;
	}
	public static void setRepository(Class<? extends Repository> c) throws InstantiationException, IllegalAccessException {
		instance = c.newInstance();
	}
	protected Repository(){};
}
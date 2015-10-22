package org.kitri.app.interfaces;

import org.kitri.app.interfaces.repositories.IAuthorizationRepository;
import org.kitri.app.interfaces.repositories.ICourseInfoRepository;
import org.kitri.app.interfaces.repositories.IUserRepository;

public abstract class Repository implements IUserRepository, IAuthorizationRepository, ICourseInfoRepository {
	private static Repository instance = null;
	public static Repository getInstance() {
		return instance;
	}
	public static void setRepository(Class<? extends Repository> c) throws InstantiationException, IllegalAccessException {
		instance = c.newInstance();
	}
	protected Repository(){};
}
package org.kitri.app.dao;

import org.kitri.app.interfaces.Dao;
import org.kitri.app.interfaces.RepositoryInterface;

public class AuthorizationDao extends Dao{
	RepositoryInterface rep;
	public AuthorizationDao() {
		rep = RepositoryInterface.getInstance();
	}
	
}

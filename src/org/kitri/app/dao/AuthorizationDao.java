package org.kitri.app.dao;

import org.kitri.app.interfaces.Dao;
import org.kitri.app.interfaces.Repository;

public class AuthorizationDao extends Dao{
	Repository rep;
	public AuthorizationDao() {
		rep = Repository.getInstance();
	}
	
}

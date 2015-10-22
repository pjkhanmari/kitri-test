package org.kitri.app.interfaces;


public abstract class Repository implements UserRepository{
	private static Repository instance = null;
	public Repository(){};
	public static Repository getInstance() {
		return instance;
	}
	public static void setRepository(Class<? extends Repository> c) throws InstantiationException, IllegalAccessException {
		instance = c.newInstance();
	}
}
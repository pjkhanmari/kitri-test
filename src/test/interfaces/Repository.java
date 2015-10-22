package test.interfaces;


public abstract class Repository implements UserRepository{
	private static Repository instance = null;
	protected Repository(){};
	public static Repository getInstance() {
		return instance;
	}
	protected void setRepository(Repository rep) {
		instance = rep;
	}	
}
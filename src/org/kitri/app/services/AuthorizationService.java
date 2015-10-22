package org.kitri.app.services;

import org.kitri.app.dao.UserDao;
import org.kitri.app.domains.users.Employee;
import org.kitri.app.domains.users.User;
import org.kitri.app.interfaces.Service;
import org.kitri.app.message.ExceptionMessages;

/**
 * 권한 관리 서비스
 * @author kitri
 *
 */
public class AuthorizationService extends Service{

	public AuthorizationService() {}
	public void addAuth(Employee emp) throws Exception{
		UserDao dao = new UserDao();
		User user = dao.selectUser(emp);
		if(user == null)
			throw new Exception(ExceptionMessages.USER_NOT_EXISTS);
		if(user.getType() != User.TYPE_EMPLOYEE)
			throw new Exception(ExceptionMessages.IS_NOT_EMPLOYEE);
		
	}
}

package dao;

import pojos.User;

public interface IUserDao {
	//validate user
	User authenticateUser(String email,String pwd) throws Exception;
}

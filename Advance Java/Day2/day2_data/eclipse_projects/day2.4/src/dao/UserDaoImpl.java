package dao;

import pojos.User;
import java.sql.*;
//import all static members of DBUtils
import static utils.DBUtils.*;

public class UserDaoImpl implements IUserDao {
	// data members
	private Connection cn;
	private PreparedStatement pst1;

	public UserDaoImpl() throws Exception {

		// get cn from DB utils
		cn = getConnection();
		// pst1
		pst1 = cn.prepareStatement("select * from dac_users where email=? and password=?");
		System.out.println("user dao created");
	}
	//clean up
	public void cleanUp() throws Exception
	{
		if(pst1 != null)
			pst1.close();
		if (cn != null)
			cn.close();
		System.out.println("user dao cleaned up");
	}

	@Override
	public User authenticateUser(String email, String pwd) throws Exception {
		// set IN params
		pst1.setString(1, email);
		pst1.setString(2, pwd);
		try(ResultSet rst=pst1.executeQuery())
		{
			if(rst.next())
				return new User(rst.getInt(1), email, pwd, rst.getDouble(4)
						, rst.getDate(5),rst.getString(6), rst.getString(7));
		}
		return null;
	}

}

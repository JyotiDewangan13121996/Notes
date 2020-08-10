/*
 * Connection pool based DAO layer
 */
package dao_cp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import business_objs.BankUser;

public class BankDao {
	// getConnection -- rets connection from existing CP
	public Connection getConnection() throws Exception {
		// create Initial Context
		InitialContext ctx = new InitialContext();
		// perform JNDI lookup to fetch DS associated CP
		DataSource ds = (DataSource) ctx
				.lookup("java:/comp/env/jdbc/mysql_pool");
		return ds.getConnection();
	}

	public BankUser validateUser(String name, String pass) throws Exception {
		BankUser user = null;
		try (Connection cn = getConnection();
				PreparedStatement pst = cn
						.prepareStatement("select id from bank_users where name=? and password =?");) {
			// set name & password
			pst.setString(1, name);
			pst.setString(2, pass);
			try (ResultSet rst = pst.executeQuery()) {
				if (rst.next())
					user = new BankUser(rst.getInt(1), name, pass);

			}// rst.close()

		}// pst.close,cn.close
		return user;

	}

	public String registerUser(String name, String pass) throws Exception {
		BankUser user = null;
		String mesg="Bank user registration failed";
		try (Connection cn = getConnection();
				PreparedStatement pst = cn
						.prepareStatement("insert into bank_users (name,password) values(?,?)")) {
			// set name & password
			pst.setString(1, name);
			pst.setString(2, pass);
			int rows=pst.executeUpdate();
			if (rows == 1)
				mesg="Bank user registration success";

		}// pst.close,cn.close
		return mesg;

	}

}

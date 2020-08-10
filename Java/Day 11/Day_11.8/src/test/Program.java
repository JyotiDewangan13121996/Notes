package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

import utils.DBUtils;

public class Program 
{
	public static void main(String[] args) 
	{
		String sql = "{call sp_fund_transfer(?,?,?,?,?)}";
		try( Connection connection = DBUtils.getConnection();
			CallableStatement statement = connection.prepareCall(sql))
		{
			statement.setInt(1, 101);
			statement.setInt(2, 102);
			statement.setFloat(3, 5000);
			statement.registerOutParameter(4, Types.FLOAT);
			statement.registerOutParameter(5, Types.FLOAT);
			
			statement.execute();
			System.out.println("Source  balance	:	"+statement.getFloat(4));
			System.out.println("Destination  balance	:	"+statement.getFloat(5));
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
	
}

package test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program
{
	public static void main(String[] args) 
	{
		Connection connection = null;
		Statement statement = null;
		try 
		{
			//Step 1 : Load and Register Driver
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			//Step 2 : Establish connection using users credential
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dac_db", "root", "mysql@8017");
			//Step 3 : Create Statement Object
			statement = connection.createStatement();
			//Step 4 : Prepare and execute Query
			String sql = "SELECT * FROM BookTable";
			try( ResultSet rs =  statement.executeQuery(sql); )
			{
				/*while( rs.next() )
				{
					int bookId = rs.getInt(1);
					String subjectName = rs.getString(2);
					String bookName =  rs.getString(3);
					String authorName = rs.getString(4);
					float price = rs.getFloat(5);
					System.out.printf("%-5d%-20s%-70s%-50s%-10.2f\n",bookId, subjectName, bookName, authorName, price);
				}*/
				while( rs.next() )
				{
					int bookId = rs.getInt("book_id");
					String subjectName = rs.getString("subject_name");
					String bookName =  rs.getString("book_name");
					String authorName = rs.getString("author_name");
					float price = rs.getFloat("price");
					System.out.printf("%-5d%-20s%-70s%-50s%-10.2f\n",bookId, subjectName, bookName, authorName, price);
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				if( statement != null )
					statement.close();
				if( connection != null )
					connection.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}

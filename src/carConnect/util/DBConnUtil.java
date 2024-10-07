package carConnect.util;
import java.sql.*;

public class DBConnUtil {
	public static Connection getConnection(String connString)
	{
		Connection conn= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("Loaded..");
			conn= DriverManager.getConnection(connString);
//			System.out.println("Connected...");
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("Driven Loading Failed");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Unable to connect to the Database!");
		}
		return conn;
	}
}

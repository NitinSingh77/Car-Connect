package carConnect.util;
import java.sql.*;

public class DBConnUtil {
	public static Connection getConnection(String connectionString)
	{
		Connection connection= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("Loaded..");
			connection= DriverManager.getConnection(connectionString);
//			System.out.println("Connected...");
			
		}catch(ClassNotFoundException err)
		{
			err.printStackTrace();
			System.out.println("Driven Loading Failed");
		}
		catch(SQLException err)
		{
			err.printStackTrace();
			System.out.println("Unable to connect to the Database!");
		}
		return connection;
	}
}

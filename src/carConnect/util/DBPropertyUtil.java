package carConnect.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
	public static String getConnectionString(String propertyFileName)
	{
		String connectionString= null;
		Properties propertyObject= new Properties();
		//Created a stream connected to Properties file
		try(FileInputStream fis= new FileInputStream(propFileName))
		{
			//try with resources
			propertyObject.load(fis);
			//created connection string
			connectionString= propertyObject.getProperty("db.url")+"?user="+propertyObject.getProperty("db.username")+"&password="+propertyObject.getProperty("db.password");
			
		}catch(IOException err)
		{
			err.printStackTrace();
			System.out.println("Error: Not able to connect with Properties file");
		}
		return connString;
	}
}

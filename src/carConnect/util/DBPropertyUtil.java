package carConnect.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
	public static String getConnString(String propFileName)
	{
		String connString= null;
		Properties propsObject= new Properties();
		//Created a stream connected to Properties file
		try(FileInputStream fis= new FileInputStream(propFileName))
		{
			//try with resources
			propsObject.load(fis);
			//created connection string
			connString= propsObject.getProperty("db.url")+"?user="+propsObject.getProperty("db.username")+"&password="+propsObject.getProperty("db.password");
			
		}catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("Error: Not able to connect with Properties file");
		}
		return connString;
	}
}

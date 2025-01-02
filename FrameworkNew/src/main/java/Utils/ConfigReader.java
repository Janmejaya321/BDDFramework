package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;
	
	 
	public static Properties init_prop()
	{
		prop= new Properties();
		try {
		FileInputStream ip=new FileInputStream("./src/test/resources/Config/config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException("Failed to load config.properties file");
	}
		return prop;
	}
	
	public static String getProperty(String key)
	{
		return prop.getProperty(key);
	}
}

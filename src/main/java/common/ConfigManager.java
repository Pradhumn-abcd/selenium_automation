package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	
	public static String getKeyValue(String keyName) throws Exception
	{
		// TODO Auto-generated method stub
				FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\config (1).properties");
				Properties properties=new Properties();
				properties.load(fis);
				
		return properties.getProperty(keyName);
	}
	

	/*
	 * public static void main(String[] args) throws Exception { // TODO
	 * Auto-generated method stub FileInputStream fis=new
	 * FileInputStream(".\\src\\main\\resources\\config.properties"); Properties
	 * properties=new Properties(); properties.load(fis);
	 * 
	 * System.out.println(properties.getProperty("PASSWORD"));
	 * 
	 * }
	 */

}

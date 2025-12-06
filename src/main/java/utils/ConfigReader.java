package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties properties; 
	
	static {
		String path = "src/main/resources/config.properties";
		try(FileInputStream fis = new FileInputStream(path)) {
			properties = new Properties();
			properties.load(fis); 
		} catch(Exception e) {
			System.out.println("Failed to load config.properties: "+ e.getMessage());
		}
	}
	
	public static String getProperty(String key) {
		if(properties == null) {
			throw new RuntimeException("config.properties not loaded properly!");
		}
		return properties.getProperty(key); 
	}
	
}

package util;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {
	Properties prop;
	public ReadConfig()
	{
		
		File src = new File("C:\\Users\\Mahendran\\eclipse-workspace\\AutomationPractice\\configuration\\config.properties");
		
try {
	FileInputStream fis = new FileInputStream(src);
	 prop = new Properties();
	prop.load(fis);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  
	}
	
	public String getUrl()
	{
		String url = prop.getProperty("url");
		return url;
	}

}

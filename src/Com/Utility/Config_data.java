package Com.Utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Config_data {
	WebDriver driver;
	File src;
	FileInputStream fis;
	Properties prop;
	
	public Config_data() throws Exception {
		
		src = new File("C:\\Users\\sandeep.mandhala\\eclipse-workspace\\Tool_Tip\\src\\Com\\Utility\\config_file");
		fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
	}
	public String getUrl() {
		String url = prop.getProperty("URL");
   return url;
		 	
	}
	public String getUsername() {
	String susername= prop.getProperty("username");
	return susername;
	
		 	
	}
	public String getPassword() {
	String spassword= prop.getProperty("password");
	return spassword;
	
		 	
	}
}

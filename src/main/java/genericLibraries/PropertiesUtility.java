package genericLibraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains reusable methods to read data from properties file
 * @author venne
 */

public class PropertiesUtility {
	private Properties property;
	/*This method is used to initialize properties file
	 * @author 
	 */
	
	public void propertiesInitialization(String filepath) {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(filepath);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to fetch data from {@link Properties} file
	 * @param key
	 * @return
	 */
	public String readFromPropertiesString(String key) {
		return property.getProperty(key);
	}
		
		
	}



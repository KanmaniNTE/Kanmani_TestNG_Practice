package com.orangehrm.utilities;

import java.io.FileReader;
import java.util.Properties;

public class PropertyFileReading {
	
	
	public void readAProperty(String filePath, String propName) throws Exception {
		FileReader reader = new FileReader(filePath);

		Properties prop = new Properties();
		prop.load(reader);

		String prop_name = prop.getProperty(propName);
		System.out.println(prop_name);
	}
	

	
	public String readApropertyAndReturnItsValue(String filePath, String propName) throws Exception {
		FileReader reader = new FileReader(filePath);

		Properties prop = new Properties();
		prop.load(reader);

		return prop.getProperty(propName);
		
	}

}

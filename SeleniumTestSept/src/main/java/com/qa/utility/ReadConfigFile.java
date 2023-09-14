package com.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFile {
	
	Properties prop;
	
	public ReadConfigFile() {
		
		try {
			
			File file =new File("./config/config.properties");
			FileInputStream fis =new FileInputStream(file);
			prop=new Properties();
			prop.load(fis);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public String openUrl() {
		
		try {
			
			String urlAccess = prop.getProperty("url");
			System.out.println(urlAccess);
			return urlAccess;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}

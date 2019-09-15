package com.amazon.utilitiesFiles;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	
	public ReadConfig()
	{
		File src= new File("./AmazonConfiguration/config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			
			properties = new Properties();
			
			properties.load(fis);
		  
		}
		
		catch(Exception e)
		{
			System.out.println(" Exception is " +e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=properties.getProperty("baseURL");
		
		return url;
	}
	
	public String getChromeDriverPath()
	{
		String chromepath = properties.getProperty("chromePath");
		
		return chromepath;
	}
	
	public String getSearchKey()
	{
		String searchkey = properties.getProperty("headfones");
		
		return searchkey;
	}

}

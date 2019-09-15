package com.amazon.utilitiesFiles;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class CaptureScreenSot {
	
	@Test
	
	public static void captureAllScreenShot(WebDriver driver, String screenShotName)
	{
		
		try {
			
			EventFiringWebDriver e = new EventFiringWebDriver(driver);
			File srcFile = e.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./AmazonScreenShot/"+screenShotName+".png");
			FileHandler.copy(srcFile,destFile);
			
		     } 
		   
		catch (Exception e)
		{
		  System.out.println("Exception while taking screenshot: "+e.getMessage());	
		}
		
		
	}

}

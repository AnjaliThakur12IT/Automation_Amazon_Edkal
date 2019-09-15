package com.amazon.Test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.amazon.utilitiesFiles.CaptureScreenSot;
import com.amazon.utilitiesFiles.ReadConfig;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class BaseTest {

	public WebDriver driver;
	ATUTestRecorder recorder;
	
	ReadConfig readconfig = new ReadConfig();
	
	Logger log = Logger.getLogger(BaseTest.class);
	
	public String baseURL=readconfig.getApplicationURL();
	
	public String searchKey = readconfig.getSearchKey();
	
	@BeforeMethod
	public void preCondition() throws ATUTestRecorderException {
		System.setProperty("webdriver.chrome.driver", readconfig.getChromeDriverPath());
		recorder = new ATUTestRecorder("AmazonTestResult/", "AmazonTestScenarioResult", false);
		recorder.start();
		driver=new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void postCondition(ITestResult result) throws ATUTestRecorderException {
		
		if (ITestResult.FAILURE==result.getStatus()) 
		{
			CaptureScreenSot.captureAllScreenShot(driver, result.getName());
		}
		
		driver.close();
		recorder.stop();
	}

}

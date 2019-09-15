package com.amazon.pageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.print.Pageable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage  
{
	public AmazonHomePage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='nav-search-field ']//input[@type='text']")
	private WebElement searchBox;
	
	public void search(String searchKey) 
	{
		assertTrue(searchBox.isDisplayed() , "Text box is not present on the home page");
		searchBox.sendKeys(searchKey+Keys.ENTER);
	}
}

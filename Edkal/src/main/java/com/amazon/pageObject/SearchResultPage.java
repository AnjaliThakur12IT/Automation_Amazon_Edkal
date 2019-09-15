package com.amazon.pageObject;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage 
{	
	public SearchResultPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='a-section a-spacing-medium']//span[contains(@data-component-props,'best-seller')]/ancestor::div[@class='a-section a-spacing-medium']//a[@class='a-link-normal a-text-normal']")
	private List<WebElement> bestSellerProductsUrl;

	@FindBy(xpath="//div[@id='addToCart_feature_div']//input")
	private WebElement addToCartButton;
	
	
	public int findBestSellerInPage(WebDriver driver,String searchKey) throws InterruptedException
	{
		    List<WebElement> allBestSellerProductsUrl =bestSellerProductsUrl;
		    
		    for (int i = 0; i < allBestSellerProductsUrl.size(); i++) 
		    {
			  System.out.println(allBestSellerProductsUrl.size());
			  System.out.println(allBestSellerProductsUrl.get(i).getText());
			  JavascriptExecutor js = (JavascriptExecutor)driver;
			  js.executeScript("arguments[0].scrollIntoView(true);",allBestSellerProductsUrl.get(i));
			  js.executeScript("arguments[0].click();", allBestSellerProductsUrl.get(i));
			  //allBestSellerProductsUrl.get(i).click();
			  assertTrue(addToCartButton.isDisplayed(), "AddToCart button is not visibile on the product page");
			  addToCartButton.click();
			  Thread.sleep(2000);
			  driver.navigate().refresh();
		
			driver.get("https://www.amazon.com/s?k="+searchKey+"&ref=nb_sb_noss");
			
			}
		    
		    return allBestSellerProductsUrl.size();
		}
	
	
	

}


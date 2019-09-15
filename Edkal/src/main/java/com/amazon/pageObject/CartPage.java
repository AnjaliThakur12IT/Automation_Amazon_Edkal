package com.amazon.pageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

public class CartPage 
{
	public CartPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@id='nav-cart-count']")
	private WebElement cartQuantity;
	
	
	public int getProductCountInCart() {
		 return Integer.parseInt(cartQuantity.getText());
	}
	public void validateTotalProductsCount(int totalBestsellerProductCountOnSearchPage) {
		System.out.println(totalBestsellerProductCountOnSearchPage);
		System.out.println(getProductCountInCart());
		Assertion assertion = new Assertion();
		assertEquals(totalBestsellerProductCountOnSearchPage , getProductCountInCart() , "total product count on search page is not equal to the total product count in cart");
		
}
}
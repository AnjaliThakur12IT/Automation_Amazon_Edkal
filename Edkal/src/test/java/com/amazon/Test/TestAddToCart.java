package com.amazon.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.amazon.pageObject.AmazonHomePage;
import com.amazon.pageObject.CartPage;
import com.amazon.pageObject.SearchResultPage;
import com.amazon.utilitiesFiles.CaptureScreenSot;

public class TestAddToCart extends BaseTest{
	
	@Test
	public void testAddBestSellerHeadFoneToCard() throws InterruptedException {
		AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
		
		amazonHomePage.search(searchKey);
		
		log.info("List of products name");
		
		SearchResultPage searchResultPage= new SearchResultPage(driver);
		
		int searchPageProductCount = searchResultPage.findBestSellerInPage(driver,searchKey);
		
		log.info(" Display bestseller product name");
		
		CartPage cartPage = new CartPage(driver);
		
		cartPage.validateTotalProductsCount(searchPageProductCount);
		
		log.info("List of added product");
		
		
	}	
	
	

}

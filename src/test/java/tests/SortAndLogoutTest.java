package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class SortAndLogoutTest extends BaseTest {

	@Test
	public void sortByPriceLowToHigh() {
		String username = ConfigReader.getProperty("username");
		String password = ConfigReader.getProperty("password");
		
		LoginPage loginPage = new LoginPage(driver); 
		ProductsPage productsPage = loginPage.login(username, password);
		
		productsPage.selectSortOption("Price (low to high)");
		
		boolean isSorted = productsPage.isProductPricesSortedLowToHigh();
		Assert.assertTrue(isSorted, "Product prices are not sorted according to condition!");
		
		productsPage.logout();
		
		String currentUrl = driver.getCurrentUrl(); 
		Assert.assertTrue(currentUrl.contains("saucedemo.com"), "URL after logout looks wrong: "+currentUrl);
		
	}
}

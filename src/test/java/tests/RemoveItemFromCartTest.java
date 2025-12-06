package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class RemoveItemFromCartTest extends BaseTest {
	
	@Test
	public void removeSingleItemFromCart() {
		String username = ConfigReader.getProperty("username");
		String password = ConfigReader.getProperty("password");
		
		LoginPage loginPage = new LoginPage(driver); 
		ProductsPage productsPage = loginPage.login(username, password);
		
		productsPage.backPackToCart();
		productsPage.bikeLightToCart();
		
		CartPage cartPage = productsPage.clickCartIcon();
		int initialCount = cartPage.getCartItemsCount();
		Assert.assertEquals(initialCount, 2, "Cart items count must be 2");
	
		cartPage.removeItemByName("Sauce Labs Bike Light");
		
		int finalCount = cartPage.getCartItemsCount(); 
		Assert.assertEquals(finalCount, 1, "Cart items count must be 1");
		
	}
	
}

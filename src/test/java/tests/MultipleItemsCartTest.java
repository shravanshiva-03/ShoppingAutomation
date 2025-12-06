package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class MultipleItemsCartTest extends BaseTest {
	
	@Test
	public void addMultipleItemsAndVerifyCartCount() {
		String username = ConfigReader.getProperty("username");
		String password = ConfigReader.getProperty("password");
		
		LoginPage loginPage = new LoginPage(driver); 
		ProductsPage productsPage = loginPage.login(username, password);
		
		productsPage.backPackToCart();
		productsPage.bikeLightToCart();
		productsPage.tShirtToCart();
		
		int badgeCount = productsPage.getCartBadgeCount();
		Assert.assertEquals(badgeCount, 3, "Cart badge count must be 3");
		
		CartPage cartPage = productsPage.clickCartIcon();
		int cartItems = cartPage.getCartItemsCount(); 
		Assert.assertEquals(cartItems, 3, "Cart items count must be 3");
		
		
	}
	
}

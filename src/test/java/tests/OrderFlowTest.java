package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutOnePage;
import pages.CheckoutTwoPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class OrderFlowTest extends BaseTest {
	
	@Test
	public void orderFlow() {
		String username = ConfigReader.getProperty("username"); 
		String password = ConfigReader.getProperty("password"); 
		
		LoginPage loginPage = new LoginPage(driver); 
		ProductsPage productsPage = loginPage.login(username, password);
		
		productsPage.backPackToCart();
		
		CartPage cartPage = productsPage.clickCartIcon();
		String cartItemNames = cartPage.getCartItemName();
		
		Assert.assertTrue(cartItemNames.contains("Sauce Labs Backpack"), "Cart item is not there");
		//Assert.assertTrue(cartItemNames.contains("Sauce Labs Bike Light"), "Cart item is not there");
		
		CheckoutOnePage checkoutOnePage = cartPage.clickCheckout();
		
		CheckoutTwoPage checkoutTwoPage = checkoutOnePage.fillUserInfoAndContinue("Test", "User", "500001");
		
		String overViewItemName = checkoutTwoPage.getItemsNameOnOverview();
		Assert.assertTrue(overViewItemName.contains("Sauce Labs Backpack"), "Overview page is not there");
		
		CheckoutCompletePage completePage = checkoutTwoPage.clickFinish();
		String thankYouMsg = completePage.getThankyouMsg(); 
		
		Assert.assertEquals(thankYouMsg, "Thank you for your order!", 
				"Order completion message not displayed");
		
	}
	
}

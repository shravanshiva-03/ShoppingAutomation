package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class ValidLoginTest extends BaseTest {
	
	@Test
	public void login() {
		String username = ConfigReader.getProperty("username"); 
		String password = ConfigReader.getProperty("password"); 
		
		LoginPage loginPage = new LoginPage(driver); 
		ProductsPage productsPage = loginPage.login(username, password);
		
		String title = productsPage.getTitle();
		Assert.assertEquals(title, "Products", 
				"User did not navigate to Products page after Login");
		test.info("Logged in with valid credentials!");
		
	}
}

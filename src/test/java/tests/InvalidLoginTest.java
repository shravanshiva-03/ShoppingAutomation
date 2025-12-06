package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ConfigReader;

public class InvalidLoginTest extends BaseTest {
	
	@Test
	public void invalidLoginErrorMsg() {
		String invalidUser = ConfigReader.getProperty("invalid_username"); 
		String invalidPass = ConfigReader.getProperty("invalid_password"); 
		
		LoginPage loginPage = new LoginPage(driver); 
		loginPage.login(invalidUser, invalidPass);
		test.info("Invalid credentials have been given"); 
		
		String errorMsg = loginPage.getErrorMessage(); 
		Assert.assertNotNull(errorMsg, "Error message is not displayed!");
		Assert.assertTrue(errorMsg.contains("Epic sadface: Username and password do not match any user in this service")
				, "Unexpected error message: " + errorMsg);
		test.pass("Invalid login error message validated");
		
		
	}
}

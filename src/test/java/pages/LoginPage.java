package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver; 

	@FindBy(id = "user-name")
	private WebElement usernameInput; 
	
	@FindBy(id = "password")
	private WebElement passwordInput;
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	@FindBy(tagName = "h3")
	private WebElement errorMsg; 
	
	public LoginPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String username) {
		usernameInput.clear();
		usernameInput.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	public ProductsPage login(String username, String password) {
		enterUsername(username); 
		enterPassword(password); 
		clickLogin(); 
		return new ProductsPage(driver);
	}
	
	public String getErrorMessage() {
		try {
			return errorMsg.getText();
		} catch(Exception e) {
			return null; 
		}
	}
	
	
}

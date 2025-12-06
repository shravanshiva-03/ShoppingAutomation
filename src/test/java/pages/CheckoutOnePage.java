package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOnePage {
	WebDriver driver; 
	
	@FindBy(id = "first-name")
	private WebElement firstnameField;
	
	@FindBy(id = "last-name")
	private WebElement lastnameField;
	
	@FindBy(id = "postal-code")
	private WebElement postalcodeField;
	
	@FindBy(id = "continue")
	private WebElement continueBtn; 
	
	public CheckoutOnePage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstname(String firstname) {
		firstnameField.clear();
		firstnameField.sendKeys(firstname);
	}
	
	public void enterLastname(String lastname) {
		lastnameField.clear();
		lastnameField.sendKeys(lastname);
	}
	
	public void enterPostalcode(String postalcode) {
		postalcodeField.clear();
		postalcodeField.sendKeys(postalcode);
	}
	
	public CheckoutTwoPage clickContinue() {
		continueBtn.click();
		return new CheckoutTwoPage(driver); 
	}
	
	public CheckoutTwoPage fillUserInfoAndContinue(String fn, String ln, String pc) {
        enterFirstname(fn);
        enterLastname(ln);
        enterPostalcode(pc);
        return clickContinue();
    }
	
	
}

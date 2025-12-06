package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutTwoPage {
	WebDriver driver; 
	
	@FindBy(className = "inventory_item_name")
	private WebElement item; 
	
	@FindBy(id = "finish")
	private WebElement finishBtn;
	
	public CheckoutTwoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getItemsNameOnOverview() {
		return item.getText();
	}
	
	public CheckoutCompletePage clickFinish() {
		finishBtn.click();
		return new CheckoutCompletePage(driver); 
	}
	
}

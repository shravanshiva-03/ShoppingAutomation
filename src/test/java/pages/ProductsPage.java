package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	WebDriver driver;
	
	@FindBy(xpath = "//div/button[@id='add-to-cart-sauce-labs-backpack']")
	private WebElement backPack; 
	
	@FindBy(xpath = "//div/button[@id='add-to-cart-sauce-labs-bike-light']")
	private WebElement bikeLight;
	
	@FindBy(xpath = "//div/button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
	private WebElement tShirt;
	
	@FindBy(css = "a[class='shopping_cart_link']")
	private WebElement cartIcon; 
	
	@FindBy(className = "product_sort_container")
	private WebElement sortDropdown; 
	
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuBtn;
	
	@FindBy(className = "title")
	private WebElement pageTitle; 
	
	@FindBy(id = "logout_sidebar_link")
	private WebElement logoutBtn;
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return pageTitle.getText(); 
	}
	
	 //-- cart related 
	
	
	public void backPackToCart() {
		backPack.click();
	}
	
	public void bikeLightToCart() {
		bikeLight.click();
	}
	
	public void tShirtToCart() {
		tShirt.click();
	}
	
	public CartPage clickCartIcon() {
		cartIcon.click();
		return new CartPage(driver); 
	}
	
	public int getCartBadgeCount() {
		List<WebElement> badges = driver.findElements(By.className("shopping_cart_badge"));
		if(badges.isEmpty()) {
			return 0;
		}
		return Integer.parseInt(badges.get(0).getText().trim());
		
	}
	
	public void addProductToCartByName(String productName) {
		List<WebElement> items = driver.findElements(By.className("inventory_item"));
		for(WebElement item: items) {
			String name = item.findElement(By.className("inventory_item_name")).getText(); 
			if(name.equalsIgnoreCase(productName)) {
				item.findElement(By.tagName("button")).click();
				break;
			}
		}
		
	}
	
	// sorting related ---
	
	public void selectSortOption(String visibleText) {
		WebElement dropdown = sortDropdown; 
		dropdown.click();
		dropdown.findElement(By.xpath("//option[.='" + visibleText + "']")).click();
		
	}
	
	public List<Double> getAllProductPricesAsDisplayed() {
		List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
		List<Double> values = new ArrayList<>();
		for(WebElement priceElement: prices) {
			String text = priceElement.getText().replace("$", "").trim();
			values.add(Double.parseDouble(text));
		}
		return values; 
	}
	
	public boolean isProductPricesSortedLowToHigh() {
		List<Double> actual = getAllProductPricesAsDisplayed();
		List<Double> sorted = new ArrayList<>(actual);
		Collections.sort(sorted);
		return actual.equals(sorted);
	}
	
	
	
	//--logout
	
	public void logout() {
		menuBtn.click();
		logoutBtn.click();
		
	}
	
	
}

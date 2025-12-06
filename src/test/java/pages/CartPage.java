package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    private WebDriver driver;

    private By cartItemName = By.className("inventory_item_name");
    private By checkoutBtn  = By.id("checkout");
    private By cartItems    = By.className("cart_item");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartItemName() {
        return driver.findElement(cartItemName).getText();
    }

    public int getCartItemsCount() {
        List<WebElement> items = driver.findElements(cartItems);
        return items.size();
    }

    public void removeItemByName(String productName) {
        List<WebElement> items = driver.findElements(cartItems);
        for (WebElement item : items) {
            String name = item.findElement(cartItemName).getText().trim();
            if (name.equalsIgnoreCase(productName)) {
                item.findElement(By.tagName("button")).click();
                break;
            }
        }
    }

    public CheckoutOnePage clickCheckout() {
        driver.findElement(checkoutBtn).click();
        return new CheckoutOnePage(driver);
    }
}

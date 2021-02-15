package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
	WebDriver driver;
	WebElement addToCartButton;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAddToCartButton() {
		return driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]"));
	}
	public void addToCartClick () {
		this.getAddToCartButton().click();
	}
	
	
	

}

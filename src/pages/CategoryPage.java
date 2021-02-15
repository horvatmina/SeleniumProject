package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryPage {
	WebDriver driver;
	WebElement tShirt;
	WebElement addToCartButton;
	
	public CategoryPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement gettShirt() {
		return driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']"));
	}	
	public WebElement getAddToCartButton() {
		return driver.findElement(By.name("Submit"));
	}
	public void tShirtClick () {
		this.gettShirt().click();
	}
	public void addToCartButtonClick () {
		this.getAddToCartButton().click();
	}	

}

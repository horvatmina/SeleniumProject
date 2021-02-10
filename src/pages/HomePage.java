package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	WebElement signInTab;
	WebElement addToCartButton;
	WebElement proceedToCheckout;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
    
	//GETTERS
	public WebElement getSignInTab() {
		return driver.findElement(By.className("login"));
	}
	
	public WebElement getAddToCartButton() {
		return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]"));
				//+ "//a[@title='Add to cart']"));
	}

	public WebElement getProceedToCheckout() {
		return driver.findElement(By.xpath("//a[@title='Proceed to checkout']")); 
	}
    //CLICK
	public void signInTabClick () {
		this.getSignInTab().click();
	}
	public void addToCartButtonClick () {
		this.getAddToCartButton().click();
	}

}

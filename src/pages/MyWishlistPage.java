package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tests.TestBase;

public class MyWishlistPage {
	WebDriver driver;
	WebElement nameField;
	WebElement saveButton;
	WebElement deleteButton;
	List <WebElement> wishlists;
	List <WebElement> deleteButtons;
	public int numberOfLists;

	public MyWishlistPage(WebDriver driver) {
		this.driver = driver;
	}

	//GETTERS
	public WebElement getNameField() {
		return driver.findElement(By.id("name"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitWishlist"));
	}

	public List<WebElement> getWishlists() {
		return driver.findElements(By.cssSelector("[id*=wishlist_]"));
	}

	public List<WebElement> getDeleteButtons() {
		return driver.findElements(By.className("icon"));
	}
	

	//METHODS
	public void addWishlist (String name) {
		this.getNameField().clear();
		this.getNameField().sendKeys(name);
		this.getSaveButton().click();
	}
	
	public int getNumberofLists() {
		return getWishlists().size();
	}
	
	public void deleteAllWishlists() throws InterruptedException {
		for(int i = 0; i < getNumberofLists(); i++) {
			getDeleteButtons().get(i).click();
			driver.switchTo().alert().accept();
		}
		
		Thread.sleep(2000);
	}
	
	public void deleteAWishlist() throws InterruptedException {
			getDeleteButtons().get(0).click();
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
	}

}

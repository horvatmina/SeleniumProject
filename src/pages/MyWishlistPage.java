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
	WebElement dresses;
	WebElement hats;
	WebElement pants;
	WebElement wishlistTable;

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

	public WebElement getDeleteButton() {
		return driver.findElement(By.className("icon-remove"));
	}

	public WebElement getDresses() {
		return driver.findElement(By.linkText("Dresses"));
	}

	public WebElement getHats() {
		return driver.findElement(By.linkText("Hats"));
	}

	public WebElement getPants() {
		return driver.findElement(By.linkText("Pants"));
	}
	
	public WebElement getWishlistTable() {
		return driver.findElement(By.className("mywishlist_first"));
	}

	//CLICK
	public void saveButtonClick() {
		this.getSaveButton().click();
	}

	public void deleteButtonClick() {
		this.getDeleteButton().click();
	}
	

	//SEND KEYS
	public void wishlistName(String name) {
		this.getNameField().clear();
		this.getNameField().sendKeys(name);
	}
	
	//ASSERT
	public void assertTheWishlist1() {
		List<WebElement> dynamicElement = driver.findElements(By.className("mywishlist_first"));
		if (dynamicElement.size() != 0) {
			System.out.println("Element present");
		} else {
			System.out.println("Element not present");
		}
	}

}

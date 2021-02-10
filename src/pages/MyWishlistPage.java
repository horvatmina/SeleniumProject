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

	public MyWishlistPage(WebDriver driver) {
		this.driver = driver;
	}

	// GETTERS
	public WebElement getNameField() {
		return driver.findElement(By.id("name"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitWishlist"));
	}

	public WebElement getDeleteButton() {
		return driver.findElement(By.className("icon-remove"));
	}

	// CLICK
	public void saveButtonClick() {
		this.getSaveButton().click();
	}

	public void deleteButtonClick() {
		this.getDeleteButton().click();
	}

	// SEND KEYS
	public void wishlistName(String name) {
		this.getNameField().clear();
		this.getNameField().sendKeys(name);
	}

	public void assertTheWishlist1() {
		List<WebElement> dynamicElement = driver.findElements(By.className("Dresses"));
		if (dynamicElement.size() != 0) {
			System.out.println("Element present");
		} else {
			System.out.println("Element not present");
		}
	}

	public void assertTheWishlist2() {
		List<WebElement> dynamicElement = driver.findElements(By.className("Hats"));
		if (dynamicElement.size() != 0) {
			System.out.println("Element present");
		} else {
			System.out.println("Element not present");
		}
	}

	public void assertTheWishlist3() {
		List<WebElement> dynamicElement = driver.findElements(By.className("Pants"));
		if (dynamicElement.size() != 0) {
			System.out.println("Element present");
		} else {
			System.out.println("Element not present");
		}
	}

}

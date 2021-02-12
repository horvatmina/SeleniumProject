package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdentityPage {
	WebDriver driver;
	WebElement firstNameField;
	WebElement lastNameField;
	WebElement currentPasswordField;
	WebElement saveButton;
	WebElement alertMessage;
	WebElement backToYourAccount;

	public IdentityPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//GETTERS
	public WebElement getLastNameField() {
		return driver.findElement(By.id("lastname"));
	}
	public WebElement getFirstNameField() {
		return driver.findElement(By.id("firstname"));
	}
	public WebElement getCurrentPasswordField() {
		return driver.findElement(By.id("old_passwd"));
	}
	public WebElement getSaveButton() {
		return driver.findElement(By.name("submitIdentity"));
	}	
	public WebElement getAlertMessage() {
		return driver.findElement(By.className("alert-success"));
	}
	public WebElement getBackToYourAccount() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/a"));	                                   
	}
	
	//CLICK
	public void saveButtonClick () {
		this.getSaveButton().click();
	}
	public void backToYourAccountClick () {
		this.getBackToYourAccount().click();
	}
	//INPUT
	public void firstName (String firstname) {
		this.getFirstNameField().clear();
		this.getFirstNameField().sendKeys(firstname);
	}
	public void lastName (String lastname) {
		this.getLastNameField().clear();
		this.getLastNameField().sendKeys(lastname);
	}	
	public void password (String password) {
		this.getCurrentPasswordField().clear();
		this.getCurrentPasswordField().sendKeys(password);
	}
	

}

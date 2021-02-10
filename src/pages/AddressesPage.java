package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddressesPage {
	WebDriver driver;
	WebElement updateButton;
	WebElement address1Field;
	WebElement saveButton;
	WebElement currentAddressName;
	WebElement addNewAddress;
	WebElement cityField;
	WebElement zipField;
	WebElement mobilePhoneField;
	WebElement addressTitleField;
	WebElement stateField;
	WebElement currentAddressTitle;
	WebElement secondAddressTitle;
	WebElement deleteButton;
	
	public AddressesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//GETTERS
	public WebElement getUpdateButton() {
		return driver.findElement(By.xpath("//a[@title=\"Update\"]"));
	}

	public WebElement getAddress1Field() {
		return driver.findElement(By.id("address1"));
	}
	
	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitAddress"));
	}

	public WebElement getCurrentAddressName() {
		return driver.findElement(By.className("address_address1"));
	}
	
	public WebElement getSecondAddressTitle() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[1]/h3"));
	}                                       

	public WebElement getAddNewAddress() {
		return driver.findElement(By.xpath("//a[@title=\"Add an address\"]"));
	}

	public WebElement getCityField() {
		return driver.findElement(By.id("city"));
	}

	public WebElement getZipField() {
		return driver.findElement(By.id("postcode"));
	}

	public WebElement getMobilePhoneField() {
		return driver.findElement(By.id("phone_mobile"));
	}

	public WebElement getAddressTitleField() {
		return driver.findElement(By.id("alias"));
	}

	public WebElement getStateField() {
		return driver.findElement(By.id("id_state"));
	}

	public WebElement getCurrentAddressTitle() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[1]/h3"));
	}

	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath("//a[@title=\"Delete\"]"));
	}  
	
	//CLICK
	public void updateButtonClick () {
		this.getUpdateButton().click();
	}
	
	public void deleteButtonClick() {
		this.getDeleteButton().click();
	}
	
	public void saveButtonClick () {
		this.getSaveButton().click();
	}
	
	public void addNewAddressClick () {
		this.getAddNewAddress().click();
	}
	
	//SEND KEYS
	public void address1 (String address) {
		this.getAddress1Field().clear();
		this.getAddress1Field().sendKeys(address);
	}
	
	public void city (String city) {
		this.getCityField().clear();
		this.getCityField().sendKeys(city);
	}
	public void zip (String zip) {
		this.getZipField().clear();
		this.getZipField().sendKeys(zip);
	}
	public void phone (String phone) {
		this.getMobilePhoneField().clear();
		this.getMobilePhoneField().sendKeys(phone);
	}
	public void addressTitle (String title) {
		this.getAddressTitleField().clear();
		this.getAddressTitleField().sendKeys(title);
	}

	//DROPDOWN MENU
	public void chooseState(int index) {
		Select stateFromDropDown = new Select(getStateField());
		stateFromDropDown.selectByIndex(index);
	}	

}

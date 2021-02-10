package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement emailInput;
	WebElement passwordInput;
	WebElement signInButton;
	WebElement singOutButton;
	WebElement welcomeMessage;
	WebElement errorMessage;
	WebElement myAddressesPage;
	WebElement myPersonalInfo;
	WebElement myWishlists;
	WebElement homeButton;
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
    //GETTERS
	public WebElement getEmailInput() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPasswordInput() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}

	public WebElement getSignOutButton() {
		return driver.findElement(By.className("logout"));
	}

	public WebElement getWelcomeMessage() {
		return driver.findElement(By.className("info-account"));
	}

	public WebElement getErrorMessage() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]"));
		                          //By.className("alert-danger")
	}
	
	public WebElement getMyAddressesPage() {
		return driver.findElement(By.xpath("//a[@title='Addresses']"));
	}
	
	public WebElement getMyPersonalInfo() {
		return driver.findElement(By.xpath("//a[@title='Information']"));
	}
	
	public WebElement getMyWishlists() {
		return driver.findElement(By.xpath("//a[@title='My wishlists']"));
	}
	
	public WebElement getHomeButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/a"));
				//+ "//a[@title='Home']"));
	}
	public void login (String email, String password) {
		this.getEmailInput().clear();
		this.getEmailInput().sendKeys(email);
		this.getPasswordInput().clear();
		this.getPasswordInput().sendKeys(password);
		this.getSignInButton().click();
	}
	
	public void signOutButtonClick () {
		this.getSignOutButton().click();
	}
	
	public void myAddressesClick () {
		this.getMyAddressesPage().click();
	}
	
	public void myPersonalInfoClick () {
		this.getMyPersonalInfo().click();
	}
	
	public void myWishlistsClick () {
		this.getMyWishlists().click();
	}
	
	public void homeButtonClick () {
		this.getHomeButton().click();
	}

}

package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import pages.AddressesPage;
import pages.HomePage;
import pages.IdentityPage;
import pages.MyAccountPage;
import pages.MyWishlistPage;
import pages.OrderPage;


public class TestBase {
	WebDriver driver;
	HomePage homePage;
	MyAccountPage myAccountPage;
	AddressesPage addressesPage;
	ExcelReader excelReader;
	IdentityPage identityPage;
	MyWishlistPage myWishlistPage;
	OrderPage orderPage;
	
	//LOGIN
	public void login (String email, String password) {
		homePage.signInTabClick();
		myAccountPage.login(email, password);
	}
	
	public void successfulLogin() throws InterruptedException {
		String email = excelReader.getCellData("Login", 6, 4);
		String password = excelReader.getCellData("Login", 7, 4);
		login(email, password);
		Thread.sleep(2000);
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");

		this.driver = new ChromeDriver();
		this.homePage = new HomePage (driver);
		this.myAccountPage = new MyAccountPage (driver);
		this.addressesPage = new AddressesPage (driver);
		this.excelReader = new ExcelReader ("data\\data.xlsx");
		this.identityPage = new IdentityPage (driver);
		this.myWishlistPage = new MyWishlistPage (driver);
		this.orderPage = new OrderPage (driver);

		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void afterClass() throws IOException {
		driver.close();
		excelReader.fis.close();
	}
}

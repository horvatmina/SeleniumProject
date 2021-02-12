package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends TestBase {
	
	@Test (priority = 0)
	public void logInValidCredentials () throws InterruptedException {	
		successfulLogin ();
		String expectedText = excelReader.getCellData("Login", 8, 4);
		String actualText = myAccountPage.getWelcomeMessage().getText();
		Assert.assertEquals(actualText, expectedText);
	} 
	
	@Test (priority = 5)
	public void wrongEmail () throws InterruptedException {	
		String email = excelReader.getCellData("Login", 15, 4);
		String password = excelReader.getCellData("Login", 16, 4);
		login (email, password);
		Assert.assertEquals(true, myAccountPage.getErrorMessage().isDisplayed());
	}
	
	@Test (priority = 10)
	public void wrongPassword () throws InterruptedException {	
		String email = excelReader.getCellData("Login", 24, 4);
		String password = excelReader.getCellData("Login", 25, 4);
		login (email, password);
		Assert.assertEquals(true, myAccountPage.getErrorMessage().isDisplayed());
	}
	
	@Test (priority = 15)
	public void noCredentials () throws InterruptedException {	
		String email = excelReader.getCellData("Login", 33, 4);
		String password = excelReader.getCellData("Login", 34, 4);
		login (email, password);
		Assert.assertEquals(true, myAccountPage.getErrorMessage().isDisplayed());
		//String email = "";
		//String password = "";
		//login (email, password);
	}
	
	@Test (priority = 20)
	public void signOut () throws InterruptedException {
		successfulLogin ();
		myAccountPage.signOutButtonClick();
		Assert.assertEquals(true, myAccountPage.getSignInButton().isDisplayed());
	} 
		
}

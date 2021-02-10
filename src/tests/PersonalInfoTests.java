package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonalInfoTests extends TestBase {
	
	@Test (priority = 0)
	public void editLastName () throws InterruptedException {
		successfulLogin ();
		Thread.sleep(2000);	
		myAccountPage.myPersonalInfoClick();
		String lastname = excelReader.getCellData("My Personal info", 5, 4);
		identityPage.lastName(lastname);
		String password = excelReader.getCellData("My Personal info", 6, 4);
		identityPage.password(password);
		identityPage.saveButtonClick();
		
		Assert.assertEquals(true, identityPage.getAlertMessage().isDisplayed());	
		
		identityPage.backToYourAccountClick();
		myAccountPage.myPersonalInfoClick();
		String oldlastname = excelReader.getCellData("My Personal info", 10, 4);
		identityPage.lastName(oldlastname);
		identityPage.password(password);
		identityPage.saveButtonClick();
		
		Assert.assertEquals(true, identityPage.getAlertMessage().isDisplayed());	
		
	}

}

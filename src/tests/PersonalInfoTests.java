package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonalInfoTests extends TestBase {
	String newFirstName;
	String newLastName;
	String password;
	String oldLastName;
	String oldFirstName;
	
	@Test (priority = 0)
	public void editLastName () throws InterruptedException {
		successfulLogin ();
		Thread.sleep(2000);	
		myAccountPage.myPersonalInfoClick();
		newFirstName = excelReader.getCellData("My Personal info", 5, 4);
		newLastName = excelReader.getCellData("My Personal info", 6, 4);
		password = excelReader.getCellData("My Personal info", 7, 4);
		identityPage.firstName(newFirstName);
		identityPage.lastName(newLastName);
		identityPage.password(password);
		identityPage.saveButtonClick();
		
		Assert.assertEquals(true, identityPage.getAlertMessage().isDisplayed());	
		
		identityPage.backToYourAccountClick();
		revertToOriginalInfo ();
		
	}
	
	public void revertToOriginalInfo () {
		myAccountPage.myPersonalInfoClick();
		oldFirstName = excelReader.getCellData("My Personal info", 11, 4);
		oldLastName = excelReader.getCellData("My Personal info", 12, 4);
		identityPage.firstName(oldFirstName);
		identityPage.lastName(oldLastName);
		identityPage.password(password);
		identityPage.saveButtonClick();
		
		Assert.assertEquals(true, identityPage.getAlertMessage().isDisplayed());
	}
}

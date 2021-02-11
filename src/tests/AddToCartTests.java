package tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddToCartTests extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	@Test(priority = 0)
	public void addOneProduct() throws InterruptedException {
		successfulLogin ();
		myAccountPage.homeButtonClick();
		Thread.sleep(2000);
		homePage.addToCartButtonClick();

	}
}

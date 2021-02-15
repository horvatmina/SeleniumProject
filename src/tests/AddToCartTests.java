package tests;

import org.testng.annotations.Test;

public class AddToCartTests extends TestBase {
	
	@Test(priority = 0)
	public void addOneProduct() throws InterruptedException {
		successfulLogin ();
		myAccountPage.womenTabClick();
		Thread.sleep(2000);
		categoryPage.tShirtClick();
		Thread.sleep(2000);
		categoryPage.addToCartButtonClick();
		Thread.sleep(2000);
	}
}

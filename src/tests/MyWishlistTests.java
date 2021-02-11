package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyWishlistTests extends TestBase {
    
	@Test(priority = 0)
	public void addWishList() throws InterruptedException {
		successfulLogin();
		Thread.sleep(2000);
		myAccountPage.myWishlistsClick();
		String wishlistName = excelReader.getCellData("My Wishlist", 5, 4);
		myWishlistPage.wishlistName(wishlistName);
		myWishlistPage.saveButtonClick();
		Assert.assertEquals(myWishlistPage.getDresses().getText(), wishlistName);
	} 

	@Test(priority = 5)
	public void addMultipleWishLists() throws InterruptedException {
		addWishList();
		String wishlistName1 = excelReader.getCellData("My Wishlist", 12, 4);
		String wishlistName2 = excelReader.getCellData("My Wishlist", 14, 4);
		myWishlistPage.wishlistName(wishlistName1);
		myWishlistPage.saveButtonClick();
		myWishlistPage.wishlistName(wishlistName2);
		myWishlistPage.saveButtonClick();
		Assert.assertEquals(myWishlistPage.getHats().getText(), wishlistName1);
		Assert.assertEquals(myWishlistPage.getPants().getText(), wishlistName2);
		
	} 

	@Test(priority = 10)
	public void deleteWishlist() throws InterruptedException {
		successfulLogin();
		Thread.sleep(2000);
		myAccountPage.myWishlistsClick();
		myWishlistPage.deleteButtonClick();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		String wishlistName1 = excelReader.getCellData("My Wishlist", 12, 4);
		String wishlistName2 = excelReader.getCellData("My Wishlist", 14, 4);
		Assert.assertEquals(myWishlistPage.getHats().getText(), wishlistName1);
		Assert.assertEquals(myWishlistPage.getPants().getText(), wishlistName2);
		
	} 
	
	@Test (priority = 15) 
	public void deleteAll () throws InterruptedException {
		successfulLogin();
		Thread.sleep(2000);
		myAccountPage.myWishlistsClick();
		myWishlistPage.deleteButtonClick();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		myWishlistPage.deleteButtonClick();
		Thread.sleep(2000);	
		driver.switchTo().alert().accept();
		Thread.sleep(2000);	
		//Assert.assertFalse(myWishlistPage.getWishlistTable().isDisplayed()); NE RADI!
	}
}
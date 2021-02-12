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
		myWishlistPage.addWishlist(wishlistName);
		Assert.assertEquals(myWishlistPage.getNumberofLists(), 1);
	} 

	@Test(priority = 5)
	public void addMultipleWishLists() throws InterruptedException {
		successfulLogin();
		Thread.sleep(2000);
		myAccountPage.myWishlistsClick();
		String wishlistName1 = excelReader.getCellData("My Wishlist", 12, 4);
		String wishlistName2 = excelReader.getCellData("My Wishlist", 14, 4);
		myWishlistPage.addWishlist(wishlistName1);
		Thread.sleep(2000);
		myWishlistPage.addWishlist(wishlistName2);
		Thread.sleep(2000);
		Assert.assertEquals(myWishlistPage.getNumberofLists(), 3);		
	} 

	@Test(priority = 10)
	public void deleteWishlist() throws InterruptedException {
		successfulLogin();
		Thread.sleep(2000);
		myAccountPage.myWishlistsClick();
		myWishlistPage.deleteAWishlist();
		Assert.assertEquals(myWishlistPage.getNumberofLists(), 2);
		
	} 
	
	@Test (priority = 15) 
	public void deleteAll () throws InterruptedException {
		successfulLogin();
		Thread.sleep(2000);
		myAccountPage.myWishlistsClick();
		myWishlistPage.deleteAllWishlists();
		Assert.assertEquals(myWishlistPage.getNumberofLists(), 0);
		
	}
}
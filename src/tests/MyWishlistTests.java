package tests;

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
		myWishlistPage.assertTheWishlist1();
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
		myWishlistPage.assertTheWishlist2();
		myWishlistPage.assertTheWishlist3();
	}

	@Test(priority = 10)
	public void deleteWishlist() throws InterruptedException {
		successfulLogin();
		Thread.sleep(2000);
		myWishlistPage.deleteButtonClick();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		myWishlistPage.assertTheWishlist2();
	}
}
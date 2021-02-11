package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressesTests extends TestBase {


	@Test (priority = 0)
	public void successfulUpdate() throws InterruptedException {
		successfulLogin ();
		Thread.sleep(2000);

		myAccountPage.myAddressesClick();
		addressesPage.updateButtonClick();

		String newAddress = excelReader.getCellData("My Account", 6, 4);
		String oldAddress = excelReader.getCellData("My Account", 9, 4);

		addressesPage.address1(newAddress);
		Thread.sleep(2000);
		addressesPage.saveButtonClick();

		Assert.assertEquals(addressesPage.getCurrentAddressName().getText(), newAddress);

		addressesPage.updateButtonClick();
		addressesPage.address1(oldAddress);
		addressesPage.saveButtonClick();

		Assert.assertEquals(addressesPage.getCurrentAddressName().getText(), oldAddress);
	} 

	@Test (priority = 5)
	public void addAddress() throws InterruptedException {
		successfulLogin ();
		Thread.sleep(2000);

		myAccountPage.myAddressesClick();
		addressesPage.addNewAddressClick();
		Thread.sleep(2000);

		String address = excelReader.getCellData("My Account", 17, 4);
		String city = excelReader.getCellData("My Account", 18, 4);
		String zip = excelReader.getCellData("My Account", 20, 4);
		String phone = excelReader.getCellData("My Account", 22, 4);
		String addressTitle = excelReader.getCellData("My Account", 23, 4);
		
		addressesPage.address1(address);
		addressesPage.city(city);
		addressesPage.chooseState(1); 
		Thread.sleep(2000);
		addressesPage.zip(zip);
		addressesPage.phone(phone);
		addressesPage.addressTitle(addressTitle);
		Thread.sleep(2000);
		addressesPage.saveButtonClick();
			
		Assert.assertEquals(addressesPage.getSecondAddressTitle().getText(), addressTitle);
	} 
	
	@Test (priority = 10)
	public void deleteAddress () throws InterruptedException {
		successfulLogin ();
		Thread.sleep(2000);
		
		myAccountPage.myAddressesClick();
		addressesPage.deleteButtonClick();
		driver.switchTo().alert().accept();
		
		String address = excelReader.getCellData("My Account", 31, 4);
		Assert.assertEquals(addressesPage.getCurrentAddressTitle().getText(), address);	
	} 
}

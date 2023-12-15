package com.qa.testCasesTn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.testBase.TestBase;
import com.tn.qa.Utilities.Util;
import com.tn.qa.pages.AddtoCartPage;
import com.tn.qa.pages.CheckOutPage;
import com.tn.qa.pages.CheckOut_GuestPage;
import com.tn.qa.pages.CheckOut_LoginPage;
import com.tn.qa.pages.CheckOut_RegisterPage;
import com.tn.qa.pages.HomePage;
import com.tn.qa.pages.OrderSuccessPage;
import com.tn.qa.pages.ProductInfoPage;
import com.tn.qa.pages.SearchProductPage;

public class CheckOutTest extends TestBase {

	public CheckOutTest() throws Exception {
		super();		
	}

	public WebDriver driver;
    public HomePage homepage;
    SearchProductPage searchproductpage;
    ProductInfoPage  productinfopage;
    CheckOutPage checkoutpage;
    CheckOut_RegisterPage checkoutregisterpage;
    CheckOut_GuestPage checkoutguestpage;
    OrderSuccessPage ordersuccesspage;
    CheckOut_LoginPage checkoutloginpage;
    
	@BeforeMethod
	public void setup() throws Exception {
		driver=initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage= new HomePage(driver);
		homepage.enterProductDetail(dataProp.getProperty("validProduct"));
		searchproductpage= homepage.clickOnSearchIcon();
		Assert.assertTrue(searchproductpage.verifyDisplayStatusOfValidProduct());
		productinfopage= searchproductpage.clickOnAddtoCart(); 
		productinfopage.clickOnAddtoCartinProductInfopage();
		Thread.sleep(2000);
		AddtoCartPage addtocartpage = new AddtoCartPage(driver);
		Assert.assertTrue(addtocartpage.varifyMessageofProductAddedDisplayed());
		Thread.sleep(2000);
		addtocartpage.clickOnCheckout();
		
	}
		
	@Test(priority=1)
	public void checkoutAsNewUser() throws Exception {
		checkoutpage= new CheckOutPage(driver);
		Assert.assertTrue (checkoutpage.getStatusofCheckoutOptionsDisplayed());	
		checkoutpage.clickOnRegisterOptionforCheckout();
		Thread.sleep(1000);
		checkoutpage.clickOnContinueRegisterButton();
		Thread.sleep(1000);
		checkoutregisterpage= new CheckOut_RegisterPage(driver);
		checkoutregisterpage.enterPersonalDetailFieldDisplayed();
		checkoutregisterpage.enterBasicDetails(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),Util.emailWithDateTimeStamp(),
		dataProp.getProperty("mobile"), prop.getProperty("validPassword"), prop.getProperty("validPassword"),dataProp.getProperty("address1"),
		dataProp.getProperty("address2"),dataProp.getProperty ("city"),dataProp.getProperty ("postcode"));
		Select select = new Select(checkoutregisterpage.enterCountry());
		select.selectByVisibleText(dataProp.getProperty ("country"));
		Select select1 = new Select(checkoutregisterpage.enterZone());
		select1.selectByVisibleText(dataProp.getProperty ("zone"));
		checkoutregisterpage.navigateToOrderInfoSection();
		checkoutregisterpage.getStatusofOrderInfoDisplayed();
		OrderSuccessPage ordersuccesspage= checkoutregisterpage.clickOnConfirmOrder();
		ordersuccesspage.getStatusofOrderInfo(dataProp.getProperty("orderSuccessMessage"));
		homepage = ordersuccesspage.clickOnContinueOrderSuccess();
		Assert.assertTrue(homepage.displayOFHomePage());	}
	
	
	@Test(priority=2)
	public void checkOutAsGuestUser() throws Exception {
		checkoutpage= new CheckOutPage(driver);
		checkoutpage.clickOnGuestUserforCheckout();
		checkoutpage.clickOnContinueRegisterButton();
		CheckOut_GuestPage checkoutguestpage = new CheckOut_GuestPage(driver);
		checkoutguestpage.enterBasicDetails(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),Util.emailWithDateTimeStamp(),
		dataProp.getProperty("mobile"),dataProp.getProperty("address1"),
		dataProp.getProperty("address2"),dataProp.getProperty ("city"),	dataProp.getProperty ("postcode"));
		Select select = new Select(checkoutguestpage.enterCountry());
		select.selectByVisibleText(dataProp.getProperty ("country"));
		Select select1 = new Select(checkoutguestpage.enterZone());
		select1.selectByVisibleText(dataProp.getProperty ("zone"));
		checkoutguestpage.navigateToOrderInfoSection();
		Assert.assertTrue(checkoutguestpage.getStatusofOrderInfoDisplayed());
		ordersuccesspage =	checkoutguestpage.clickOnConfirmOrder();
		ordersuccesspage.getStatusofOrderInfo(dataProp.getProperty("orderSuccessMessage"));
		homepage = ordersuccesspage.clickOnContinueOrderSuccess();
		Assert.assertTrue(homepage.displayOFHomePage());
			
	}
	
	
	@Test(priority=3)
	public void checkOutAsExistingUser() throws Exception {
		 checkoutpage= new CheckOutPage(driver);
		 Assert.assertTrue(checkoutpage.getStatusOfReturningOptionDisplayed());
		 checkoutpage.enterEmailForLogin(prop.getProperty("validEmail"));
		 checkoutpage.enterPasswordForLogin(prop.getProperty("validPassword"));
		 CheckOut_LoginPage checkoutloginpage=  checkoutpage.clickOnLoginForCheckOutButton();
		 checkoutloginpage.getBillingDetailsDisplayed();
		 checkoutloginpage.clickOnNewBillingAddressOption();
		 checkoutloginpage.clickOnBillingAddressContinue();
         checkoutloginpage.enterBasicDetails(dataProp.getProperty("firstName"),dataProp.getProperty("lastName"),
         dataProp.getProperty("address1"),dataProp.getProperty("address2"),dataProp.getProperty ("city"),dataProp.getProperty ("postcode"));
		 Select select = new Select(checkoutloginpage.enterCountry());
		 select.selectByVisibleText(dataProp.getProperty ("country"));
		 Select select1 = new Select(checkoutloginpage.enterZone());
		 select1.selectByVisibleText(dataProp.getProperty ("zone"));
		 checkoutloginpage.navigateToOrderInfoSection();
		 Assert.assertTrue(checkoutloginpage.getStatusofOrderInfoDisplayed());
		 ordersuccesspage =	checkoutloginpage.clickOnConfirmOrder();
		 ordersuccesspage.getStatusofOrderInfo(dataProp.getProperty("orderSuccessMessage"));
		 homepage = ordersuccesspage.clickOnContinueOrderSuccess();
		 Assert.assertTrue(homepage.displayOFHomePage());
		 Thread.sleep(2000);
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
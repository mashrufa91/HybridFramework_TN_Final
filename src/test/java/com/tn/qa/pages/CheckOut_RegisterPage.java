package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckOut_RegisterPage {

public WebDriver driver;

@FindBy(partialLinkText= "Account & Billing Details")
private WebElement accountAndBillingDetailText;


@FindBy(xpath="//fieldset[contains(@id, 'account')]/descendant::legend[text()='Your Personal Details']")
private WebElement registerAccountfield;

@FindBy(id="input-payment-firstname")
private WebElement checkoutFirstname;

@FindBy(id="input-payment-lastname")
private WebElement checkoutLastname;
@FindBy(id="input-payment-email")
private WebElement checkoutEmail;

@FindBy(id="input-payment-telephone")
private WebElement checkoutTelephone;

@FindBy(id="input-payment-password")
private WebElement checkOutPassword;

@FindBy(id="input-payment-confirm")
private WebElement checkoutConfirmPassword;

@FindBy(id="input-payment-address-1")
private WebElement address1TextBox;

@FindBy(id="input-payment-address-2")
private WebElement address2TextBox;
@FindBy(id="input-payment-city")
private WebElement cityTextBox;
@FindBy(id="input-payment-postcode")
private WebElement postcodeTextBox;
@FindBy(id="input-payment-country")
private WebElement countryTextBox;

@FindBy(id="input-payment-zone")
private WebElement zoneTextBox;

@FindBy(name="agree")
private WebElement privacyPolicyagreeButton;

@FindBy(id="button-register")
private WebElement continuRegister;

@FindBy(xpath="//div/descendant::input[@name='shipping_address' and @value='existing']")
private WebElement deliveryDetails;

@FindBy(xpath="//input[contains(@id,'button-shipping')]")
private WebElement continueDeliveryDetail;


//@FindBy(xpath="//input[contains(@name,'shipping_method')]")
//private WebElement DeliveryMethod;

@FindBy(xpath="//input[@id ='button-shipping-method'and @value='Continue']")
private WebElement continueDeliverymethod;

@FindBy(partialLinkText="Payment Method")
private WebElement getStatusofPaymentmethod;

@FindBy(xpath="//input[@name='payment_method']")
private WebElement paymentMethod;

@FindBy(xpath="//input[@name='agree']")
private WebElement paymentMethodTandCAgree;

@FindBy(xpath="//input[@id='button-payment-method']")
private WebElement paymentMethodContinue;

@FindBy(partialLinkText="Confirm Order")
private WebElement Confirmorderstatus;

@FindBy(xpath="//div[@class='table-responsive']")
private WebElement statusOfOrderInfo;

@FindBy(xpath="//input[@id='button-confirm']")
private WebElement confirmOrder;



public CheckOut_RegisterPage(WebDriver driver) {
	
	this.driver= driver;
	PageFactory.initElements(driver, this);
}

public boolean enterPersonalDetailFieldDisplayed() {
	
	boolean PersonalDetailFieldDisplayed=registerAccountfield.isDisplayed();
	return PersonalDetailFieldDisplayed;
	}
public void enterFirstName(String firstnametext) {
	checkoutFirstname.sendKeys(firstnametext);
}

public void enterLastName(String lastnametext) {
	checkoutLastname.sendKeys(lastnametext);}

public void enterEmail(String emailtext) {
	checkoutEmail.sendKeys(emailtext);
}

public void enterTelephone(String telephonetext) {
	checkoutTelephone.sendKeys(telephonetext);
}

public void enterPassword(String passwordtext) {
	checkOutPassword.sendKeys(passwordtext);
}

public void enterConfirmPassword(String confirmpasswordtext) {
	checkoutConfirmPassword.sendKeys(confirmpasswordtext);
}
public void enterAddress1(String address1text) {
	address1TextBox.sendKeys(address1text);
}	
public void enterAddress2(String address2text) {
	address2TextBox.sendKeys(address2text);
}	
public void enterCity(String cityText) {
	cityTextBox.sendKeys(cityText);
}	
public void enterPostCode(String postCodeText) {
	postcodeTextBox.sendKeys(postCodeText);
}	
public WebElement enterCountry() {
WebElement countryNames= countryTextBox;
	return countryNames;
	
}	
public WebElement enterZone() {
WebElement zoneNames= zoneTextBox;
	return zoneNames;	
}	
public void clickOnagree() {
	privacyPolicyagreeButton.click();	
}	

public void clickOnContinueRegister() {
	continuRegister.click();	
}
public void clickOnpreferedDeliverydetail() {
	deliveryDetails.click();
	
}
public void clickOnContinueDeliverydetail() {
continueDeliveryDetail.click();
}
public void clickOnContinueDeliveryMethod() {
continueDeliverymethod.click();
}
public void clickOnContinuePaymentTandCAgree() {
	paymentMethodTandCAgree.click();
}
public void clickOnContinuePaymentMethod() {
	paymentMethodContinue.click();
}
public void navigateToOrderInfoSection() {
	
privacyPolicyagreeButton.click();
	
continuRegister.click();
			
//deliveryDetails.click();
	
continueDeliveryDetail.click();

continueDeliverymethod.click();	

paymentMethodTandCAgree.click();

paymentMethodContinue.click();
	
}


public void enterBasicDetails(String firstnametext,String lastnametext, String emailtext,String telephonetext, String passwordtext,String confirmpasswordtext,String address1text, String address2text, 
		String cityText,String postCodeText) {
		checkoutFirstname.sendKeys(firstnametext);
	
		checkoutLastname.sendKeys(lastnametext);
	
		checkoutEmail.sendKeys(emailtext);
	
     	checkoutTelephone.sendKeys(telephonetext);
	
		checkOutPassword.sendKeys(passwordtext);
	
		checkoutConfirmPassword.sendKeys(confirmpasswordtext);
		
		address1TextBox.sendKeys(address1text);
	
		address2TextBox.sendKeys(address2text);
	
		cityTextBox.sendKeys(cityText);
	
		postcodeTextBox.sendKeys(postCodeText);
		}
	
public boolean getStatusofOrderInfoDisplayed() {
	boolean displayOrderInfoStatus= statusOfOrderInfo.isDisplayed();
	return displayOrderInfoStatus;}

public OrderSuccessPage clickOnConfirmOrder() {
	confirmOrder.click();
	return new OrderSuccessPage(driver);
}
}


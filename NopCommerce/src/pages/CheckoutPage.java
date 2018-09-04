package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

	// Selectores utilizados en el primer test.
	@FindBy(how = How.CSS, using = "div.billing-info li.name")
	private WebElement checkoutDataName;

	@FindBy(how = How.CSS, using = "li:nth-child(1) div.payment-details label")
	private WebElement textCheckMethodCash;

	@FindBy(how = How.CSS, using = "li:nth-child(2) div.payment-details label")
	private WebElement textCheckMethodCredit;

	@FindBy(how = How.CSS, using = "#shipping-buttons-container p a")
	private WebElement btnBackInShipping;

	@FindBy(how = How.CSS, using = " button[title=\"Close\"]")
	private WebElement closeWindows;

	@FindBy(how = How.CSS, using = "#terms-of-service-warning-box p")
	private WebElement errorWindows;

	@FindBy(how = How.XPATH, using = "//*[@id=\"termsofservice\"]")
	private WebElement termsOfService;

	@FindBy(how = How.XPATH, using = "//*[@id=\"checkout\"]")
	private WebElement btnCheckout;

	@FindBy(how = How.CSS, using = "input.button-1.checkout-as-guest-button")
	private WebElement btnAsGuest;

	@FindBy(how = How.CSS, using = "#ShipToSameAddress")
	private WebElement sameAddress;

	@FindBy(how = How.ID, using = "BillingNewAddress_FirstName")
	private WebElement firstName;

	@FindBy(how = How.ID, using = "BillingNewAddress_LastName")
	private WebElement lastName;

	@FindBy(how = How.ID, using = "BillingNewAddress_Email")
	private WebElement email;

	@FindBy(how = How.ID, using = "BillingNewAddress_City")
	private WebElement city;

	@FindBy(how = How.ID, using = "BillingNewAddress_Address1")
	private WebElement address1;

	@FindBy(how = How.ID, using = "BillingNewAddress_ZipPostalCode")
	private WebElement postalCode;

	@FindBy(how = How.ID, using = "BillingNewAddress_PhoneNumber")
	private WebElement phoneNumber;

	@FindBy(how = How.XPATH, using = "//*[@id=\"BillingNewAddress_CountryId\"]")
	private WebElement countryField;

	@FindBy(how = How.CSS, using = "#BillingNewAddress_CountryId option:nth-child(2)")
	private WebElement unitedStates;

	@FindBy(how = How.XPATH, using = "//*[@id=\"BillingNewAddress_StateProvinceId\"]")
	private WebElement statesField;

	@FindBy(how = How.CSS, using = "#BillingNewAddress_StateProvinceId option:nth-child(2)")
	private WebElement armedForcesAmericas;

	@FindBy(how = How.CSS, using = "#billing-buttons-container input")
	private WebElement btnContinueBilling;

	@FindBy(how = How.CSS, using = "#shipping-buttons-container input")
	private WebElement btnContinueShipping;

	@FindBy(how = How.CSS, using = "#payment-method-buttons-container input")
	private WebElement btnContinuePay;

	@FindBy(how = How.CSS, using = "#payment-info-buttons-container input")
	private WebElement btnContinuePayment;

	@FindBy(how = How.CSS, using = "#confirm-order-buttons-container input")
	private WebElement confirmOrder;

	@FindBy(how = How.CSS, using = "div.page-body.checkout-data div.title strong")
	private WebElement correctMessage;

	@FindBy(how = How.CSS, using = "div.details-link a")
	private WebElement orderDetails;

	@FindBy(how = How.CSS, using = "div:nth-child(1) div.details a")
	private WebElement productSearch;

	// Selectores utilizados en el segundo test.
	@FindBy(how = How.ID, using = "paymentmethod_1")
	private WebElement payCredit;

	@FindBy(how = How.XPATH, using = "//*[@id=\"billing-address-select\"]")
	private WebElement sameAddressField;

	@FindBy(how = How.CSS, using = "#billing-address-select option:nth-child(2)")
	private WebElement newAddress;

	@FindBy(how = How.ID, using = "CardholderName")
	private WebElement cardholderName;

	@FindBy(how = How.ID, using = "CardNumber")
	private WebElement cardNumber;

	@FindBy(how = How.ID, using = "ExpireMonth")
	private WebElement expireMonth;

	@FindBy(how = How.CSS, using = "#ExpireMonth option:nth-child(12)")
	private WebElement month12;

	@FindBy(how = How.ID, using = "CardCode")
	private WebElement cardCode;

	@FindBy(how = How.CSS, using = "#payment-info-buttons-container input")
	private WebElement continueCredit;

	// Metodos utilizados para el primer test.
	public String getCheckoutDataName() {
		customWait.until(ExpectedConditions.visibilityOf(checkoutDataName));
		return checkoutDataName.getText();
	}

	public String getTextCashMethod() {
		customWait.until(ExpectedConditions.visibilityOf(textCheckMethodCash));
		return textCheckMethodCash.getText();
	}

	public boolean getBackButtonPresent() {
		customWait.until(ExpectedConditions.visibilityOf(btnBackInShipping));
		return btnBackInShipping.isDisplayed();
	}

	public boolean getTextMessage() {
		customWait.until(ExpectedConditions.visibilityOf(correctMessage));
		return correctMessage.isDisplayed();
	}

	public void clickConfirmOrder() {
		customWait.until(ExpectedConditions.elementToBeClickable(confirmOrder));
		confirmOrder.click();
	}

	public void clickContinuePayment() {
		customWait.until(ExpectedConditions.elementToBeClickable(btnContinuePayment));
		btnContinuePayment.click();
	}

	public void clickContinuePay() {
		customWait.until(ExpectedConditions.elementToBeClickable(btnContinuePay));
		btnContinuePay.click();
	}

	public void clickContinueShipping() {
		customWait.until(ExpectedConditions.elementToBeClickable(btnContinueShipping));
		btnContinueShipping.click();
	}

	public void clickContinueBilling() {
		customWait.until(ExpectedConditions.elementToBeClickable(btnContinueBilling));
		btnContinueBilling.click();
	}

	public void selectStates() {
		customWait.until(ExpectedConditions.elementToBeClickable(statesField));
		statesField.click();
		customWait.until(ExpectedConditions.elementToBeClickable(armedForcesAmericas));
		armedForcesAmericas.click();
	}

	public void selectCountry() {
		customWait.until(ExpectedConditions.elementToBeClickable(countryField));
		countryField.click();
		customWait.until(ExpectedConditions.elementToBeClickable(unitedStates));
		unitedStates.click();
	}

	public void fillFirstName(String fname) {
		customWait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.click();
		firstName.clear();
		firstName.sendKeys(fname);
	}

	public void fillLastName(String lname) {
		customWait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.click();
		lastName.clear();
		lastName.sendKeys(lname);
	}

	public void fillEmail(String mail) {
		customWait.until(ExpectedConditions.elementToBeClickable(email));
		email.click();
		email.clear();
		email.sendKeys(mail);
	}

	public void fillCity(String cities) {
		customWait.until(ExpectedConditions.elementToBeClickable(city));
		city.click();
		city.clear();
		city.sendKeys(cities);
	}

	public void fillAddressUno(String address) {
		customWait.until(ExpectedConditions.elementToBeClickable(address1));
		address1.click();
		address1.clear();
		address1.sendKeys(address);
	}

	public void fillPostalCode(String pcode) {
		customWait.until(ExpectedConditions.elementToBeClickable(postalCode));
		postalCode.click();
		postalCode.clear();
		postalCode.sendKeys(pcode);
	}

	public void fillPhoneNumber(String phone) {
		customWait.until(ExpectedConditions.elementToBeClickable(phoneNumber));
		phoneNumber.click();
		phoneNumber.clear();
		phoneNumber.sendKeys(phone);
	}

	public void clickSameAdress() {
		customWait.until(ExpectedConditions.elementToBeClickable(sameAddress));
		sameAddress.click();
	}

	public void loginAsGuest() {
		customWait.until(ExpectedConditions.elementToBeClickable(btnAsGuest));
		btnAsGuest.click();
	}

	public void clickCheckout() {
		customWait.until(ExpectedConditions.elementToBeClickable(btnCheckout));
		btnCheckout.click();
	}

	public void clickAcceptTerms() {
		customWait.until(ExpectedConditions.elementToBeClickable(termsOfService));
		termsOfService.click();
	}

	public void addToCart(int i) {
		WebElement elem = driver
				.findElement(By.cssSelector(".item-box:nth-child(" + i + ") .product-box-add-to-cart-button"));
		customWait.until(ExpectedConditions.elementToBeClickable(elem));
		elem.click();
	}

	public void clickCloseWindowsError() {
		customWait.until(ExpectedConditions.elementToBeClickable(closeWindows));
		closeWindows.click();
	}

	public String getMessageErrorWindows() {
		customWait.until(ExpectedConditions.visibilityOf(errorWindows));

		return errorWindows.getText();
	}

	// Metodos utilizados para el segundo test.

	public String getTextCreditMethod() {
		customWait.until(ExpectedConditions.visibilityOf(textCheckMethodCredit));
		return textCheckMethodCredit.getText();
	}

	public void clickContinueCreditMethod() {
		customWait.until(ExpectedConditions.elementToBeClickable(continueCredit));
		continueCredit.click();
	}

	public void creditFillName(String cardName) {
		customWait.until(ExpectedConditions.elementToBeClickable(cardholderName));
		cardholderName.click();
		cardholderName.clear();
		cardholderName.sendKeys(cardName);
	}

	public void creditFillCardNumber(String numberCard) {
		customWait.until(ExpectedConditions.elementToBeClickable(cardNumber));
		cardNumber.click();
		cardNumber.clear();
		cardNumber.sendKeys(numberCard);
	}

	public void creditFillExpireMonth() {
		customWait.until(ExpectedConditions.elementToBeClickable(expireMonth));
		expireMonth.click();
		customWait.until(ExpectedConditions.elementToBeClickable(month12));
		month12.click();
	}

	public void creditFillCardCode(String ccode) {
		customWait.until(ExpectedConditions.elementToBeClickable(cardCode));
		cardCode.click();
		cardCode.clear();
		cardCode.sendKeys(ccode);
	}

	public void selectNewAddress() {
		customWait.until(ExpectedConditions.elementToBeClickable(sameAddressField));
		sameAddressField.click();
		customWait.until(ExpectedConditions.elementToBeClickable(newAddress));
		newAddress.click();
	}

	public void clickCredit() {
		customWait.until(ExpectedConditions.elementToBeClickable(payCredit));
		payCredit.click();
	}

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

}

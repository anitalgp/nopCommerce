package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactUsPage extends BasePage {

	@FindBy(how = How.CSS, using = "[href=\"/contactus\"]")
	private WebElement contactUs;
	
	@FindBy(how = How.ID, using = "Email")
	private WebElement emailFiels;

	@FindBy(how = How.ID, using = "FullName")
	private WebElement fullName;

	@FindBy(how = How.ID, using = "Email")
	private WebElement emailContact;

	@FindBy(how = How.ID, using = "Enquiry")
	private WebElement enquiry;

	@FindBy(how = How.CSS, using = "form div.buttons input")
	private WebElement btnSubmit;

	@FindBy(how = How.CSS, using = "div.result")
	private WebElement massageContactUs;
	
	public boolean emailFielsVisibility() {
		customWait.until(ExpectedConditions.visibilityOf(emailFiels));
		return emailFiels.isDisplayed();
	}

	public boolean contactUsVisibility() {
		customWait.until(ExpectedConditions.visibilityOf(contactUs));
		return contactUs.isDisplayed();
	}

	public boolean successfulMassageContactUs() {
		customWait.until(ExpectedConditions.visibilityOf(massageContactUs));
		return massageContactUs.isDisplayed();
	}

	public void clickSubmit() {
		customWait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
		btnSubmit.click();
	}
	
	public boolean submitVisibility() {
		customWait.until(ExpectedConditions.visibilityOf(btnSubmit));
		return btnSubmit.isDisplayed();
	}

	public void contactUsFillName(String fName) {
		customWait.until(ExpectedConditions.elementToBeClickable(fullName));
		fullName.click();
		fullName.clear();
		fullName.sendKeys(fName);
	}
	
	public void contactUsFillEmail(String contactMail) {
		customWait.until(ExpectedConditions.elementToBeClickable(emailContact));
		emailContact.click();
		emailContact.clear();
		emailContact.sendKeys(contactMail);

	}
	
	public void contactUsFillEnquiry(String mensaje) {
		customWait.until(ExpectedConditions.elementToBeClickable(enquiry));
		enquiry.click();
		enquiry.clear();
		enquiry.sendKeys(mensaje);
	}

	public void clickContactUs() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", contactUs);
	}

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

}

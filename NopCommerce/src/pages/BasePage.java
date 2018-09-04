package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriverWait customWait;

	protected WebDriver driver;

	@FindBy(how = How.XPATH, using = "//*[@id=\"small-searchterms\"]")
	private WebElement searchStore;

	@FindBy(how = How.CSS, using = "div.header-logo")
	private WebElement logoImagen;

	@FindBy(how = How.CSS, using = "input.button-1.search-box-button")
	private WebElement btnSearch;

	@FindBy(how = How.CSS, using = "div:nth-child(1) div.details")
	private WebElement itemDetails;

	@FindBy(how = How.CSS, using = "div:nth-child(1) h2 a")
	private WebElement productText;

	@FindBy(how = How.CSS, using = "#bar-notification a")
	private WebElement notificationMessage;
	
	@FindBy(how = How.CSS, using = "div.page-title h1")
	private WebElement titlePage;
	
	public void productSearch(String product) {
		customWait.until(ExpectedConditions.elementToBeClickable(searchStore));
		searchStore.click();
		searchStore.clear();
		searchStore.sendKeys(product);
	}

	public boolean getLogo() {
		customWait.until(ExpectedConditions.visibilityOf(logoImagen));
		return logoImagen.isDisplayed();
	}

	public void clickSearch() {

		customWait.until(ExpectedConditions.elementToBeClickable(btnSearch));
		btnSearch.click();

	}

	public String getElementText() {
		customWait.until(ExpectedConditions.visibilityOf(itemDetails));
		return productText.getText();
	}
	
	public String getTextNotifications() {
		customWait.until(ExpectedConditions.visibilityOf(notificationMessage));
		return notificationMessage.getText();
	}
	
	public void clickNotifcationSuccessful() {
		
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", notificationMessage);
//		customWait.until(ExpectedConditions.elementToBeClickable(notificationMessage));
//		notificationMessage.click();
	}
	
	public String getTitlePage() {
		customWait.until(ExpectedConditions.visibilityOf(titlePage));
		return titlePage.getText();
	}

	public BasePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.customWait = new WebDriverWait(driver, 15);
	}

}

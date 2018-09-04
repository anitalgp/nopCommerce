package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ComparePage extends BasePage {

	@FindBy(how = How.CSS, using = ".item-box:nth-child(1) .add-to-compare-list-button")
	private WebElement btnCompareFirst;

	@FindBy(how = How.CSS, using = ".item-box:nth-child(2) .add-to-compare-list-button")
	private WebElement btnCompareSecond;

	@FindBy(how = How.CLASS_NAME, using = "clear-list")
	private WebElement btnCleanList;

	@FindBy(how = How.CSS, using = "tr.remove-product")
	private WebElement removeText;

	@FindBy(how = How.CSS, using = "tr.product-name td:nth-child(2)")
	private WebElement nameProductFirst;

	@FindBy(how = How.CSS, using = "tr.product-name td:nth-child(3)")
	private WebElement nameProductLast;

	@FindBy(how = How.CLASS_NAME, using = "no-data")
	private WebElement textEmpty;

	public String getTextCleanList() {
		customWait.until(ExpectedConditions.elementToBeClickable(textEmpty));
		return textEmpty.getText();
	}

	public void clickCleanList() {
		customWait.until(ExpectedConditions.elementToBeClickable(btnCleanList));
		btnCleanList.click();
	}

	public String getProductLastName() {
		customWait.until(ExpectedConditions.visibilityOf(nameProductLast));
		return nameProductLast.getText();
	}

	public String getProductFirstName() {
		customWait.until(ExpectedConditions.visibilityOf(nameProductFirst));
		return nameProductFirst.getText();
	}

	public boolean getTextRemove() {
		customWait.until(ExpectedConditions.visibilityOf(removeText));
		return removeText.isDisplayed();
	}

	public void clickAddCompareFirst() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", btnCompareFirst);
	}

	public void clickAddCompareSecond() {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", btnCompareSecond);
	}

	public ComparePage(WebDriver driver) {
		super(driver);
	}

}

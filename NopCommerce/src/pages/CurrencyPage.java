package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CurrencyPage extends BasePage {

	@FindBy(how = How.ID, using = "customerCurrency")
	private WebElement currencyForm;
	
	@FindBy(how = How.CSS, using= "#customerCurrency option:nth-child(1)")
	private WebElement dollarCurrency;
	
	@FindBy(how = How.CSS, using= "#customerCurrency option:nth-child(2)")
	private WebElement euroCurrency;
	
	@FindBy(how = How.CSS, using = "span.price.actual-price")
	private WebElement productPrice;
	
	public void selectEuroCurrency() {
		customWait.until(ExpectedConditions.elementToBeClickable(euroCurrency));
		euroCurrency.click();
	}
	
	public String getProductPrice() {
		customWait.until(ExpectedConditions.visibilityOf(productPrice));
		return productPrice.getText();
	}
	
	public void selectDollarCurrency() {
		customWait.until(ExpectedConditions.elementToBeClickable(dollarCurrency));
		dollarCurrency.click();
	}
	
	public boolean currencyVisibility() {
		customWait.until(ExpectedConditions.visibilityOf(currencyForm));
		return currencyForm.isDisplayed();
	}
	
	public void clickCurrencyForm() {
		customWait.until(ExpectedConditions.elementToBeClickable(currencyForm));
		currencyForm.click();
	}
	
	public CurrencyPage(WebDriver driver) {
		super(driver);
	}

}

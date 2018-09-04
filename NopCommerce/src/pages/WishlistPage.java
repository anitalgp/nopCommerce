package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WishlistPage extends BasePage {

	@FindBy(how = How.CSS, using = "tr:nth-child(1) td.product a")
	private WebElement productFirstName;
	
	@FindBy(how = How.CSS, using = "td.remove-from-cart input")
	private WebElement checkRemove;
	
	@FindBy(how = How.CSS, using = "td.add-to-cart input ")
	private WebElement checkAddCart;
	
	@FindBy(how = How.CSS, using = "input.button-2.update-wishlist-button")
	private WebElement btnUpdate;
	
	@FindBy(how = How.CSS, using = "div.page-body")
	private WebElement messageBody;
	
	@FindBy(how = How.CSS, using = "input.button-2.wishlist-add-to-cart-button")
	private WebElement btnAddToCart;
	
	@FindBy(how = How.CSS, using = ".item-box:nth-child(1) .add-to-wishlist-button")
	private WebElement addWishlistFirst;
	
	@FindBy(how = How.CSS, using = ".item-box:nth-child(2) .add-to-wishlist-button")
	private WebElement addWishlistSecond;
	
	@FindBy(how = How.CSS, using = "#bar-notification span")
	private WebElement closeNotification;
	
	public void closeNotification() {
		customWait.until(ExpectedConditions.elementToBeClickable(closeNotification));
		closeNotification.click();
	}
	
	public void clickAddFirstWishlist() {
		customWait.until(ExpectedConditions.elementToBeClickable(addWishlistFirst));
		addWishlistFirst.click();
	}
	
	public void clickAddSecondWishlist() {
		customWait.until(ExpectedConditions.elementToBeClickable(addWishlistSecond));
		addWishlistSecond.click();
	}
	
	public void clickWishlistAddToCart() {
		customWait.until(ExpectedConditions.elementToBeClickable(btnAddToCart));
		btnAddToCart.click();
	}
	
	public void clickCheckAddToCart() {
		customWait.until(ExpectedConditions.elementToBeClickable(checkAddCart));
		checkAddCart.click();
	}
	
	public String getBodyMessage() {
		customWait.until(ExpectedConditions.visibilityOf(messageBody));
		return messageBody.getText();
	}
	
	public void clickUpdateWishlist() {
		customWait.until(ExpectedConditions.elementToBeClickable(btnUpdate));
		btnUpdate.click();
	}
	
	public void clickRemoveWishList() {
		customWait.until(ExpectedConditions.elementToBeClickable(checkRemove));
		checkRemove.click();
	}

	public String getProductText() {
		customWait.until(ExpectedConditions.visibilityOf(productFirstName));
		return productFirstName.getText();
	}

	public WishlistPage(WebDriver driver) {
		super(driver);
	}

}

package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.BasePage;

public class BaseTest {

	protected BasePage basePage;
	
	public static final String BASE_URL = "http://demo.nopcommerce.com/";
	
	private final static String CHROME_PROPERTY = "webdriver.chrome.driver";
	
	private final static String CHROME_PATH = "drivers/chromedriver.exe";
	
	protected static WebDriver driver;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty(CHROME_PROPERTY, CHROME_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void init() {
		driver.get(BASE_URL);
	}
	
	@AfterMethod(alwaysRun = true)
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass(alwaysRun = true)
    public static void tearDown(){
        driver.close();
    }
	
}

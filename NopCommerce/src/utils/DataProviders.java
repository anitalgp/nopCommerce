package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider
	public static Object[][] searchProvider() {
		return new Object[][] {{"Digital"}, {"Lenovo"}, {"Book"}, {"Apple"}, {"HTC"}};
	}
}

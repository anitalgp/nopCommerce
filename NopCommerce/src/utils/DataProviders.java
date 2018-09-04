package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider
	public static Object[][] searchProvider() {
		return new Object[][] { { "Digital" } };
		// Se recomienda utilizar los productos: Digital, Lenovo, Book, Apple y HTC,
		// estos fueron aquellos con los que se probar los test.
	}
}

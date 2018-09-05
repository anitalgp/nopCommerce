package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import utils.DataProviders;

public class CurrencyTests extends BaseTest {

	private HomePage homePage;

	private static final String DOLLAR = "$";
	private static final String EURO = "€";

	@BeforeClass(alwaysRun = true)
	public void initPages() {
		homePage = new HomePage(driver);
	}

	@Test(groups = { "ALL", "CURRENCY" })
	public void currencyDollarTest(String product) {

		assertTrue(homePage.getLogo()); // Verifico que el logo de la empresa se encuentre desplegado en la pagina
											// inicial.
		homePage.clickCurrencyForm();
		assertTrue(homePage.currencyVisibility()); // Verifico que se encuentre efectivamente visible
														// el boton del Currency antes de utilizarlo.
		homePage.selectDollarCurrency();
		assertTrue(homePage.getProductPrice().contains(DOLLAR)); // al tomar los valores de los filtros del precio y
																		// del primer producto que arroja la busqueda.
	}

	@Test(dataProvider = "searchProvider", dataProviderClass = DataProviders.class, groups = { "ALL", "CURRENCY" })
	public void currencyEuroTest(String product) {

		assertTrue(homePage.getLogo()); // Verifico que el logo de la empresa se encuentre desplegado en la pagina
											// inicial.
		homePage.clickCurrencyForm();
		assertTrue(homePage.currencyVisibility()); // Verifico que se encuentre efectivamente visible
														// el boton del Currency antes de utilizarlo.
		homePage.selectEuroCurrency();
		assertTrue(homePage.getProductPrice().contains(EURO)); // al tomar los valores de los filtros del precio y
																	// del primer producto que arroja la busqueda.

	}

}

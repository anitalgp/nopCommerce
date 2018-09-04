package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CurrencyPage;
import utils.DataProviders;

public class CurrencyTests extends BaseTest {

	private CurrencyPage currencyPage;

	private static final String DOLLAR = "$";
	private static final String EURO = "€";

	@BeforeClass(alwaysRun = true)
	public void initPages() {
		currencyPage = new CurrencyPage(driver);
	}

	@Test(dataProvider = "searchProvider", dataProviderClass = DataProviders.class, groups = { "ALL", "CURRENCY" })
	public void currencyDollarTest(String product) {

		assertTrue(currencyPage.getLogo()); // Verifico que el logo de la empresa se encuentre desplegado en la pagina
											// inicial.
		currencyPage.clickCurrencyForm();
		assertTrue(currencyPage.currencyVisibility()); // Verifico que se encuentre efectivamente visible
														// el boton del Currency antes de utilizarlo.
		currencyPage.selectDollarCurrency();
		assertTrue(currencyPage.getProductPrice().contains(DOLLAR)); // al tomar los valores de los filtros del precio y
																		// del primer producto que arroja la busqueda.
	}

	@Test(dataProvider = "searchProvider", dataProviderClass = DataProviders.class, groups = { "ALL", "CURRENCY" })
	public void currencyEuroTest(String product) {

		assertTrue(currencyPage.getLogo()); // Verifico que el logo de la empresa se encuentre desplegado en la pagina
											// inicial.
		currencyPage.clickCurrencyForm();
		assertTrue(currencyPage.currencyVisibility()); // Verifico que se encuentre efectivamente visible
														// el boton del Currency antes de utilizarlo.
		currencyPage.selectEuroCurrency();
		assertTrue(currencyPage.getProductPrice().contains(EURO)); // al tomar los valores de los filtros del precio y
																	// del primer producto que arroja la busqueda.

	}

}

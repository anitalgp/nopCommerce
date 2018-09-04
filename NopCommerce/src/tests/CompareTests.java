package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.ComparePage;
import utils.DataProviders;

public class CompareTests extends BaseTest {

	private ComparePage comparePage;
	private static final String COMPARE_MIN = "product comparison";
	private static final String TITLE_SEARCH = "Search";
	private static final String TITLE_COMPARE_PRODUCTS = "Compare products";
	private static final String TEXT_EMPTY = "You have no items to compare.";

	@Test(dataProvider = "searchProvider", dataProviderClass = DataProviders.class, groups = { "ALL", "COMPARE" })
	public void compareProductsTest(String product) {

		assertTrue(comparePage.getLogo()); // Verifico que el logo de la empresa se encuentre desplegado en la pagina
											// inicial.

		comparePage.productSearch(product);
		comparePage.clickSearch();

		assertTrue(comparePage.getElementText().contains(product)); // Tomo la palabra del producto que utilice
																	// para buscar y
																	// la comparo con el nombre del elemento que
																	// dio como resultado
																	// para verifcar que la busqueda haya sido
																	// exitosa.
		
		assertEquals(comparePage.getTitlePage(), TITLE_SEARCH); // Verifico estar en la pagina correcta mediante el
																// titulo.
		comparePage.clickAddCompareFirst();
		
		comparePage.productSearch(product);
		comparePage.clickSearch();

		assertTrue(comparePage.getElementText().contains(product));
		
		comparePage.clickAddCompareSecond();
		assertEquals(comparePage.getTextNotifications(), COMPARE_MIN); // Comparo que el mensaje de la notificacion sea
																		// correcto.
		comparePage.clickNotifcationSuccessful();
		assertEquals(comparePage.getTitlePage(), TITLE_COMPARE_PRODUCTS); // Verifico estar en la pagina correcta
																			// mediante el titulo.

		assertTrue(comparePage.getProductFirstName().contains(product)); // Comparo por separado que los productos sean
																			// correctos acorde
		assertTrue(comparePage.getProductLastName().contains(product)); // a la busqueda realizada.
	}

	@Test(dataProvider = "searchProvider", dataProviderClass = DataProviders.class, groups = { "ALL", "COMPARE" })
	public void cleanListTest(String product) {

		assertTrue(comparePage.getLogo()); // Verifico que el logo de la empresa se encuentre desplegado en la pagina
											// inicial.

		comparePage.productSearch(product);
		comparePage.clickSearch();

		assertTrue(comparePage.getElementText().contains(product)); // Tomo la palabra del producto que utilice
																	// para buscar y
																	// la comparo con el nombre del elemento que
																	// dio como resultado
																	// para verifcar que la busqueda haya sido
																	// exitosa.
		assertEquals(comparePage.getTitlePage(), TITLE_SEARCH); // Verifico estar en la pagina correcta mediante el
																// titulo.

		comparePage.clickAddCompareFirst();
		assertEquals(comparePage.getTextNotifications(), COMPARE_MIN);
		comparePage.clickNotifcationSuccessful();
		assertEquals(comparePage.getTitlePage(), TITLE_COMPARE_PRODUCTS); // Verifico estar en la pagina correcta
																			// mediante el titulo.
		comparePage.clickCleanList();
		assertEquals(comparePage.getTextCleanList(), TEXT_EMPTY); // Verifico que la lista este vacia.
	}

	@BeforeClass(alwaysRun = true)
	public void initPages() {
		comparePage = new ComparePage(driver);
	}

}

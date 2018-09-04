package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import tests.BaseTest;
import utils.DataProviders;

public class CheckoutTests extends BaseTest {

	private static final String FNAME = "Will";
	private static final String LNAME = "Williams";
	private static final String EMAIL = "user@test.com";
	private static final String CITY = "Testing Landia";
	private static final String ADDRESS_UNO = "Testing Landia 123";
	private static final String POSTAL_CODE = "753951";
	private static final String PHONE = "+505 89547763";
	private static final String SHOPPING_CART = "shopping cart";
	private static final String TITLE_SHOPPING = "Shopping cart";
	private static final String TITLE_SING_IN = "Welcome, Please Sign In!";
	private static final String TITLE_CHECKOUT = "Checkout";
	private static final String TEXT_CASH_METHOD = "Check / Money Order";
	private static final String TEXT_CEDIT_METHOD = "Credit Card";
	private static final String CARD_NUMBER = "4506 2121 212 1212";
	private static final String CARD_CODE = "514";

	private CheckoutPage checkoutPage;

	@BeforeClass(alwaysRun = true)
	public void initPages() {
		checkoutPage = new CheckoutPage(driver);
	}

	@Test(dataProvider = "searchProvider", dataProviderClass = DataProviders.class, groups = { "ALL", "CHECKOUT" })
	public void cashTest(String product) {

		assertTrue(checkoutPage.getLogo()); // Verifico que el logo de la empresa se encuentre desplegado en la pagina
											// inicial.

		checkoutPage.productSearch(product);
		checkoutPage.clickSearch();

		assertTrue(checkoutPage.getElementText().contains(product)); // Tomo la palabra del producto que utilice
																			// para buscar y
																			// la comparo con el nombre del elemento que
																			// dio como resultado
																			// para verifcar que la busqueda haya sido
																			// exitosa.

		checkoutPage.addToCart(1);

		assertEquals(checkoutPage.getTextNotifications(), SHOPPING_CART);// Tomo el texto que contiene la notificacion
																			// de exito al
																			// agregar un elemento al carro de compras y
																			// verifico que
																			// contenga el texto que mas adelante se va
																			// a utilizar.

		checkoutPage.clickNotifcationSuccessful();

		assertEquals(checkoutPage.getTitlePage(), TITLE_SHOPPING); // Verifico que el titulo de la pagina sea correcto y
																	// por ende que
																	// el test se encuentre en la pagina correcta antes
																	// de seguir.

		checkoutPage.clickAcceptTerms();
		checkoutPage.clickCheckout();

		assertEquals(checkoutPage.getTitlePage(), TITLE_SING_IN); // Verifico que el titulo de la pagina sea correcto y
																	// por ende que
																	// el test se encuentre en la pagina correcta antes
																	// de seguir.

		checkoutPage.loginAsGuest();

		assertEquals(checkoutPage.getTitlePage(), TITLE_CHECKOUT); // Verifico que el titulo de la pagina sea correcto y
																	// por ende que
																	// el test se encuentre en la pagina correcta antes
																	// de seguir.

		checkoutPage.clickSameAdress();
		checkoutPage.fillFirstName(FNAME);
		checkoutPage.fillLastName(LNAME);
		checkoutPage.fillEmail(EMAIL);
		checkoutPage.fillCity(CITY);
		checkoutPage.fillAddressUno(ADDRESS_UNO);
		checkoutPage.fillPostalCode(POSTAL_CODE);
		checkoutPage.fillPhoneNumber(PHONE);
		checkoutPage.selectCountry(); // Selecciona opciones a fuego grabadas en los menus desplegables.
		checkoutPage.selectStates(); // Selecciona opciones a fuego grabadas en los menus desplegables.
		checkoutPage.clickContinueBilling();

		assertTrue(checkoutPage.getBackButtonPresent()); // En este caso verifico que el boton de "volver atras" se
															// encuentre visible.

		checkoutPage.clickContinueShipping();

		assertEquals(checkoutPage.getTextCashMethod(), TEXT_CASH_METHOD); // Verifico que el texto donde voy a hacer
																			// click mas adelante
																			// se encuentre de forma visible y en su
																			// lugar.

		checkoutPage.clickContinuePay();
		checkoutPage.clickContinuePayment();

		assertTrue(checkoutPage.getCheckoutDataName().contains(FNAME)); // El nombre que aparece en la "confirmas orden"
																		// debe de coincidir
																		// con el que utilice para realizar dicha orden.
		assertTrue(checkoutPage.getCheckoutDataName().contains(LNAME)); // El apellido que aparece en la "confirmas
																		// orden" debe de coincidir
																		// con el que utilice para realizar dicha orden.

		checkoutPage.clickConfirmOrder();

		assertTrue(checkoutPage.getTextMessage()); // Se verifica que el mensaje que tira la pagina luego de terminada
													// la compra sea
													// positivo o satisfactorio.
	}

	@Test(dataProvider = "searchProvider", dataProviderClass = DataProviders.class, groups = { "ALL", "CHECKOUT" })
	public void creditTest(String product) {

		assertTrue(checkoutPage.getLogo()); // Verifico que el logo de la empresa se encuentre desplegado en la pagina
											// inicial.

		checkoutPage.productSearch(product);
		checkoutPage.clickSearch();

		assertTrue(checkoutPage.getElementText().contains(product)); // Tomo la palabra del producto que utilice
																			// para buscar y
																			// la comparo con el nombre del elemento que
																			// dio como resultado
																			// para verifcar que la busqueda haya sido
																			// exitosa.

		checkoutPage.addToCart(1);

		assertEquals(checkoutPage.getTextNotifications(), SHOPPING_CART);// Tomo el texto que contiene la notificacion
																			// de exito al
																			// agregar un elemento al carro de compras y
																			// verifico que
																			// contenga el texto que mas adelante se va
																			// a utilizar.

		checkoutPage.clickNotifcationSuccessful();

		assertEquals(checkoutPage.getTitlePage(), TITLE_SHOPPING); // Verifico que el titulo de la pagina sea correcto y
																	// por ende que
																	// el test se encuentre en la pagina correcta antes
																	// de seguir.

		checkoutPage.clickAcceptTerms();
		checkoutPage.clickCheckout();

		assertEquals(checkoutPage.getTitlePage(), TITLE_SING_IN); // Verifico que el titulo de la pagina sea correcto y
																	// por ende que
																	// el test se encuentre en la pagina correcta antes
																	// de seguir.

		checkoutPage.loginAsGuest();

		assertEquals(checkoutPage.getTitlePage(), TITLE_CHECKOUT); // Verifico que el titulo de la pagina sea correcto y
																	// por ende que
																	// el test se encuentre en la pagina correcta antes
																	// de seguir.

		checkoutPage.clickSameAdress();
//		checkoutPage.selectNewAddress();
		checkoutPage.fillFirstName(FNAME);
		checkoutPage.fillLastName(LNAME);
		checkoutPage.fillEmail(EMAIL);
		checkoutPage.fillCity(CITY);
		checkoutPage.fillAddressUno(ADDRESS_UNO);
		checkoutPage.fillPostalCode(POSTAL_CODE);
		checkoutPage.fillPhoneNumber(PHONE);
		checkoutPage.selectCountry(); // Selecciona opciones a fuego grabadas en los menus desplegables.
		checkoutPage.selectStates(); // Selecciona opciones a fuego grabadas en los menus desplegables.
		checkoutPage.clickContinueBilling();

		assertTrue(checkoutPage.getBackButtonPresent()); // En este caso verifico que el boton de "volver atras" se
															// encuentre visible.

		checkoutPage.clickContinueShipping();

		assertEquals(checkoutPage.getTextCreditMethod(), TEXT_CEDIT_METHOD); // Verifico que el texto donde voy a hacer
																			// click mas adelante
																			// se encuentre de forma visible y en su
																			// lugar.
		checkoutPage.clickCredit();
		checkoutPage.clickContinuePay();

		checkoutPage.creditFillName(FNAME + LNAME);
		checkoutPage.creditFillCardNumber(CARD_NUMBER);
		checkoutPage.creditFillCardCode(CARD_CODE);
		checkoutPage.creditFillExpireMonth(); // Selecciona siempre el mes 12.
		checkoutPage.clickContinueCreditMethod();

		assertTrue(checkoutPage.getCheckoutDataName().contains(FNAME)); // El nombre que aparece en la "confirmas orden"
																		// debe de coincidir
																		// con el que utilice para realizar dicha orden.
		checkoutPage.clickConfirmOrder();

		assertTrue(checkoutPage.getTextMessage()); // Se verifica que el mensaje que tira la pagina luego de terminada
													// la compra sea
													// positivo o satisfactorio.
	}
	
	

}

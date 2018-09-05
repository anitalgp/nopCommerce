package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.WishlistPage;
import utils.DataProviders;

public class WishlistTests extends BaseTest {

	private WishlistPage wishlistPage;
	private CheckoutPage checkoutPage;

	private static final String PRODUCT = "Digital";
	private static final String WISHLIST_MAY = "Wishlist";
	private static final String WISHLIST_MIN = "wishlist";
	private static final String MESSAGE_EMPTY = "The wishlist is empty!";
	private static final String TITLE_SHOPPING = "Shopping cart";

	@Test(groups = { "ALL", "WISHLIST" })
	public void wishListTest() {

		assertTrue(wishlistPage.getLogo()); // Verifico que el logo de la empresa se encuentre desplegado en la pagina
											// inicial.

		wishlistPage.productSearch(PRODUCT);
		wishlistPage.clickSearch();

		assertTrue(wishlistPage.getElementText().contains(PRODUCT)); // Tomo la palabra del producto que utilice
																		// para buscar y
																		// la comparo con el nombre del elemento que
																		// dio como resultado
																		// para verifcar que la busqueda haya sido
																		// exitosa.
		wishlistPage.clickAddFirstWishlist();

		wishlistPage.closeNotification();
		wishlistPage.clickAddSecondWishlist();

		assertEquals(wishlistPage.getTextNotifications(), WISHLIST_MIN); // Verifico que el mensaje de la notificacion
																			// sea
																			// el adecuado.
		wishlistPage.clickNotifcationSuccessful();

		assertEquals(wishlistPage.getTitlePage(), WISHLIST_MAY); // Verifico que el titulo de la pagina sea correcto y
																	// por ende que
																	// el test se encuentre en la pagina correcta antes
																	// de seguir.

		assertTrue(wishlistPage.getProductText().contains(PRODUCT)); // Tomo la palabra del producto que utilice
																		// para buscar y
																		// la comparo con el nombre del elemento que
																		// dio como resultado
																		// para verifcar que la busqueda haya sido
																		// exitosa.

	}

	@Test(groups = { "ALL", "WISHLIST" })
	public void removeWishListTest() {

		assertTrue(wishlistPage.getLogo()); // Verifico que el logo de la empresa se encuentre desplegado en la pagina
		// inicial.

		wishlistPage.productSearch(PRODUCT);
		wishlistPage.clickSearch();

		assertTrue(wishlistPage.getElementText().contains(PRODUCT)); // Tomo la palabra del producto que utilice
		// para buscar y
		// la comparo con el nombre del elemento que
		// dio como resultado
		// para verifcar que la busqueda haya sido
		// exitosa.
		wishlistPage.clickAddFirstWishlist();

		wishlistPage.closeNotification();
		wishlistPage.clickAddSecondWishlist();

		assertEquals(wishlistPage.getTextNotifications(), WISHLIST_MIN); // Verifico que el mensaje de la notificacion
																			// sea
																			// el adecuado.

		wishlistPage.clickNotifcationSuccessful();

		assertEquals(wishlistPage.getTitlePage(), WISHLIST_MAY); // Verifico que el titulo de la pagina sea correcto y
																	// por ende que
																	// el test se encuentre en la pagina correcta antes
																	// de seguir.
		wishlistPage.clickRemoveWishList();
		wishlistPage.clickUpdateWishlist();

		assertEquals(wishlistPage.getTitlePage(), WISHLIST_MAY); // Verifico que el titulo de la pagina sea correcto y
																	// por ende que
																	// el test se encuentre en la pagina correcta antes
																	// de seguir.
		assertEquals(wishlistPage.getBodyMessage(), MESSAGE_EMPTY); // Verifico que la Wishlist se encuentre
																	// efectivamente vacia.
	}

	@Test(groups = { "ALL", "WISHLIST", "CHECKOUT" })
	public void AddShoppingCartTest() {

		assertTrue(wishlistPage.getLogo()); // Verifico que el logo de la empresa se encuentre desplegado en la pagina
											// inicial.

		wishlistPage.productSearch(PRODUCT);
		wishlistPage.clickSearch();

		assertTrue(wishlistPage.getElementText().contains(PRODUCT)); // Tomo la palabra del producto que utilice
																		// para buscar y
																		// la comparo con el nombre del elemento que
																		// dio como resultado
																		// para verifcar que la busqueda haya sido
																		// exitosa.
		wishlistPage.clickAddFirstWishlist();

		assertEquals(wishlistPage.getTextNotifications(), WISHLIST_MIN); // Verifico que el mensaje de la notificacion
																			// sea
																			// el adecuado.

		wishlistPage.clickNotifcationSuccessful();

		assertEquals(wishlistPage.getTitlePage(), WISHLIST_MAY); // Verifico que el titulo de la pagina sea correcto y
																	// por ende que
																	// el test se encuentre en la pagina correcta antes
																	// de seguir.
		wishlistPage.clickCheckAddToCart();
		wishlistPage.clickWishlistAddToCart();
		assertEquals(checkoutPage.getTitlePage(), TITLE_SHOPPING); // Verifico que el titulo de la pagina sea correcto y
																	// por ende que
																	// el test se encuentre en la pagina correcta antes
																	// de seguir.
	}

	@BeforeClass(alwaysRun = true)
	public void initPages() {
		wishlistPage = new WishlistPage(driver);
		checkoutPage = new CheckoutPage(driver);
	}
}

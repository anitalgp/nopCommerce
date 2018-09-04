package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ContactUsPage;

public class ContactUsTests extends BaseTest {

	private ContactUsPage contactUsPage;

	private static final String FNAME = "Will Williams";
	private static final String EMAIL = "user@test.com";
	private static final String MENSAJE = "Mensaje de prueba";
	private static final String CONTACT_US_TITLE = "Contact Us";

	@Test(groups = { "ALL", "CONTACT US" })
	public void contactTest() {

		assertTrue(contactUsPage.contactUsVisibility()); //Verifico que el link contact Us se encuentre visible
														// antes de utilizarlo.
		contactUsPage.clickContactUs();
		assertEquals(contactUsPage.getTitlePage(), CONTACT_US_TITLE); //Verifico que me encuentro en la pagina correcta
																	//mediante la obtencion del titulo de la pagina.
		contactUsPage.contactUsFillName(FNAME);
		assertTrue(contactUsPage.emailFielsVisibility()); //Verifico que el campo del mail se encuentre visble
														//antes de utilizarlo.
		contactUsPage.contactUsFillEmail(EMAIL);
		contactUsPage.contactUsFillEnquiry(MENSAJE);
		assertTrue(contactUsPage.submitVisibility()); //verifico que el boton de Submit este visible en su lugar
													//antes de utilizarlo.
		contactUsPage.clickSubmit();

		assertTrue(contactUsPage.successfulMassageContactUs()); //Compruebo que el mensaje sea satisfactorio.
	}
}

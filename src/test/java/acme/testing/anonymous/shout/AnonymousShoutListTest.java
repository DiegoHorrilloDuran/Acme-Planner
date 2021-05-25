package acme.testing.anonymous.shout;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;


public class AnonymousShoutListTest extends AcmePlannerTest{

	//Listing positive test case.
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/listAll.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(10)
    public void listAllShouts(final int recordIndex, final String author, final String text, final String info) {
		
		super.clickOnMenu("Anonymous", "Shouts");
		
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);
		
	}

	//Listing negative test case.
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/listAll-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void listAllNegative(final int recordIndex, final String path) {
		super.signIn("administrator", "administrator");
		super.navigateTo(path);
		super.checkErrorsExist();
		super.signOut();
	}
}

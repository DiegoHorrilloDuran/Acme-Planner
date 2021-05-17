package acme.testing.anonymous.shout;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeTest;

//Aquí vamos a testear el mostrar el listado de todas las shouts disponibles
public class AnonymousShoutListTest extends AcmeTest{
	@Override
	@BeforeAll
	public void beforeAll() {
		super.beforeAll();
		
		super.setBaseCamp("http", "localhost", "8080", "/Acme-Planner", "/master/welcome", "?language=en&debug=true");
		super.setAutoPausing(false);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/listAll.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(10)
    public void listAllShouts(final int recordIndex, final String author, final String text, final String info) {
		
		super.clickOnMenu("Anonymous", "Shouts");
		
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);
		
	}

}

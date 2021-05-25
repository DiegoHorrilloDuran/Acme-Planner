package acme.testing.anonymous.task;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;


//Aquí vamos a testear el mostrar el listado de todas las shouts disponibles
public class AnonymousTaskListTest extends AcmePlannerTest{
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/task/listAll.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(10)
    public void listAllTasks(final int recordIndex, final String title, final String start, final String end,
    	final String workload, final String description, final String privacy) {
		
	//Testeamos el list	
		
		super.clickOnMenu("Anonymous", "Tasks");
		
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, start);
		super.checkColumnHasValue(recordIndex, 2, end);
		
	
		//Testeamos el show
		
		super.clickOnListingRecord(recordIndex);
		

		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("start", start);
		super.checkInputBoxHasValue("end", end);
		super.checkInputBoxHasValue("workload", workload);
		super.checkInputBoxHasValue("description", description);
		
		
	}
	
	//Listing negative test case.
			@ParameterizedTest
			@CsvFileSource(resources = "/anonymous/task/list-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
			@Order(10)
			public void listAllNegative(final int recordIndex, final String path) {
							
				super.navigateTo(path);
				super.checkErrorsExist();
			}

}

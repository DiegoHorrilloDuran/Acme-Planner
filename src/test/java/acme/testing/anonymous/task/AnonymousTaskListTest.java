package acme.testing.anonymous.task;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;



public class AnonymousTaskListTest extends AcmePlannerTest{
	
		
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/task/listAll.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(10)
    public void listAllTasks(final int recordIndex, final String title, final String start, final String end,
    	final String workload, final String description, final String optionalLink, final String privacy) {
		
		//Listing positive test case.
		
		super.clickOnMenu("Anonymous", "Tasks");
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, start);
		super.checkColumnHasValue(recordIndex, 2, end);
		
	
		//Show positive test case.
		
		super.clickOnListingRecord(recordIndex);
		

		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("start", start);
		super.checkInputBoxHasValue("end", end);
		super.checkInputBoxHasValue("workload", workload);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("optionalLink", optionalLink);
		
		
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

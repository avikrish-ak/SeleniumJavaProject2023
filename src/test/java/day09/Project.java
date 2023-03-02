package day09;

import org.testng.annotations.Test;

public class Project extends Framework{

	
	@Test
	public static void testCase01() {
		reportStart("March2023");
		testCaseStart("TestCase01", "Verify Value been entered in all fields");
		browser("Chrome");
		application("https://demo.automationtesting.in/Register.html");
		typeIn("FirstName");
		typeIn("LastName");
		typeIn("Phone");
		typeIn("Email Address");
		clickIn("Gender");
		clickIn("Hobbies1");
		clickIn("Hobbies1");
		selectDropDownByIndex("Skills");
		testCaseEnd();
		reportEnd();

	}

}

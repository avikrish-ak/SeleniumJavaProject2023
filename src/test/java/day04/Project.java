package day04;

public class Project extends Framework{

	public static void main(String[] args) {
		reportStart("Feb22");
		testCaseStart("TestCase01", "Verify Value been entered in all fields");
		browser("Chrome");
		application("https://demo.automationtesting.in/Register.html");
		typeIn("//input[@placeholder='First Name']", "TestFN","FirstName");
		typeIn("//input[@placeholder='Last Name']", "TestLN","LastName");
		selectDropDownByValue("//select[@id='Skills']", "APIs","Skills");
		testCaseEnd();
		reportEnd();

	}

}

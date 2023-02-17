package day02;

public class Project extends Framework{

	public static void main(String[] args) {
		browser("Chrome");
		application("https://demo.automationtesting.in/Register.html");
		typeIn("//input[@placeholder='First Name']", "TestFN");
		typeIn("//input[@placeholder='Last Name']", "TestLN");
		selectDropDownByValue("//select[@id='Skills']", "APIs");

	}

}

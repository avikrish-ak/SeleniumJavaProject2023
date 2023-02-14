package day01;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Program01 {

	public static void main(String[] args) {
		
		ExtentReports report = new ExtentReports(".\\src\\test\\resources\\report\\feb14.html");
		ExtentTest test = report.startTest("TestCase01", "Verify user can able to login with valid user and password");
		test.log(LogStatus.INFO, "Open ChromeBrowser");
		test.log(LogStatus.INFO, "Open Application URL");
		test.log(LogStatus.INFO, "Enter the User Name in text box");
		test.log(LogStatus.INFO, "Enter the Password in text box");
		test.log(LogStatus.INFO, "Click Log-in");
		report.endTest(test);//saved testcases
		report.flush();//saved report
		
	}

}

package day06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Program03 {
	
	
	@DataProvider(name="login")
	public Object[][] testdata()
	{
		return new Object[][] {{"username1","password1"},
			{"username2","password2"},
			{"username3","password3"}};
	}
	
	
	
	@Test(dataProvider = "login")
	public void logIn(String username,String pwd)
	{
		System.out.println(username+"----"+pwd);
	}

}

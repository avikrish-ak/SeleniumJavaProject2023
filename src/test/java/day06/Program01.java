package day06;

import org.testng.annotations.Test;

public class Program01 {
	
	
	@Test(invocationCount = 10)
	public void testCase01()
	{
		System.out.println("Test Case");
	}

}

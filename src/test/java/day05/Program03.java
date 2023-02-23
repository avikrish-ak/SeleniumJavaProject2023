package day05;

import org.testng.annotations.Test;

public class Program03 {
	
	
	@Test(priority = 0,enabled = false)
	public void testCase02()
	{
		System.out.println("Running test2..!");
	}
	
	@Test(priority = 2)
	public void testCase01()
	{
		System.out.println("Running test1..!");
	}
	
	@Test(priority = 1)
	public void testCase03()
	{
		System.out.println("Running test3..!");
	}
	@Test(priority = 3)
	public void testCase04()
	{
		System.out.println("Running test4..!");
	}
	

}

package day06;

import org.testng.annotations.Test;

public class Program02 {
	
	@Test(groups = {"smoke"})
	public void testCase01()
	{
		System.out.println("Test Case-1");
	}
	
	@Test
	public void testCase02()
	{
		System.out.println("Test Case-2");
	}
	
	@Test(groups = {"smoke","test"})
	public void testCase03()
	{
		System.out.println("Test Case-3");
	}
	
	
	@Test
	public void testCase04()
	{
		System.out.println("Test Case-4");
	}
	
	
	@Test(groups = {"smoke"})
	public void testCase05()
	{
		System.out.println("Test Case-5");
	}

}

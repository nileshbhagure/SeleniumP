package testngintro3assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {

	//@Test
	void test_hardassertion()
	{
		System.out.println("testing...");
		System.out.println("testing...");
		
		Assert.assertEquals(1,2);  //hard assertion- rest of stmts will not execute after failure
		
		System.out.println("testing...");
		System.out.println("testing...");
	}
	
	@Test
	void test_softassertion()
	{
		System.out.println("testing...");
		System.out.println("testing...");
		
		//We access pre-defined SoftAssert class where we need to create object
		//method are not static so we need to create object for accessing the methods
		SoftAssert sa=new SoftAssert();
		
		sa.assertEquals(1,2);  // soft assertion- using object we need to execute & rest of stmts will execute after failure
		
		System.out.println("testing...");
		System.out.println("testing...");
	
	   sa.assertAll();  //End we need to add mandatory otherwise test method will always shows pass
	}
}

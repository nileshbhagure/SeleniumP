package testngintro3assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * Hard assertions
----
we can access from "Assert" class
methods are static
* if hard assertion failed then rest of the statements will not be executed.
 So assertion should be last stmt on the method 
 * 
 */
public class HardAssertion {
    
	@Test
	void test()
	{
		//Assert.assertEquals("SAI", "SAI");   //compare both string values - if equals TC-Pass else TC-Fail
	   // Assert.assertEquals(123,123);  //compare no 
	  // Assert.assertEquals("abc", 124 );  // one string one number or viceversa we can't compare
	
	//we have assertNotEquals()
		//Assert.assertNotEquals(123, 123);  //false
		//Assert.assertNotEquals(123, 456);  //true

	
		//Assert.fail();  //This will directly fail my TC
	}
}

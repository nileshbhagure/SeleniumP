package testngintro3assertion;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

/*
 Whenever we used condition stmt(if-else) internally even though Test method status got failed the Status of Testmethod shows PASSED
so in order to avoid this we used Assertion 
 Assertion - validation point
 
 So by using pre-defined class in TestNg call Assert

2 kinds of assertions
----------
1) Hard assertions
2) Soft assertions

Hard assertions
----
we can access from "Assert" class
methods are static
* if hard assertion failed then rest of the statements will not be executed.

software assertion
------
we can access though "SoftAssert" predefined class object

SoftAssert sa=new SoftAssert();
sa.assertTrue()

if soft assertion got failed then rest of the statemetns still execute.

 */
public class AssertionDemo {

	

	@Test
    void testTitle()
    {
    String exp_title="SAI";
	String act_title="SAI";
	
	//Instead of using conditional stmt we used assertion
	/*
	if(exp_title.equals(act_title))
	{
	  System.out.println("Test Passed");
    }
    else
    {
  	  System.out.println("Test Failed");

    }*/
	
	Assert.assertEquals(exp_title, act_title);
	
	/*
	//If we want to used assertion along with conditional stmt
	if(exp_title.equals(act_title))
	{
	  System.out.println("Test Passed");
	  Assert.assertTrue(true);
    }
    else
    {
  	  System.out.println("Test Failed");
      Assert.assertTrue(false);
    }
    */
    }		
	
	
	
	
}

package testngintro2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 Annotations
----
@Test     - All validation will be write at the @Test method
           - Result will be shown only of TC with @Test

@BeforeMethod - Execute before any Test method
@AfterMethod-   Execute After any Test method
  Note: this 2 annotion can be used at class level with atleast one single class 

@BeforeClass
@AfterClass
 Note: this 2 annotion can be used at class level with atleast one single class 


@BeforeTest
@AfterTest

@BeforeSuite
@AfterSuite

-----------------
TC1
@BeforeMethod - Execute before any Test method
@AfterMethod-   Execute After any Test method
----
1) Login -- @BeforeMethod
2) Search --->  @Test
3) Logout  ---@AfterMethod
4) Login
5) Adv search  ---@Test
6) Logout
 */
public class AnnotionsDemo1 
{
	@BeforeMethod
	void login()
	{
		System.out.println("This is login");
	}

    @Test(priority=1)
	void search()
	{
		System.out.println("This is search");
	}
	
    @Test(priority=2)
	void advancesearch()
	{
		System.out.println("This is advancesearch");
	}
    
    @AfterMethod
	void logout()
	{
		System.out.println("This is logout");
	}
	
}

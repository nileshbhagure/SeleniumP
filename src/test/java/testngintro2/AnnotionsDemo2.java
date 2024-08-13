package testngintro2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*

@BeforeClass- will execute only onces before starting all the test method
@AfterClass- will execute only onces after completion of the test method
            - @AfterClass is not mandatory
             - depend upon TC we can add
 Note: this 2 annotion can be used at class level with atleast one single class 

TC2
----
1) Login --- @BeforeClass
2) Search --- @Test
3) Adv search   --- @Test
4) Logout  -- -AfterClass
 */
public class AnnotionsDemo2 
{
	@BeforeClass
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
    
   @AfterClass
	void logout()
	{
		System.out.println("This is logout");
	}
	
}

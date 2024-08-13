package testngintro2_2;

import org.testng.annotations.*;

public class AllAnnotionations 
{

	@BeforeSuite
	void bs()
	{
		System.out.println("This is Before Suite...");
	}
   
   @AfterSuite
	void as()
	{
		System.out.println("This is After Suite..");
	}
	
   @BeforeTest
 	void bt()
 	{
 		System.out.println("This is Before test method");
 	}
   
   @AfterTest
	void at()
	{
		System.out.println("This is After Test method");
	}

   @BeforeClass
  	void bc()
  	{
  		System.out.println("This is Before class");
  	}

   @AfterClass
  	void ac()
  	{
  		System.out.println("This is After class");
  	}

   @BeforeMethod
  	void bm()
  	{
  		System.out.println("This is Before method");
  	}

   @AfterMethod
  	void am()
  	{
  		System.out.println("This is After Method");
  	}
   
   @Test(priority=1)
	void tm1()
	{
		System.out.println("This is Test Method1...");
	}
	
	@Test(priority=2)
	void tm2()
	{
		System.out.println("This is Test Method2...");
	}

}

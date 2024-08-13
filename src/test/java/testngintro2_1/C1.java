package testngintro2_1;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*

According to XML
 @Test- Collection of class is called Test
 Suite contains the Test-> Test contains classes-> classes contains the methods
xml
-----

<suite name="mysuite>
	<test name="mytest1>
		<classes>
			<class name="xyz"/>
		<classes>
	</test>

	<test name="mytest2>
		<classes>
			<class name="abc"/>
		<classes>
	</test>

<suite>

@BeforeTest- It will executed before every Test method started
@AfterTest-  It will executed after completion of every test
 Note: 1.this 2 annotion can be used at atleast we have 2/3 classes 
       2.If there are only Tc in each test then BeforeTest & AfterTest will execute only onces 


@BeforeSuite
@AfterSuite
 Note: this 2 annotion can be used at atleast we have 2/3 classes 


TC
@BeforeTest


 */


public class C1 
{
	@Test
	void abc()
	{
		System.out.println("This is abc from C1");
	}
	
   @BeforeTest
	void bt()
	{
		System.out.println("This is Beforetest method");
	}

}

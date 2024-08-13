package testngintro1;

import org.testng.annotations.Test;

/*
TestNG -Test New Generation. A build framework
java based unit testing tool.


Advantages:
-----
1) Test cases & test suites
2) Grouping of test cases.
3) Prioritize
4) Parameterization
5) parallel testing
6) Reports

TestNG configuration/Installation 
 2 ways
1) Install testng in eclipse as a pugin from marketplace
2) add testng library to build path / add testng dependency in pom.xml
Note: 
1.To check Testng is already install->Window->Preference
2.To install From Help menu->Eclipse Marketplace
3.After installation need to add TestNG library to the project->Right click->Properities-> Build path->select library tab->Add external library
4. Installation of plugin is mandatory from market place then either we can add testng lib from adding external lib or we can add dependency using pox.xml file

@Test   - annotation -to run the pgm  as we dont have main method

1) TestNG execute test methods based on alphabetical order.
2) @Test(priority=num)  controls the order of execution.
3) Once you provide priorty to the test methods, then order of methods(creation) is not considered.
4) priorities can be random numbers( no need to have consecutive numbers eg 1, 2, 3)
5) If you dont provide priority then default value is Zero (0).
6) If the priorities are same then again execute methods in alphabetical order.
7) Negative values are allowed in priority.
8) TestNG execute test methods only if they are having @Test annotation.

Note: 
1. We can create TestNg class by right click on pkg->TestNG->Create TestNg class
execute test cases using testng xml file

test xml file- we can run mutiple TC using xml file, generate reports
------
  2 ways we can create xml file
1) generate automatically-- select TC-> Right click-> TESTNG-> Convert to TestNg.xml
2) manually-- On Pakage right click->New File-> Filename.XML-> Add first 2 line xmlversion,doctype

Test suite--->test cases----->test steps
xml file---->classes----> Test methods

2 things achived through xml
-------
1) executed group of test cases as a 1 suite
2) we can generate testng reports ( default)

Note: for running we need Right click-> run as TestNg suite
After running xml file Refresh project-> test-output folder will be be generated for report->right click Open with->System editor
1. check emailable-report
2. check index.html

 */
public class MyfirstTC 
{
  //Tc for 1. open app 2.login 3. logout
    
	@Test(priority=1)
	void openapp()
	{
		System.out.println("opening the application");
	}
	
	@Test(priority=2)
	void login()
	{
		System.out.println("Login the application");

	}
	
	@Test(priority=3)
	void logout()
	{
		System.out.println("Logout from application");

	}
}

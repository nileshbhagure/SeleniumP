package testngintro7Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

/*
TestNG Listners: 
- Test method sometime pass, fail or skip
- Based upon the Tc execution results i need to perform action called as post-action
-eg post action
   TC pass- updation in the report as pass
   Tc fail- capture the SS & update the status in the report as fail
   TC skip- updation in the report as skip
-We can do Post Action by using TestNG listeners
- For creating the Test listners we have 3 steps:
   1) create test case
   2) create listener class
   3) create xml file and include both test case & listener class
- we need to create special class called Listners(which dont have test or java method)
  we need to implement Listners class method
  Listner class should be implemented from pre-defined interface called ITestListners
  ITestListeners interface provides method like OnTestStart(), OnTestFailure(), OnTestSkip()
 -Listener class should be implementing ITestListners interface
 
 2 ways to implement listener class
------------
Method1
------
class myListner implements ITestListener
{
}

Method2- we can extends TestListenerAdapter class same method it have which has ITestListner
-------------
class myListener extends TestListenerAdapter   
{
   we need to again override all the test method from TestListnerApdapter Class
}

-Create xml file to run

Note: Throughout the project only one listern will be there for all pkg & classes because we do same action pass/fail/skip for all the test method
 */


public class MyListners implements ITestListener
{
	public void onStart(ITestContext context) {           //before starting all the TC methods. will execute only onces
    System.out.println("Test execution is started...");
	}
	
	public void onTestStart(ITestResult result)   {   //before executing any test method it will executed every time
	    System.out.println("Test started...");
	  }
	
	public void onTestSuccess(ITestResult result) {             //whenever tc pass
	    System.out.println("Test passed...");

	}
	
	public void onTestFailure(ITestResult result) {    //whenever tc fail
	    System.out.println("Test failed...");
	  }
	public void onTestSkipped(ITestResult result) {
	    System.out.println("Test skipped...");
	  }
	
	public void onFinish(ITestContext context) {              //executed only onces when execution of all tc is finished
	    System.out.println("Test execution is completed...");
	  }
}

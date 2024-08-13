package browseroptionclassforsettingcontrol;
/*
ChromeOptions
EdgeOptions
FirefoxOptions
etc...

ChromeOptions
----------
Headless testing
-------------------------------------------------------
ChromeOptions options=new ChromeOptions();
options.addArguments("--headless=new"); 

advantages
-----
1) we can do multiple tasks( since execution happend backend)
2) faster execution

disadvantage
-----------
1) user cannot see the actions on the page. so he cannot understand flow/functionality of the test.

 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	public static void main(String[] args) {

		//creating the object of ChromeOptions
	ChromeOptions options=new ChromeOptions();
	   //passing argument --headless=new to method addArguments()
	options.addArguments("--headless=new");  //setting for headless mode of execution
	
	//passing the object of ChromeOptions to Webdriver
	WebDriver driver=new ChromeDriver(options);
	
	driver.get("https://demo.opencart.com/");
	
	String act_title=driver.getTitle();
	
	if(act_title.equals("Your Store"))
	{
		System.out.println("Test Passed");
	}
	else
	{
		System.out.println("Test Failed");
	}

	driver.quit();
	
	}

}

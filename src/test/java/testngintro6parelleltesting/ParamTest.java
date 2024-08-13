package testngintro6parelleltesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

/*
 * We can execute same Tc parellel on different browser
 
 TC
step1) created test case
step 2) create xml file then run test case through xml
step3 ) passed browser name, url as parameters from xml file to setup() method
step4 ) execute test case on chrome,firefox & Edge (serial execution- one test after one other just making another new entry )
step5 ) execute test case on chrome,firefox & edge ( parallel execution)
 */
public class ParamTest 
{
	
  WebDriver driver;
 
  @BeforeClass
  @Parameters({"browser", "url"})
  void setup(String br, String url) throws InterruptedException
  {
	 switch(br.toLowerCase())
	 {
	 case "chrome": driver=new ChromeDriver();
	       break;
	       
	 case "edge": driver=new EdgeDriver();
           break;
	 case "firefox": driver=new FirefoxDriver();
           break;  
     default: System.out.println("Invalid browser");
	       return; //will exit completely from completely method
	 }
	 
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get(url);
     driver.manage().window().maximize();
     Thread.sleep(5000);
  }

  @Test(priority=1)
  void testLogo()
  {
		boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        Assert.assertEquals(status, true);
  }
	
  @Test(priority=2)
  void testTitle()
  {
	  Assert.assertEquals(driver.getTitle(),"OrangeHRM");
  }
  
  @Test(priority=3)
  void testURL()
  {
	  Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }
  
  @AfterClass
  void tearDown()
  {
	  driver.quit();
  }
	
}

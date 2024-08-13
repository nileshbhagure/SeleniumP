package testngintro5datadriven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/*
 * DataProvider: creation of test data & returning the data
 * - Without using looping/index stmt we can used
 * -
 * 
 */
public class DataProviderDemo {

	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	
	@Test(dataProvider="dp")    //speficied the attribute
	void testLogin(String email, String pwd) throws InterruptedException
	{
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		//Thread.sleep(2000);
		boolean status=driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		if(status==true)
		{
		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
		Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		
	}
	
	
	@AfterClass
	void tearDown()
	{
		driver.close();
	}


  //Dataprovider method- creation of test data & returning the data
  //Dataprovider method always return 2 dimensional array either string or object
	@DataProvider(name="dp", indices= {0,1})     //indices= data provider will take only data of 0 & 1. Specific data we can pass
	Object loginData()
	{
		Object data[][]= {
				{"abc@gmail.com","test123"},
				{"xyz@gmail.com","test123"},
				{"pavonl123@gmail.com","test@123"},
				{"johncanedy@gmail.com","test"},		
				
		};
	     
		return data;
	}

	
	
}

package locators;
//whenever we get mutiple element first matching element in webpage it will retrive
//we used FindElement() method
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IDNameLinkTextPartialLinkText
{

	public static void main(String args[])
	{
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//open app
		driver.get("http://automationpractice.com/index.php");
	    driver.manage().window().maximize(); //maximize window
	
	    //search
	    driver.findElement(By.id("search_query_top")).sendKeys("T-shirts");
	   
	    //search button
	    driver.findElement(By.name("submit_search")).click();
	
	    //link text& partial link text- Used only for link
	    driver.findElement(By.linkText("Printed Chiffon Dress")).click();   //complete value
	    driver.findElement(By.partialLinkText("Chiffon Dress")).click();    //some value
	}
}

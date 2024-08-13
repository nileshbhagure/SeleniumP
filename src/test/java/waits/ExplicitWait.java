package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 Explicit wait
 wait on condition
------------
1.declartion: 
 after creating the web driver we need to declare
 Create the object WebDriverWait
//classname     variable   constructor(dirver instance, durations)
  WebDriverWait  mywait=new WebDriverWait()


2.usage

1) Conditional based, it will work more effectively.
2) finding element is inclusive
3) it will wait for condition to be true, the consider the time
4) we need to write multiple statements for multiple elements 


Fluent wait
------
 // Waiting 30 seconds for an element to be present on the page, checking
   // for its presence once every 5 seconds.
  

 */
public class ExplicitWait {

public static void main(String[] args) 
{
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();

//declaring explict wait
WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));

driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
/*until- function()
  ExpectedConditions-Predefined class
  visibilityOfElementLocated- condition method
  condition will be return either true or false & return element
*/
WebElement username=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
username.sendKeys("Admin");

WebElement pswd=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
pswd.sendKeys("admin123");

	}

}

package waits;


import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
Fluent wait
------
 // Waiting 30 seconds for an element to be present on the page, checking
   // for its presence once every 5 seconds.
  
 //1 declaration 
 Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
       .withTimeout(Duration.ofSeconds(30L))
       .pollingEvery(Duration.ofSeconds(5L))
       .ignoring(NoSuchElementException.class);

//2 usage
   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
     public WebElement apply(WebDriver driver) {
       return driver.findElement(By.id("foo"));
     }
   });
 */
public class FluentWaitDemo 
{

  public static void main(String[] args) {
  WebDriverManager.chromedriver().setup();	
  WebDriver driver=new ChromeDriver();	
  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  //decln
 
  FluentWait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
	       .withTimeout(Duration.ofSeconds(30L))
	       .pollingEvery(Duration.ofSeconds(5L))
	       .ignoring(NoSuchElementException.class);
  
  //usage
  //for every 5 sec it will check element 6times for 30sec duration
  WebElement username=(WebElement)mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
	     username.sendKeys("Admin");
	}	

}

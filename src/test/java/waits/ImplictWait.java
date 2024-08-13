package waits;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 implicit wait
----------
 1.should be first stmt after creation of the driver
 2.add one time- applicable for the webelement
 3.can be specify in second, milisecond, mins, hr, days  
   
Adv:
1) single time/one time statement
2) it will not wait till maximum time if the element is availble
3) Applicable for all the elements
4) easy to use

Disadvantge:
1) if the time is not suffitient then you will get exception
 */
public class ImplictWait 
{

  public static void main(String[] args) {
  WebDriverManager.chromedriver().setup();	
  WebDriver driver=new ChromeDriver();	
  
//should be first stmt after creation of the driver
  //add one time- applicable for the webelement
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   //impicit wait
  
  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  
  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	}	

}

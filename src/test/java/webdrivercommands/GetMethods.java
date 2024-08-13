package webdrivercommands;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
1)get methods
2) conditional methods
3) Browser methods
4) Navigational methods
5) wait methods

get methods  - we can these methods through webdriver instance
----------
get(url)
getTitle()
getCurrentURL()
getPageSource()
getWindowHandle()
getwindowHandles()

 */
public class GetMethods 
{

	public static void main(String[] args) throws InterruptedException 
	{
       WebDriverManager.chromedriver().setup();
       WebDriver driver=new ChromeDriver();
       
       driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       driver.manage().window().maximize();
       System.out.println(driver.getTitle());
       
       System.out.println(driver.getCurrentUrl());
       
       String ps=driver.getPageSource();
       //System.out.println(ps);
       System.out.println(ps.contains("html"));
       
       //will return single browswer window handle every time
      System.out.println(driver.getWindowHandle()); 
       
       Thread.sleep(3000);
       driver.findElement(By.linkText("OrangeHRM, Inc")).click();
       
     //will return set of window handles
       Set<String> windowis=driver.getWindowHandles();
       
       for(String s: windowis)
       {
    	   System.out.println(s);
       }
       
       driver.quit();
	}

}

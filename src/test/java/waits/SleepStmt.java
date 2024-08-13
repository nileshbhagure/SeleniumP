package waits;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 wait commands
wait statements will be used to solve synchronization problem in automation.

Thread.sleep(ms)

implicit wait
explicite wait/ fluent state

sleep() : provided by java itself( not selenium command)
------------
Adv:
1) easy to use

DisAdvantage:

1) if the time is not sufficient then you will get exception
2) it will wait of maximum time out. this will reduce the performce script.
3) multiple times we need to write
 */
public class SleepStmt {

	public static void main(String[] args) throws InterruptedException {
     WebDriverManager.chromedriver().setup();
     WebDriver driver=new ChromeDriver();
	
     Thread.sleep(5000); 
	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	 driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
	
	}

}
 
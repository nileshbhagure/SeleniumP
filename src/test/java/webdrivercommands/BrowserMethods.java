package webdrivercommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*browser methods
---------------
close() 
- close current single browser window

quit()
-close all the mutiple browser
*/
public class BrowserMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		Thread.sleep(5000);
		//driver.close(); // close single browser window
		
		driver.quit(); //all browser window
		
	}

}

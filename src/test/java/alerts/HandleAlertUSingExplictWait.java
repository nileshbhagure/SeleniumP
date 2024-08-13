package alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlertUSingExplictWait {

	public static void main(String[] args) throws InterruptedException {

			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
	        
			WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));  //Explict wait
			
			driver.get("https://the-internet.herokuapp.com/javascript_alerts");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
            Thread.sleep(2000);
			Alert myalert=mywait.until(ExpectedConditions.alertIsPresent());  //capture alertbox using explict wait
            
            myalert.accept();
	}

}

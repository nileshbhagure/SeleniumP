package slider;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GetWindowHandleDemo {

	public static void main(String[] args) {
			
			WebDriver driver=new ChromeDriver();
			driver.get("https://demo.nopcommerce.com/");
			driver.manage().window().maximize();
	
	        WebElement reg_click=driver.findElement(By.xpath("//a[normalize-space()=\"Register\"]"));
	        
	        Actions act=new Actions(driver);
	        
	        //Ctrl+Registration link
	        act.keyDown(Keys.CONTROL).click(reg_click).keyUp(Keys.CONTROL).perform();
	    
	        //Switching to registration page
	    //           passing into Array list //Return set of collection
	        //Arraylist will return list collection
	        List<String> ids=new ArrayList(driver.getWindowHandles());
	        
	        //Registration
	        driver.switchTo().window(ids.get(1));  //switch to registration page
	        driver.findElement(By.xpath("//input[@id=\"FirstName\"]")).sendKeys("Nilesh B");
	        
	        //Home page
	        driver.switchTo().window(ids.get(0)); //switching to home page
             
	        driver.findElement(By.xpath("//input[@id=\"small-searchterms\"]")).sendKeys("T-shirts");
	}

}

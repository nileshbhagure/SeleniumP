package mouseaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 right click --   contextClick(element)
 
 
  
 */
public class RightClick {

	public static void main(String[] args) throws InterruptedException {
       WebDriver driver=new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement button=driver.findElement(By.xpath("//span[normalize-space()='right click me']"));
        Actions act=new Actions(driver);
        
        //right click action
        act.contextClick(button).perform();
  	
	  //click on copy
        driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
      
        Thread.sleep(3000);
        //close on copy
        driver.switchTo().alert().accept();
	}

}

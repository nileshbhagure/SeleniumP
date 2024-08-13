package frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
iframe- showing another webpage into current page
 - external page is display into current webpage called as iframe
 - iframe does not have attribute we access with index
driver.switchTo().frame(name)
driver.switchTo().frame(id)
driver.switchTo().frame(WebElement)
driver.switchTo().frame(index)  //will use when we have only one frame

frame to frame we cannot switch. we need to come out from frame to the mainpage
driver.switchTo().defaultContent();

inner frame/nested frame- A frame within frame
-Switch frame 1 then directly switch to inner frame2
 */
public class FramesDemo {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
		driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();
		
        //frame 1
        WebElement frame1=driver.findElement(By.xpath("//frame[@src=\"frame_1.html\"]"));
	    driver.switchTo().frame(frame1);
	    driver.findElement(By.xpath("//input[@name=\"mytext1\"]")).sendKeys("Welcome");
	  
	    //frame to frame we cannot switch. we need to come out from frame to the mainpage
        driver.switchTo().defaultContent();   //goes to mainpage
	    
	   //frame 2
	   WebElement frame2=driver.findElement(By.xpath("//frame[@src=\"frame_2.html\"]"));
	   driver.switchTo().frame(frame2);
	   driver.findElement(By.xpath("//input[@name=\"mytext2\"]")).sendKeys("Automation");
	
	   driver.switchTo().defaultContent();
	   
	   //frame3
	   WebElement frame3=driver.findElement(By.xpath("//frame[@src=\"frame_3.html\"]"));
	   driver.switchTo().frame(frame3);
	   driver.findElement(By.xpath("//input[@name=\"mytext3\"]")).sendKeys("Programming");
	   
	   //switch to inner frame(part of frame3)
	   driver.switchTo().frame(0);  //Switch to inner frame. iframe does not have any attribute so we go with index 0-first frame
	   driver.findElement(By.xpath("//div[@id='i5']//div[@class='AB7Lab Id5V1']")).click();
	}

}

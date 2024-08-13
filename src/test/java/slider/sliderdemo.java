package slider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 for horizontal slider need to move only X axis  
 for vertical slider need to move only y axis 
 using below method we need handle
 dragAndDropBy(Element, x, y)
 */
public class sliderdemo 
{
	public static void main(String[] args) 
	{
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
        
		Actions act=new Actions(driver);
		// for horizontal slider we need to move only X axis  

		//Min_Slider
		WebElement min_slider=driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
		//will return location of slider
		System.out.println("Default Location of slider before moving"+min_slider.getLocation()); //(59, 249)=(x,y)    
		//method()
		act.dragAndDropBy(min_slider, 100, 249).perform();  //59+100= 159 x axis will move
	    System.out.println("Location of slider after moving "+min_slider.getLocation()); //(158, 249)
	
	    //Max_Slider
		WebElement max_slider=driver.findElement(By.xpath("//span[2]"));
		System.out.println("Default Location of slider before moving"+max_slider.getLocation()); //(510, 249)=(x,y)    
		act.dragAndDropBy(max_slider, -100, 249).perform();   //510-(-100)=410 changing only x axis
	    System.out.println("Location of slider after moving "+max_slider.getLocation()); //(410, 249)

	}
}

package mouseaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 Mouse actions
-------------
Actions - pre defined class provided in selenium 

Mouse hover --- moveToElement(element)


Mouse hover --- moveToElement(element)
right click --   contextClick(element)
double click -- doubleClick(element)
drag and drop  -- dragAndDrop(source, target)

build() - create an action
perform() - complete an action

 
 */
public class MouseOverAction {

	public static void main(String[] args) {
    WebDriver driver=new ChromeDriver();
		
	driver.get("https://demo.opencart.com/");
	driver.manage().window().maximize();
	
	WebElement desktops=driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
	WebElement mac=driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
	
	//we need to pass driver as parameter  
	Actions act=new Actions(driver);
	
	/*every method we end with build() & perform()
	//build()- create an action
	 perform()-complete the action    
      If not written then action will be not be created & completed	 
	 */
	
	//Mouse hover
	act.moveToElement(desktops).moveToElement(mac).click().build().perform();
	
	//perform()- can do create as well as complete the action 
	//we can directly used perform()
	act.moveToElement(desktops).moveToElement(mac).click().perform();
	}

}

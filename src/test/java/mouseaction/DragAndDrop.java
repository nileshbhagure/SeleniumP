package mouseaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//drag and drop  -- dragAndDrop(source, target)

public class DragAndDrop {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
	    
		Actions act=new Actions(driver);
	
		//drag&drop1
		//capturing the source element-1
	   WebElement source=driver.findElement(By.xpath("//div[@id=\"box6\"]"));
	   //capturing the target element
	   WebElement target=driver.findElement(By.xpath("//div[@id=\"box106\"]"));

	   act.dragAndDrop(source, target).perform();
	
		//drag&drop2
	   //capturing the source element -2
	   WebElement source1=driver.findElement(By.xpath("//div[@id=\"box3\"]"));
	   //capturing the target element
	   WebElement target1=driver.findElement(By.xpath("//div[@id=\"box103\"]"));
	  
	   act.dragAndDrop(source1, target1).perform();
	}

}

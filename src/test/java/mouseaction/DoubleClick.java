package mouseaction;
/*
//double click -- doubleClick(element)

getText() --> returns the inner text   --> welcome
getAttribute("id") -- returns the value of attribute ---> xyz

<input value="welcome"></input>
getAttribute("value") ---> welcome

getText() ----> returns inner text of the web element
getAttribute(attribute)--->> returns value of attribute
*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {

	public static void main(String[] args) {
       WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		//switch to frame
		driver.switchTo().frame("iframeResult");
		
		WebElement box1=driver.findElement(By.xpath("//input[@id=\"field1\"]"));
		WebElement box2=driver.findElement(By.xpath("//input[@id=\"field2\"]"));
		WebElement button=driver.findElement(By.xpath("//button[normalize-space()=\"Copy Text\"]"));

        box1.clear();  //clear box1
        box1.sendKeys("sai");
        
        //Double click action on the button
        Actions act=new Actions(driver);
        act.doubleClick(button).perform();
        
        //validation: box2 should contains "sai"
                     //  will return value of the value attribute 
        String text=box2.getAttribute("value");   //gettext() copy only when we have inner text
        System.out.println("captured value is: "+text); 
        
        if(text.equals("sai"))
        {
        	System.out.println("Text Copied");
        }
        else
        {
        	System.out.println("Text not copied properly");
        }
		
	}

}

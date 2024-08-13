package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*when we want to find mutiple web element then we used ClassName & TagName
we used FindElements() method
1) Identifying elements - Locators
2) Perform actions - Methods

Locator - Locate the web elements
findElement()
findElements()

length - arrays   a.length
lenght() - string   s.lenght()
size()- List, Set, HashMap 

findElement(loc) ----> Returntype-WebElement 
findElements(loc) ----> Returntype-List<WebElement>

Scenario1:  locator is matching with single web element.
-------
findElement(loc) ---->single webelement, Returntype:WebElement
findElements(loc)--->single webelement, Returntype:	List<WebElement>

Scenario2: locator is matching with multiple web elements
------------------
findElement(loc)---->single webelement(first webelemnt on webpage) , Returntype:WebElement
findElements(loc) ---> multiple web elements, , Returntype:List<WebElement>

Scenario3: locator is incorect ( No elements are not matching with locator)
------
findElement(loc)----> NoSuchElementException
findElements(loc)--->returns zero(No exception will be return)
*/

public class ClassNameTagName {

	public static void main(String[] args) 
	{
      WebDriver driver=new ChromeDriver();
      
      //open app
      driver.get("http://automationpractice.com/index.php");
      driver.manage().window().maximize();
      
      //finding no of slider on home page
      List<WebElement> slider=driver.findElements(By.className("homeslider-container"));
	  System.out.println("No of slider are "+slider.size());  //5
	
	  //Tagname
	  //find total no of images on home page
	  List<WebElement> images=driver.findElements(By.tagName("img"));
	  System.out.println("No of images: "+images.size());
	 
	  //find total no of link
	  List<WebElement> links=driver.findElements(By.tagName("a"));
	  System.out.println("Total no of link" +links.size());
	  
	  driver.quit();
	}

}

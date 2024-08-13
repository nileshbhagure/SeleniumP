package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleAutoSuggestionDropdown {

	public static void main(String[] args) throws InterruptedException
	{

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("selenium");
		Thread.sleep(5000);
		
		List <WebElement> list= driver.findElements(By.xpath("//ul[@role=\"listbox\"]//li//div[@role=\"option\"]"));
	    System.out.println(list.size());

	    for(int i=0; i<list.size(); i++)
	    {
	    	System.out.println(list.get(i).getText());
	    	if(list.get(i).getText().equals("selenium"))
	    			{
	    		        list.get(i).click();
	    		        break;
	    			}
	    	
	    }
	    
	}

}
package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 Dropdown box
-------------
1) select dropdown
2) Bootstrap dropdown
3) hidden drop down


select dropdown
-----------------

Select- Select Class we have in Selenium
   -These method only applicable when we have Select tag in html 
selectByVisibleText()
selectByvalue()
selectByIndex()
 */
public class HandleSelectDropDown 
{

	public static void main(String[] args) 
	{
      WebDriver driver=new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.get("https://testautomationpractice.blogspot.com");
	  driver.manage().window().maximize();
      
	  WebElement drpCountryEle=driver.findElement(By.xpath("//select[@id='country']"));
	  
	  //1. By using Select class
	  Select drpCountry=new Select(drpCountryEle);    //passing dropdown as webelement 
	
	  //select option from the drop down we have 3 method
	  //i.selectByVisibleText()
	  //drpCountry.selectByVisibleText("India");
	
	  //ii. SelectByValue()- Value is attribute of element, only when value attribute is present
	  //drpCountry.selectByValue("uk");
	  
	  //iii SelectByindex()- starts with 0
	  //drpCountry.selectByIndex(3);
	
	  //2. capture option from dropdown 
	  //getOptions() --- returns all the options from the dropdown as a WebElement.
	   List<WebElement> option= drpCountry.getOptions();
	   System.out.println("No of options in a drop down: " +option.size());  //10
	   
	  //3. Print the option
	   /*
	   for(int i=0; i<option.size(); i++)
	   {
		   System.out.println(option.get(i).getText());
	   }*/
	     
	   for(WebElement opt:option)
	   {
		   System.out.println(opt.getText());
	   }
	   
	   
	}

}

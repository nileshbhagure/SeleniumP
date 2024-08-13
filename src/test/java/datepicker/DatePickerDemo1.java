package datepicker;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo1 
{
   //selecting future day- month year date
   static void selectFutureDate(WebDriver driver,String year,String month,String date)
   {
		while(true)
		{
			String current_Month=driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText();	//return actual month
			String current_Year=driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText();	//return actual year
	        
			if(current_Month.equals(month) && current_Year.equals(year))
			{
				break;
			}
			
		 //In real appl we can either select previous or future day	
		    driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-e\"]")).click();  //Next button
		}
		
		//select the date

		List<WebElement> alldates= driver.findElements(By.xpath("//div[@id=\"ui-datepicker-div\"]//tbody//tr//td//a"));
		
		for(WebElement dt:alldates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
   }
	
    
 //selecting past day- month year date
   static void selectPastDate(WebDriver driver, String year,String month,String date)
   {
		while(true)
		{
			String current_Month=driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText();	//return actual month
			String current_Year=driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText();	//return actual year
	        
			if(current_Month.equals(month) && current_Year.equals(year))
			{
				break;
			}
			
		 //In real appl we can either select previous or future day	
		driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-w\"]")).click();  //Previous button	
		}
		
		//select the date

		List<WebElement> alldates= driver.findElements(By.xpath("//div[@id=\"ui-datepicker-div\"]//tbody//tr//td//a"));
		
		for(WebElement dt:alldates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
   }
    
	public static void main(String[] args)
{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
	
	//switch to frame
		driver.switchTo().frame(0);
		
		
	//Method1: using sendkeys()
	//driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).sendKeys("06/01/2024"); //mm-dd-yyyy
		
	//Method2: using datepicker	
	 //Target datatype should be always be string
	 //expected data
	 String year="2025";
	 String month="June";
	 String date="9";
	 driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).click();  //open datepicker
	
	 selectFutureDate(driver, year, month,date);
	 //selectPastDate(driver, year, month,date);
	
}

}

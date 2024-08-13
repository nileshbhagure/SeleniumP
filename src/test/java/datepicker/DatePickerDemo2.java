package datepicker;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDemo2 
{
	//user defined method for converting month from string--->Month (for comparing)
    //Month: Pre-defined class
	static Month convertMonth(String month) 
    {
    	HashMap<String, Month> monthMap = new HashMap<String, Month>();
       //For every month        Month Object  
        monthMap.put("January", Month.JANUARY);
        monthMap.put("February", Month.FEBRUARY);
        monthMap.put("March", Month.MARCH);
        monthMap.put("April", Month.APRIL);
        monthMap.put("May", Month.MAY);
        monthMap.put("June", Month.JUNE);
        monthMap.put("July", Month.JULY);
        monthMap.put("August", Month.AUGUST);
        monthMap.put("September", Month.SEPTEMBER);
        monthMap.put("October", Month.OCTOBER);
        monthMap.put("November", Month.NOVEMBER);
        monthMap.put("December", Month.DECEMBER);
        
        Month vmonth = monthMap.get(month);

        if (vmonth == null) {
            System.out.println("Invalid Month...");
        }

        return vmonth;
    }
    
	
	static void SelectDate(WebDriver driver, String requiredYear, String requiredMonth, String requiredDate)
	{
		//select year
				WebElement yearDropDown=driver.findElement(By.xpath("//select[@class=\"ui-datepicker-year\"]"));
			    Select selectYear=new Select(yearDropDown);
			    selectYear.selectByVisibleText(requiredYear);
			
			    //select month
			   while(true)
			   {
			   String displayMonth= driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText();
			
			  //convert requiredMonth & displayMonth in to Month object
			  Month expectedMonth=convertMonth(requiredMonth);
			  Month currentMonth=convertMonth(displayMonth);
			 
			  //compare- compare two month & return difference
			  int result=expectedMonth.compareTo(currentMonth);
			  
			  // if result 0 then month are equal
			  // if result > 0 then month is future month
			  // if result < 0 then month is past month
			  
			  if(result<0)
			  {
				  //past month
				driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-w\"]")).click();    
			  }
			  else if(result>0)
			  {
				  //future month
					driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-e\"]")).click();  

			  }
			  else
			  {
				  break;
			  }	  
		 }
			   //date selection
			  List<WebElement> allDates= driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//tr//td//a"));
			   
			  for(WebElement dt:allDates)
			  {
				if(dt.getText().equals(requiredDate))
		          {
			        dt.click();
			        break;
		           }
			  }
	}

	
	
	public static void main(String[] args)
	{

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//input DOB
		String requiredYear = "2022";
		String requiredMonth = "June";
		String requiredDate = "15";
		
		//directly pass frameid if we have id
		driver.switchTo().frame("frame-one796456169");
		//click on date_picker icon
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		
		SelectDate(driver,requiredYear,requiredMonth,requiredDate);
	   
}

}

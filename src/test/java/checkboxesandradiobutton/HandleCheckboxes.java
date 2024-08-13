package checkboxesandradiobutton;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 Check boxes 
Dropdowns
----------
1) Drop down having select tag in DOM.
2) DropDown not having select tag in DOM ( input/div) - Bootstrap dropdown
3) Auto Suggest drop down ( Dynamic)

Select class
 */
public class HandleCheckboxes {

   public static void main(String[] args) {
   WebDriverManager.chromedriver().setup();
   WebDriver driver=new ChromeDriver();
   
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   driver.get("https://testautomationpractice.blogspot.com/");	
   driver.manage().window().maximize();
   /*
   //1.select spefic one checkbox
   driver.findElement(By.xpath("//input[@id='tuesday']")).click();

   */

   //2.finding total no of xpath
   List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
   System.out.println("No of checkboxes"+checkboxes.size());
   
   //3.selecting all checkbox
   /*
   for(int i=0; i<checkboxes.size();i++)
   {
	   checkboxes.get(i).click();
   }
  */ 
 
   //using enhanced for loop
   /*
   for(WebElement chkbox:checkboxes)
   {
	   chkbox.click();
   }
  /*
   //4.slecting last 3 checkboxes
   //total no of checkboxes- how many check boxes yo want to select= starting index
	// 7-3=4 starting index
   
   for(int i=4; i<checkboxes.size();i++)
   {
	   checkboxes.get(i).click();
   }
   
   */
   //5.selecting first 3 chckboxes
   
    for(int i=0; i<3; i++)
     {
    	checkboxes.get(i).click();
     }

    //6. select/unselect the checkbox
    for(WebElement chkbox:checkboxes)
    {
    	if(chkbox.isSelected())
    	{
    		chkbox.click();  //unselect
    	}
    	else
    	{
    		chkbox.click();  //select
    	}   	
    }
    /*
    //7. selecting spefic checkbox randomly
    for(int i=0; i<checkboxes.size();i++)
    {
    	if(i==1 ||i==3 || i==6)
    	{
    		checkboxes.get(i).click();
    	}
    }
    
    //8 select checkbox based upon value
    String weekname="Sunday"; 
    switch(weekname)
    {
    case "Sunday" : driver.findElement(By.xpath("//input[@id='sunday']"));
                    break;
    case "Monday" : driver.findElement(By.xpath("//input[@id='sunday']"));
                    break;
    case "Tuesday" : driver.findElement(By.xpath("//input[@id='sunday']"));
                    break;
    case "Wednesday" : driver.findElement(By.xpath("//input[@id='sunday']"));
                    break;
    case "Thursday" : driver.findElement(By.xpath("//input[@id='sunday']"));
                    break;
    case "Friday" : driver.findElement(By.xpath("//input[@id='sunday']"));
                    break; 
    case "Saturday" : driver.findElement(By.xpath("//input[@id='sunday']"));
                    break;
    default : System.out.println("Invalid Weekname ");                        
   }
 */
}
}

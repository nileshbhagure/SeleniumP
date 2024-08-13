package handlingwebtable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable {

	public static void main(String[] args) 
	{
	
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		
        WebElement username=driver.findElement(By.xpath("//input[@id=\"input-username\"]"));
        username.clear();
        username.sendKeys("demo");
        

        WebElement password=driver.findElement(By.xpath("//input[@id=\"input-password\"]"));
        password.clear();
        password.sendKeys("demo");
        
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	
        //Close window if its available- if popup is display then only this stmt will executed
      	 if(driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed())
      		{
      		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
      		}
      		
        driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click(); //customer main menu
        driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();   //customer sub-menu
    
        //Capturing text-Showing 1 to 10 of 19081 (1909 Pages)
        String text=driver.findElement(By.xpath("//div[contains(text(),'Pages')]")).getText();
	
        //capturing totalpages- element of 1909
       int total_Page=Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
	
       //Repeating pages
       for(int p=1; p<=total_Page; p++)
       {  
    	   //first page is already display so checking from 2nd page
    	   if(p>1)
    	   {
    		                                                              //passing p as variable in xpath -dynamic page count
    		  WebElement active_page= driver.findElement(By.xpath("//ul[@class=\"pagination\"]//*[text()='+p+']"));
    		  active_page.click();
    	   }
    	   
    	   //reading data from the page
    	                                       //no of rows
      int noofRows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
      
      for(int r=1; r<=noofRows; r++)
      {
    	  String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
    	  String emailName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
    	  String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[5]")).getText();

    	  System.out.println(customerName+"\t"+emailName+"\t"+status);
      }
    	   
    	   
       }
	}

}

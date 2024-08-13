package automationbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
/*Test case
1) Launch browser
2) open url
	https://opensource-demo.orangehrmlive.com/
3) Provide username  - Admin
4) Provide password  - admin123
5) Click on Login button 
6) Verify the title of dashboard page   
	Exp title : OrangeHRM
7) close browser
 */
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangeHRMLogin {

	public static void main(String[] args) throws InterruptedException 
	{
	// manual setting by key & value                  - under value add filename.exe at the end eg chromedriver.exe
   // System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\Browser\\chromedriver-win64\\chromedriver-win64//chromedriver.exe");
	
	//after 4.6.0 - we dont need to write System.setproperty or WebDriverManager.chromedriver().setup();
     //WebDriverManager.chromedriver().setup();
     //ChromeDriver driver=new ChromeDriver();
		
	//1. launch browser
		//ChromeDriver driver=new ChromeDriver(); //will hold only chromedriver instance
		WebDriver driver=new ChromeDriver();   
       // WebDriver driver=new FirefoxDriver();	//for firefox driver	
	  //WebDriver driver=new EdgeDriver();    //for edge driver
		
		//2) open url
		driver.get("https://opensource-demo.orangehrmlive.com/\r\n");
        driver.manage().window().maximize();   //to get full windows maximize the page
		Thread.sleep(5000);
            
		//3) Provide username  - Admin
       //  WebElement txtusername= driver.findElement(By.name("username"));		
        // txtusername.sendKeys("Admin");
	      driver.findElement(By.name("username")).sendKeys("Admin");
	
	     // 4) Provide password  - admin123
	      driver.findElement(By.name("password")).sendKeys("admin1234");
	
	      //5) Click on Login button 
	      driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

	     //6) Verify the title of dashboard page   
	  	//Exp title : OrangeHRM
	       //6.1 Title validation
	    /*  String act_title=driver.getTitle();
	      String exp_title="OrangeHRM";
	      if(act_title.equals(exp_title))
	      {
	    	System.out.println("Test passed");  
	      }
	      else
	      {
	    	  System.out.println("Test fails");
	      } */
	      
	       //6.2 label validation after successfully login
          Thread.sleep(5000);
          
          String act_label="";
          String exp_label="Dashboard";
          try
          {
	      act_label=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
          }
          catch(NoSuchElementException e)
          {
          }
	      //exp_label="Dashboard";
	      if(act_label.equals(exp_label))
	      {
	    	  System.out.println("test pass");
	      }
	      else
	      {
	    	  System.out.println("test fail");

	      }
	      
	      
	      
	     // 7) close browser
        driver.close();  //close current window
	}
	

}

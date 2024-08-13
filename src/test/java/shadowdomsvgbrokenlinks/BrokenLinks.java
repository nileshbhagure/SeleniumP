package shadowdomsvgbrokenlinks;
import java.net.HttpURLConnection;
import java.net.URL;
/*
 Broken link- Which does not have any resource on server
            -Based upon status code we can check whether its has nor not any resource on server
            -If the status code>=400 it is a broken link
             else if status code <400 its not a broken link
 
 
 1) Link    href="https://xyz.com" : The link should have href atttribute

2) hit the url https://xyz.com ---> server ---> & get the status code

3)  status code>=400   broken link
 status code <400   not a broken link
 */
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks 
{

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		//1. Capture all the links from website
		List<WebElement> links= driver.findElements(By.tagName("a")); //return all the links
	    System.out.println("Total no of links" +links.size());
	
	    int noofBrokenLinks=0;
	    
	    for(WebElement linkElement:links)
	    {
	    	 String hrefattvalue=linkElement.getAttribute("href");    //catch href attribute value
	       
	    	 // Link  href="https://xyz.com" : The link should have href atttribute

	    	 if(hrefattvalue==null || hrefattvalue.isEmpty())
           {
	         System.out.println("href attribute value is null or empty. So Not possible to check");
             continue;   //skip a particular condition and continue the rest execution
           }
	    
	    	 //2 hit the url https://xyz.com ---> server ---> & get the status code
             //Send hrefattvalue to the server. Hit url to the server
	    	 //converting string to url
	       //URL & HttpURLConnection are class in java
	        try
	        {
	        	
	    	 URL linkURL=new URL(hrefattvalue); //converting hrefattvalue into url format 
	         HttpURLConnection conn=(HttpURLConnection)linkURL.openConnection();         //open connection to the server & return connection object
	         conn.connect(); //connect to server & send request to the server
	    
	          if(conn.getResponseCode()>=400);
	          {
	        	  System.out.println(hrefattvalue+"===>Broken link");
	              noofBrokenLinks++;
	          }

	          {
	        	  System.out.println(hrefattvalue+"====>Not a broken link");
	          }
	    }
	    catch(Exception e)
	    {
	    	
	    }
	}
	   System.out.println("No of broken links: "+noofBrokenLinks); 
	}
}

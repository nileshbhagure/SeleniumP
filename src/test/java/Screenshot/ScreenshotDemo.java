package Screenshot;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
  we have TakeScreenshot interface which is implemented by RemoteWebDriver class 
 * from selenium 4- we can capture SS from particular element/section
 * We can capture SS in 3 ways
 *  -1 Full page
 *   2 specific area of the page
 *   3. web element
 * 
 * 
 */
public class ScreenshotDemo {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	
		
		//1) capture full page screenshoot
	    TakesScreenshot ts=(TakesScreenshot)driver;
	    
	   //File- Predefined class in java
	    //getScreenshotAs()- method which we need to spefic the format of the file. It will return file type of object
	    //OutputType- pass the parameter, type of file
	    File sourcefile1= ts.getScreenshotAs(OutputType.FILE);
		
	    //speficying the path to store ss
	    
	    //System.getProperty("user.dir"- return current user directory(current project location)
	    //fullpage.png- file name
	    File targetfile1=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");
	    //File targetfile=new File("D:\\Eclipse pgm\\SeleniumP\\screenshots\\fullpage.png");  //static path location
	    
	    sourcefile1.renameTo(targetfile1); //copy source file to target file- as in source file we dont know where its store in memory
   
		
	    //2)capture the SS from specific area of the page
        //Difference betn 1 & 2 ways- in 2nd getScreenshot method is called from WebElement Interface where in 1st getScreenshot method is called from TakesScreenshot Interface
	 
	    WebElement feature_products=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
	    File sourcefile2=feature_products.getScreenshotAs(OutputType.FILE);
	    File targetfile2=new File(System.getProperty("user.dir")+"\\screenshots\\\\featureproducts.png");
	    sourcefile2.renameTo(targetfile2);
	
	    
	    //3) capture the screenshot of webelement
	    WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));

	    File sourcefile3=logo.getScreenshotAs(OutputType.FILE);
	    File targetfile3=new File(System.getProperty("user.dir")+"\\screenshots\\\\logo1.png");
	    sourcefile3.renameTo(targetfile3);
	    
	    
	    driver.quit();
	}

}

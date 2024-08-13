package javascriptexecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
/*Scrollbar is not part of application, Its not web element, so we cannot inspect, locate
 *Its part of Browser 
 * we can scroll in 3 different option
 * 1. we can scroll down page till its reaches some pixels number
 * 2. we can scroll down page till its reaches some element/ some element is visible
 * 3. we can scroll down page till end of the page
 * 
  //in order to handle horizontal scrollbar just change
   * pageXOffset
   * scrollWidth
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPageUsingJS {

	public static void main(String[] args) throws InterruptedException {
	    WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		//1 scroll down page by pixel
	    // 0- is default location/position
		// 1000- pixel we need to move scrollnar
	   //js.executeScript("window.scrollBy(0,1000)","");
	
	//returning the value how much pixel we move
	//window.pageYOffset- returning position of Y axis
	//System.out.println(js.executeScript("return window.pageYOffset;")); //1000
	
	//2. Scroll page till element is visible
	WebElement ele=driver.findElement(By.xpath("//strong[normalize-space()=\"Community poll\"]"));
	
	// arguments[0]- ele will be captured 
	//scrollIntoView()- scroll down into page till ele is visible onto page
	//ele- the name of element which we are looking into
	//js.executeScript("arguments[0].scrollIntoView();",ele);
	//System.out.println(js.executeScript("return window.pageYOffset;")); //1880 pixel move

	
	//3. scroll page till end of the page
	  //document.body.scrollHeight- this parement represent end of the document
	   js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
	   System.out.println(js.executeScript("return window.pageYOffset;")); //2472

	   Thread.sleep(5000);
	//scrolling up to intial position
	   js.executeScript("window.scrollBy(0,-document.body.scrollHeight)","");

	}

}

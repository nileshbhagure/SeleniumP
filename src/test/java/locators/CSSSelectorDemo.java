package locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
CSS- Cascading Style Sheets
HTML     CSS   JavaScript
eg sumbit button
driver.findElement(By.cssSelector(selector))

css selectors
-tag is optional
1.tag with id     #				
	Ex:   input#small-searchterms
		  #small-searchterms     //without tag also we can speficy


2.tag with class     .
	Ex:   input.search-box-text
 		 .search-box-text

3.tag with attribute    []
	Ex:   input[name='q']
		 [name='q']



4.tag with class & attribute    .  []

	Ex:  input.search-box-text[name='q']
		.search-box-text[name='q']

 */
public class CSSSelectorDemo
{

	public static void main(String[] args)
	{
         WebDriverManager.chromedriver().setup();
         WebDriver driver=new ChromeDriver();
         
         driver.get("https://demo.nopcommerce.com/");
	     driver.manage().window().maximize();
	   /*
	     //1.tag with id     #				
     driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Macbook");
	     //only id
     driver.findElement(By.cssSelector("small-searchterms")).sendKeys("Macbook"); 

     //2.tag with class     .
     driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Apple");
         //only classname
     driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Apple");
     */

     
     //3 tag with attribute
      // any type of attribute we can used
      //while using used "" outside brackt & inside value use single quote''
     driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Macbook");
	//without tag name
   driver.findElement(By.cssSelector("[type='text']")).sendKeys("Android");
	
   //4 tag with id, class & attribute
     driver.findElement(By.cssSelector(".search-box-text[type='text']")).sendKeys("Macbook");
	  //can be used without tagname, only class name with attribute
      //can be used only with one attribute
     driver.findElement(By.cssSelector(".search-box-text[type='text']")).sendKeys("Andriod");
	
      
	}

}

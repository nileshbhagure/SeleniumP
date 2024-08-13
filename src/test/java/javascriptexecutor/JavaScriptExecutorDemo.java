package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 JavascriptExecutor is an Interface which is implemented by RemoteWebDriver class along with WebDriver interface
  -JavascriptExecutor we have one method called executesSript()- we can execute javascript statements
  -whenever we called any method from WebDriver internally executed javascript stmts. The js stmts will actually talks with the browser elements
   but sometime we cant interact with webelemennt internally which we throw Element Intercepted Exeception
   so to avoid this we will directly executed js stmts using executeScript() method
 - whenever we call click()& sendKeys() method, internally called JS executor & JS executor will talk with browser. for sometimes sendkeys() & click method will not work
   we will execute these stmts directly using executeScript() to perform action on the elements
   
 */
public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
	//	ChromeDriver driver=new ChromeDriver();	
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	
		WebElement inputbox=driver.findElement(By.xpath("//input[@id='name']"));
	
	    //Object of ChromeDriver we are assingning to variable of JavaScriptExecutor
	    //child class object we are storing into parent class variable- UP casting
	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//if we are create driver ChromeDriver driver=new ChromeDriver(); then no need for type casting we can directly assign driver into JS variable
		//- parent class variable can hold child class variable- NO need for type casting
	    // JavascriptExecutor js=driver;  //direct approach
	
		// Passing the text into inputbox- alternate of sendKeys()
	    //first parameter is JS
		//arguments[0]- its array elment, element passing [eg inputbox] we are storing here
       //setAttribute()- In JS method
		
	     js.executeScript("arguments[0].setAttribute('value','Nilesh')",inputbox);   
	
	   //clicking on element- alternate of click()
	   WebElement radiobtn=driver.findElement(By.xpath("//input[@id='male']")); 
	   js.executeScript("arguments[0].click()", radiobtn);
	}

}

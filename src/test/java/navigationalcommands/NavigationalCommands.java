package navigationalcommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 Navigational commands
-----------------
1.navigate().to(url)   same as driver.get(url)
  - both are same. internally navigate method also calling get url
  - get method accept url in only in String format where as navigate().to() accept url in 2 format - 1. string 2. url                  
2.navigate().forward()
3.navigate().back()
4.navigate().refresh()

driver.navigate().to(url);

driver.manage().window().maximize();

"https://www.google.com"   -----> string

URL myurl=new URL("https://www.google.com")

navigate().to(URL) 
    accepts url is URL & Strign format

driver.get()  
	accepts only String format
  
  
 */
public class NavigationalCommands {

	public static void main(String[] args) {
     WebDriverManager.chromedriver().setup();
     WebDriver driver=new ChromeDriver();
		
     driver.navigate().to("https://www.amazon.in/");
	 System.out.println(driver.getCurrentUrl());
	 
     driver.navigate().to("https://www.flipkart.com/");
	 System.out.println(driver.getCurrentUrl());

	 driver.navigate().back();
	 System.out.println(driver.getCurrentUrl());  //amz

	 driver.navigate().forward(); //flip
	 
	 driver.navigate().refresh();  //refresh the page
	}

}

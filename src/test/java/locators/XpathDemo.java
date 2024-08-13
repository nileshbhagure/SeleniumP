package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 XPath
--------
Address of an element- which will travels through the DOM till the element is find
DOM - Document Object Model

2 kinds of xpaths
------
1) Absolute xpath( full xpath)

	/html/body/header/div/div/div[1]/div/a/img

2) Relative xpath ( partial xpath)

	//div[@id="logo"]/a/img

	//img[@title='Your Store']

differences....
1.Absolute xpath start with root node while relative jump particular tag
2.Absolute xpath does not used any attribute while releative xpath used certain attribute
3.Absolute xpath is longer while relative xpath is smaller
5.Absolute xpath start with / while releative xpath start with //
which one you will prefer?   
	Relative xpath

why?
	bcoz absolute xpath wont work if there are any changes in web page.


How to write our own xpath?

	//*[@attribute='value']
	//tagname[@attribute='value']


How to generate xpath automatically?
  1) using developer tools
 2) using selectors hub - extension of browser

//img[@title='Your Store']

xpath having multiple attributes
xpath functions - text(), normalized-pace(), contains() start-with(), first(),last(),
xpath operators - and      or
xpath axes - following, preceding, sibling, parent, self, ancestor etc.....
How to locate elements who attributes are dynamically changing

 */
public class XpathDemo {

	public static void main(String[] args)
	{				
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
    driver.get("https://demo.opencart.com/");
	driver.manage().window().maximize();
	
	String productname=driver.findElement(By.xpath("//a[text()=\"MacBook\"]")).getText();
	System.out.println(productname);
	
	//only tags
	driver.findElement(By.xpath("//*[text()=\"MacBook\"]")).getText();
	
	//absolute
	String pname=driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/h4[1]/a[1]")).getText();
// //input[@name="search"]
		// using parent tag
	// //div[@id="search"]/input
	////a[text()="MacBook"]
	
	String label1=driver.findElement(By.xpath("\\a[text()='MacBook']")).getText();
	System.out.println(label1);
	
	//or use as normalised text function- which remove space
	String productname1= driver.findElement(By.xpath("//a[normalize-space()='MacBook']")).getText(); 

	
	
	}

}

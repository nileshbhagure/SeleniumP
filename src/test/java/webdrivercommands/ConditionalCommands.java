package webdrivercommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 conditional commands - access these commands thorugh WebElement
----------------------
Returns true/false ( boolean values)

isDisplayed(): return true if elemt present on webpage
             to check some link, images, inputbox on webpage
isEnabled(): to check enables/disable state. return true if enables 
            -to check radio button, checkbox,
isSelected()
            -radiobutton, checkboxes & dropdown
 */
public class ConditionalCommands {

  public static void main(String[] args) throws InterruptedException {
	  
  WebDriverManager.chromedriver().setup();
  WebDriver driver=new ChromeDriver();
	
  driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F/");
  driver.manage().window().maximize();
  /*
  //logo status
  WebElement logo=driver.findElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]"));
  System.out.println("Status of logo: "+logo.isDisplayed());
  //OR
  
  boolean status=driver.findElement(By.xpath("img[@alt=\\\"nopCommerce demo store")).isDisplayed();
  System.out.println(status); 
  */
  
  Thread.sleep(3000);
  
  //to check searchbox is display & its enable
 /*
  WebElement searchbox=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
  System.out.println("Dispaly status: "+searchbox.isDisplayed());
  System.out.println("Enable status: "+searchbox.isEnabled());
  */
  
  //isSelected(): used for mostly checkbox,radiobutton
  WebElement male_rd=driver.findElement(By.xpath("//input[@id=\"gender-male\"]"));
  WebElement female_rd=driver.findElement(By.xpath("//input[@id=\"gender-female\"]"));

  //before selection radio button
  System.out.println("Before selection---");
  System.out.println(male_rd.isSelected());  //false
  System.out.println(female_rd.isSelected()); //false

  //after selection of male radio button
  System.out.println("After selection of male radio button---"); //true
  male_rd.click();
  System.out.println(male_rd.isSelected()); //true
  System.out.println(female_rd.isSelected()); //false

//after selection of female radio button
  System.out.println("After selection of female radio button---"); //true
  female_rd.click();
  System.out.println(male_rd.isSelected()); //false
  System.out.println(female_rd.isSelected()); //true

  
  driver.quit();
  }

}

package checkboxesandradiobutton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleRadiobutton {

	public static void main(String[] args) 
	{
     WebDriverManager.chromedriver().setup();
     WebDriver driver=new ChromeDriver();
     
     driver.get("https://testautomationpractice.blogspot.com/");
     driver.manage().window().maximize();
	
     WebElement malerd=driver.findElement(By.xpath("//input[@id=\"male\"]"));
     WebElement femalerd=driver.findElement(By.xpath("//input[@id=\"female\"]"));

     System.out.println("Before Selection");
     System.out.println("Select status of male radio button "+malerd.isSelected()); 
     System.out.println("Select status of female radio button "+femalerd.isSelected()); 

     malerd.click();
     
     System.out.println("After Selection");
     System.out.println("Select status of male radio button "+malerd.isSelected()); 
     System.out.println("Select status of female radio button "+femalerd.isSelected()); 
	}

}

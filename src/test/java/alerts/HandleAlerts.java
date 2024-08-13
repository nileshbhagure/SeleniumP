package alerts;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
/* ALerts- Popup
1.JS alert- 
  We cannot inspect
  Background window gets freeze until accept/cancel/input action is perform
  
  
accept()

driver.switchTo().alert().accept()   // close alert box using ok button
driver.switchTo().alert().dismiss()  // close alert box using cancel button
driver.switchTo().alert().getText() // capture text value from alert
driver.switchTo().alert().sendKeys()  // pass the text into inputbox inside the alert

how to capture alert box without using switcho().alert() ?
Ans: using explicit wait
*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {

	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	driver.manage().window().maximize();
	
	//1. Normal alert with OK button
	/*
	driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
	
	Thread.sleep(5000);	
	//Alert- Predefined interface
	Alert myalert=driver.switchTo().alert();
	myalert.accept();  //accept a alert
	
    //driver.switchTo().alert().accept();
	
	//2. confirmation Alert - Ok & Cancel
	driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
	Thread.sleep(5000);	

	//driver.switchTo().alert().accept();  //close alert window using ok button
	driver.switchTo().alert().dismiss(); // close alert window using cancel button
	*/
	//3. Prompt alert- Input value
	driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
	
	Alert myalert=driver.switchTo().alert();
	Thread.sleep(5000);
	
	System.out.println(" The Text msg on alert"+myalert.getText());  //getting text from prompt
	myalert.sendKeys("Welcome");  //send the text
	myalert.accept();            //close the prompt
	
	//validation
	String res=driver.findElement(By.xpath("//p[@id='result']")).getText();
	if(res.contains("Welcome"))
	{
		System.out.println("test pass");
	}
	else
	{
		System.out.println("test fail");

	}
	}

}

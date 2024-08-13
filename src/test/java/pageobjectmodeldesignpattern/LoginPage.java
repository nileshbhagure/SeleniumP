package pageobjectmodeldesignpattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 Page Object model

Test case- All are located in one single tc 
----
locators
test methods ----code---validations+Actions

without using POM
- duplication of elements/locators
- Updation

Page object model
- Its is design pattern
- the way we maintain the webelement, locators
- we do not put tc & webelement in single class
- we separate test method, locators, webelement
- contains only page element + action methods
- Every POM class will contains constructor, locators & action methods
with using POM
 -As we separate locators & test method in separate class
 - duplication problem is resolved
 - updation can be done easy
 
2 appraoches to create page object classes
---------------------------
1) without using PageFactory
2) using PageFactory

Note: PageFactory is pred-defined class in seleneium to create Page object classes
-----------------

WebElement usertxt=driver.findElement(By.xpath("//input[@placeholder='Username']");

//locators section
By loc=By.xpath("//input[@placeholder='Username'];   //locator stored in a By variable

//Action section
driver.findElement(loc).sendKeys("xyz")
 */
public class LoginPage 
{
     WebDriver driver;
	
     //1. constructor- to intiated the web driver
	LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
     
	//2. locators: select the format & copy all from selectorhub
	By txt_username_loc=By.xpath("//input[@placeholder='Username']");
	By txt_password_loc=By.xpath("//input[@placeholder='Password']");
	By btn_login_loc=By.xpath("//button[normalize-space()='Login']");
	
	//3. Action methods - locate the element & perform action
	public void setUserName(String user)
	{
		driver.findElement(txt_username_loc).sendKeys(user);
	}
	
	
	public void setPassword(String pwd)
	{
		driver.findElement(txt_password_loc).sendKeys(pwd);
	}

	public void clickLogin()
	{
		driver.findElement(btn_login_loc).click();
	}
	
}

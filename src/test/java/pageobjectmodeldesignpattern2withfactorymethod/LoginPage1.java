package pageobjectmodeldesignpattern2withfactorymethod;
/*Using pagefactory approch
pagefactory is predefined class available in selenium
*/
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPage1 
{
     WebDriver driver;
	
     //1. constructor- to intiated the web driver
	LoginPage1(WebDriver driver)
	{
		this.driver=driver;
		//mandtory
	    PageFactory.initElements(driver,this);   //need to call initielement method from Pagefactoryclass which driver will be avialble for kinds of elements
	}
     
	//2. locators: select the format & copy all from selectorhub
	    
	    //how-keyword
	    //How- class
	    //using- keyword
	//	@FindBy(how=How.XPATH, using="//input[@placeholder='Username']")  
     // WebElement txt_username;

		@FindBy(xpath="//input[@placeholder='Username']")  
        WebElement txt_username;
		
		@FindBy(xpath="//input[@placeholder='Password']")  
		WebElement txt_password;
		
		@FindBy(xpath="//button[normalize-space()='Login']")  
		WebElement btn_login;
	
		//group of element we can returns
		@FindBy(tagName="a")
		List<WebElement> links;
	
	//3. Action methods - locate the element & perform action
	
		public void setUserName(String user)
		{
			txt_username.sendKeys(user);
		}
		
		
		public void setPassword(String pwd)
		{
			txt_password.sendKeys(pwd);
		}

		public void clickLogin()
		{
			btn_login.click();
		}
		
}

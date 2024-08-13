package alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticatePopup {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

       // driver.get("http://the-internet.herokuapp.com/basic_auth");

		//syntax
		//http://username:password@the-internet.herokuapp.com/basic_auth
        
		//ingest along with url- Ingestion process
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

		driver.manage().window().maximize();

	}

}

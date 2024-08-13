package slider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindow {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.opencart.com/");
	
	   //Selenium 4.x onward: open new tab & automatically switch & focus to new tab
	//driver.switchTo().newWindow(WindowType.TAB);  //open new tab
	
	driver.switchTo().newWindow(WindowType.WINDOW);  //open new window browser
	
	//focus will be on new window
	driver.get("https://orangehrm.com/");

	}

}

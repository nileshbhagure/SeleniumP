package slider;
/*Keyboard actions - Actions 

keyDown()
keyUp()

For 3 keys
Ex: Ctrl+shift+A
act.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("A").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();

Ex: Enter
act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();

//Control+Reglink
act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();

 * 
 */
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class keyboardaction {

	public static void main(String[] args) 
	{
			
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
			driver.get("https://text-compare.com/");
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//textarea[@name=\"text1\"]")).sendKeys("OM SAI RAM");
			
			Actions act=new Actions(driver);
			
			//ctr1+A- Select all the text
			//KeyDown()- method used for Pressing the keys
			//Keys- Keys is a class where we can acesss all the keys
			//sendKeys- To send any character
			//KeyUp()- method used to release a key
			    //press the key                     //release the key
			act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			
			//ctr1+C -Copy the text
			act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
			
			//TAB    -Shift to 2nd box
			act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
			
			//ctr1+V - Past the text
            act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
            }

}

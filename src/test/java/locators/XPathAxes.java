package locators;
/*
 Multiple attribute in xpath
--------
//input[@name='username'][@placeholder='Username']

//input[@name='username' and @placeholder='Username']
//input[@name='xyz' or @placeholder='Username']


multiple attributes in xpath

eg //input[@name='username'][@placeholder='Username']
 
1.last()
2.text() :
 with static Visible Text (exact match)
 locating elements containing exact text within opening tag and closing tag (inner text).
      //tagName[text()=’exact text’]
      eg //a[text()='iPhone']
3.starts-with() when prefix(start) of the inner text is static
      	//tagName[starts-with(text(),’Prefix of Inner Text’)]
        eg //a[starts-with(text(),'Apple')]
4.contains() when part of the visible text is static (partial match)
        //tagname[contains(text(),'substring')]
     eg //a[contains(text(),'Information')]
5.and  both the atribute should be true

eg //input[@name='username' and @placeholder='Username']
  
6 or any one atribute should be true

eg //input[@name='username' or @placeholder='Username']
----------------------------------------
xpath axes: If we do not have any attribute to locate element we take help of others elemt(sibling, parent, child) to locate & then find the elemet 


1.ancestor:: - parent of parent
2.parent- root
  //<knownXpath>/parent::elementName
   eg //input[@id=’txtUsername’]/parent::form
   //input[@id=’txtUsername’]/parent::*
3.preceding-sibling::- immediate(first) element after parent
4.following-sibling:: -immediate element after root element
5.child::- child of root(context) element
       //<xpathOfContextElement>/child::<elementName>
        //<xpathOfContextElement>/child::*
       eg  //div[@id=’divUsername’]/child::input
 
 
6.descendant- child of child (grand-child)
         descendant axis consists of the children of a context element and their children and so on
//<xpathOfContextElement>/descendant::<elementName> or //<xpathOfContextElement>/descendant::*
eg//form[id='frmLogin]/descendant::input




//form[@id=‘txtUsername’]/descendant:: input[1]

XPath Axes
---------------
https://www.youtube.com/playlist?list=PLUDwpEzHYYLut2OnS4GlY7fiSAabRmsz3

1) what is dot here  

//a[contains(.,'test labs')];    // what is . here ???   
 */



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPathAxes {

	public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		
		//Self  - Selects the current node
		String text=driver.findElement(By.xpath("//a[contains(text(),'NIIT Ltd')]/self::a")).getText();
		System.out.println("Self : "+ text); //NIIT Ltd
		
		
		//Parent - Selects the parent of the current node (always One)
		text=driver.findElement(By.xpath("//a[contains(text(),'NIIT Ltd')]/parent::td")).getText();// there is no text for parent, so it is same value display
		System.out.println("Parent : "+text);  //NIIT Ltd
		
		//Child - Selects all children of the current node (One or many)
		List<WebElement> childs=driver.findElements(By.xpath("//a[contains(text(),'NIIT Ltd')]/ancestor::tr/child::td"));
		System.out.println("Number of child elements:"+childs.size());//5
		
		//Ancestor - Selects all ancestors (parent, grandparent, etc.) 
		text=driver.findElement(By.xpath("//a[contains(text(),'NIIT Ltd')]/ancestor::tr")).getText();
		System.out.println("Ancestor : "+text);
		
		//Descendant - Selects all descendants (children, grandchildren, etc.) of the current node
		List<WebElement> descendants=driver.findElements(By.xpath("//a[contains(text(),'NIIT Ltd')]/ancestor::tr/descendant::*"));
		System.out.println("Number of descendant nodes:"+descendants.size());
		
		//Following -Selects everything in the document after the closing tag of the current node
		List<WebElement>followingnodes=driver.findElements(By.xpath("//a[contains(text(),'NIIT Ltd')]/ancestor::tr/following::tr"));
		System.out.println("Number of following nodes:"+followingnodes.size());
		
		//Following-sibling : Selects all siblings after the current node
		List<WebElement> followingsiblings=driver.findElements(By.xpath("//a[contains(text(),'NIIT Ltd')]/ancestor::tr/following-sibling::tr"));
		System.out.println("Number of Following Siblings:"+followingsiblings.size());
		
		//Preceding - Selects all nodes that appear before the current node in the document
		List<WebElement> precedings=driver.findElements(By.xpath("//a[contains(text(),'NIIT Ltd')]/ancestor::tr/preceding::tr"));
		System.out.println("Number of preceding nodes:"+precedings.size());
		
		//preceding-sibling - Selects all siblings before the current node
		List<WebElement> precedingsiblings=driver.findElements(By.xpath("//a[contains(text(),'NIIT Ltd')]/ancestor::tr/preceding-sibling::tr"));
		System.out.println("Number of preceding sibling nodes:"+precedingsiblings.size());
		
		driver.quit();

	}

}


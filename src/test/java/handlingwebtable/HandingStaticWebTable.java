package handlingwebtable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 tr- Table row
 th- Table header- column are represent
 td- Table data
 */
public class HandingStaticWebTable 
{

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		//1) Find total no of rows
		int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();  //mutiple table
		//int row=driver.findElements(By.tagName("tr")).size(); //single webtable in the page
		System.out.println("No of rows: "+rows);  //7
		
		//2) Find total no of column/header
		int column=driver.findElements(By.xpath("//table[@name=\"BookTable\"]//th")).size();  //mutiple table
	   // int column=driver.findElements(By.tagName("th")).size();   //single table- Preferable
		System.out.println("No of column "+column);  //4
	
	   //Read data from spefic row & colummn
	  String bookName=driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[5]//td[1]")).getText();
	  System.out.println(bookName);  //Master In Selenium

	  //4. Read data from all the rows & column
	  
	  System.out.println("BookName"+"\t"+"\t"+"Author"+"\t"+"Subject"+"\t"+"Price"); //printing the header
	  for(int r=2; r<=rows; r++)                     //outer for loop- repeating the rows
	  {
		  for(int c=1; c<=column; c++)               //inner for loop- repeating every column in every rows
		  {
			  //passing variable as a prameter
			  String value=driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td["+c+"]")).getText();  //passing row & col as variable-dynamic
              System.out.print(value+"\t");  //giving the tab- one space
		  }
		  System.out.println();
	  }
	
	  //5) Print book name whose author is Mukesh
	  
	  for(int r=2; r<=rows; r++)
	  {
		  String authorName=driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td[2]")).getText();
	  
	      if(authorName.equals("Mukesh"))
	      {
			  String boookName=driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td[1]")).getText();
              System.out.println(boookName+"\t"+authorName);
	      }
	  }
	  
	  
	  //6) find total price of all the book
	  int total=0;
	  for(int r=2; r<=rows; r++)
	  {
		  String price=driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td[4]")).getText();
	      total=total+Integer.parseInt(price);            //converting string into int for calculating price
	}
	  System.out.println("Total price of book "+total);  //7100

}
}

package datadriventesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import utlityclass.ExcelUtils;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();

		String filePath=System.getProperty("user.dir")+"\\Test Data\\caldata.xlsx";
		
		int rows=ExcelUtils.getRowCount(filePath, "Sheet1");   //return no of rows in excel
	   
		for(int i=1; i<=rows; i++)  //i represent row no
	   {
		   //step 1: read data from excel
		  String pric= ExcelUtils.getCellData(filePath, "Sheet1", i,0);
		  String rateofint= ExcelUtils.getCellData(filePath, "Sheet1", i,1);
		  String pri1= ExcelUtils.getCellData(filePath, "Sheet1", i,2);
		  String pri2= ExcelUtils.getCellData(filePath, "Sheet1", i,3);
		  String freq= ExcelUtils.getCellData(filePath, "Sheet1", i,4);
		  String expmvalue= ExcelUtils.getCellData(filePath, "Sheet1", i,5);
		   
		   //step2: pass above data into application
		   driver.findElement(By.xpath("//input[@id=\"principal\"]")).sendKeys(pric);
		   driver.findElement(By.xpath("//input[@id=\"interest\"]")).sendKeys(rateofint);
		   driver.findElement(By.xpath("//input[@id=\"tenure\"]")).sendKeys(pri1);
		   
		   Select perdrp=new Select(driver.findElement(By.xpath("//select[@id=\"tenurePeriod\"]")));
		   perdrp.selectByVisibleText(pri2);
		   
		   Select freddrp=new Select(driver.findElement(By.xpath("//select[@id=\"frequency\"]")));
		   freddrp.selectByVisibleText(freq);

			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click(); //clicked on calculate
		   
			//step3: validation
	        String act_mvalue=driver.findElement(By.xpath("//span[@id=\"resp_matval\"]//strong")).getText();
	        
	        if(Double.parseDouble(expmvalue)==Double.parseDouble(act_mvalue))    //converting string to double
	        {
	        	System.out.println("Test Pass");
	        	ExcelUtils.setCellData(filePath, "Sheet1", i, 7,"Passed");  //7 column we need write in excel
	        	ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
	        }
	        else
	        {
	        	System.out.println("Test Failed");
	        	ExcelUtils.setCellData(filePath, "Sheet1", i, 7,"Failed");  //7 column we need write in excel
	        	ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
	        }
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//span[@id=\"resp_matval\"]//strong")).click();   //clicking on clear button
	   } //ending of for loop
	     driver.quit();

	}

}

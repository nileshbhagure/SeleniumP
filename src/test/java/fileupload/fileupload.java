package fileupload;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fileupload {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
	/*
		//single file upload- using sendKeys() method just pass the location of the file
		driver.findElement(By.xpath("//input[@id=\"filesToUpload\"]")).sendKeys("D:\\Automation Test File data\\Test1.txt");
	
		if (driver.findElement(By.xpath("//ul[@id=\"fileList\"]//li")).getText().equals("Test1.txt"))
		{
			System.out.println("File is scessfully uploaded");
		}
		else
		{
			System.out.println("Upload failed");
		}
	*/
	
		//Multiple file upload
		String file1="D:\\Automation Test File data\\Test1.txt";
		String file2="D:\\Automation Test File data\\Test2.txt";
  
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
	
	   int noOfFiles= driver.findElements(By.xpath("//ul[@id=\"fileList\"]//li")).size();
	
	  //validation 1- No of files
	  if(noOfFiles==2)
	{
		System.out.println("All Files are uploaded");
	}
	
	else
	{
		System.out.println("Files are not uploaded or incorrect file uploaded");
	}
	
	//validate file name
	if(driver.findElement(By.xpath("//ul[@id=\"fileList\"]//li[1]")).getText().equals("Test1.txt") &&
			driver.findElement(By.xpath("//ul[@id=\"fileList\"]//li[2]")).getText().equals("Test2.txt"))
	{
	System.out.println("Files are matching..");	
	}
	else
	{
		System.out.println("Files are not matching");	

	}
	}
}	
package browseroptionclassforsettingcontrol;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
step 1: Add CRX Extractor/Downloader to chrome Browser  ( manually)- this plugin download CRX file of any extension
Step2 : Add SelectorsHub plugin to chrome browser (manually)
step3 : Capture crx file for selectorshub extension
Step4: pass crx file path in automation script in Chrome Options


ChromeOptions options=new ChromeOptions();
options.addExtensions(new File("C:\\Drivers\\SelectorsHub.crx"));


How to block ads on the page
----------------------------------
uBlock-Origin
AdBlocker


 */
public class EnableExtensionAtRunTime {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		File file=new File("D:\\Automation Test File data\\CRX file\\SelectorsHub.crx");  //spefic the file path of CRX file
	
		options.addExtensions(file); //passing file
	
        WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://text-compare.com/");
	}

}

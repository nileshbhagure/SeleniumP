package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

/*
  New->File->filename.properties
  Normal text file with extension .properties
  we can stored data in only key value pair
  No syntax follow
  used for configuration
  commonly used data required for mutiple data case
 */
public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {


	//step1: location of properities file & reading the file in read mode
		FileInputStream file =new FileInputStream(System.getProperty("user.dir")+"\\Test Data\\config.properties");
	
	//step 2: creating the object of properties class & loading the file
		Properties propertiesobj=new Properties();
		propertiesobj.load(file);
	
	//3. Reading data from properities
		String url=propertiesobj.getProperty("appurl");
		String email=propertiesobj.getProperty("email");
		String pwd=propertiesobj.getProperty("password");
		String ordid=propertiesobj.getProperty("orderid");
		String custid=propertiesobj.getProperty("customerid");
		
		System.out.println(url+" "+email+" "+pwd+" "+ordid+" "+custid);
	
	//4. reading all the only from properties files
		//1 way
		Set<String> keys=propertiesobj.stringPropertyNames();
	    System.out.println(keys); //[password, orderid, customerid, appurl, email]
	
	    //2 way
	    Set<Object> keys1=propertiesobj.keySet();
	    System.out.println(keys1);  //[password, orderid, customerid, appurl, email]

	//5. reading all the only values from properties files    
	    Collection<Object> values=propertiesobj.values();
	    System.out.println(values); //[abcxyz, 123, 234, https://demo.opencart.com/, abc@gmail.com]

	    
	   file.close(); 
	}

}

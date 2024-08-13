package datadriventesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {
	      FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\Test Data\\dynamic_file_data.xls");  //if file already exisit then it will override else it will create new file
	    //step 1: create the workbook
	      XSSFWorkbook workbook=new XSSFWorkbook();
	      
		//step 2: create the sheet      
	      XSSFSheet sheet=workbook.createSheet("sheet1");
	
	     //Step 3: Take the input from user 
	      Scanner sc=new Scanner(System.in);
	      System.out.println("Enter how many rows?");
	      int noOfrows=sc.nextInt();
	      
	      System.out.println("Enter how many cells?");
	      int noOfcells=sc.nextInt();
	      
	      for(int r=0; r<=noOfrows; r++)              //represent rows
	      {
	    	  XSSFRow currentRow=sheet.createRow(r);
	    	  for(int c=0; c<noOfcells; c++)                     //represent cells
	    	  {
	    		  XSSFCell cell=currentRow.createCell(c);
	    	      cell.setCellValue(sc.next());   //value capture at the run time & will add in cell
	    	                                      //user can enter any value(string, int, float- so common method is next()	  
	    	  }
	      }
	      
	
	      workbook.write(file); //attach workbook to the file
	      workbook.close();
	      file.close();
	     System.out.println("file is created..."); 
	}

}

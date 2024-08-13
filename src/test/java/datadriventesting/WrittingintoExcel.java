package datadriventesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel File--->Workbook--->Sheets--->Rows----Cells

public class WrittingintoExcel {

	public static void main(String[] args) throws IOException {
      FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\Test Data\\myfile.xls");  //if file already exisit then it will override else it will create new file
	  
	//step 1: create the workbook
      XSSFWorkbook workbook=new XSSFWorkbook();
      
	//step 2: create the sheet
      
      XSSFSheet sheet=workbook.createSheet("sheet1");
	
	//step 3:create row in the sheet
     XSSFRow row1=sheet.createRow(0);
     
     //step 4. create the cell in the row
     row1.createCell(0).setCellValue("java");
     row1.createCell(1).setCellValue("123");
     row1.createCell(2).setCellValue("automation");

     XSSFRow row2=sheet.createRow(1);
     row2.createCell(0).setCellValue("python");
     row2.createCell(1).setCellValue("3");
     row2.createCell(2).setCellValue("automation");
	
     XSSFRow row3=sheet.createRow(2);
     row3.createCell(0).setCellValue("javascript");
     row3.createCell(1).setCellValue("4");
     row3.createCell(2).setCellValue("automation");
	
	//step 5: Attaching workbook to the file
     workbook.write(file);
     
    workbook.close();
    file.close();
   System.out.println("file is created..."); 
   
    
	}

}

package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/*The Testing is driven by data
  we need to add 3rd party library called Apache poi  library  
 -Apache POI is an open-source, free Java library used to read and write Microsoft Office file formats, such as Excel (.xls), PowerPoint (.ppt), and Word (.doc).
 - 2 library dependencies we need to add in pom.xml
   -a) Apache POI Common
   -b) Apache POI API Based On OPC and OOXML Schemas

Excel File--->Workbook--->Sheets--->Rows----Cells

These 2 class are from java where were can open Excel
 1.FileInputStream - reading
 2.FileOutputStream   - writing

Following 4 class are provided by Apache POI which will deal with Workbook, sheet row & cells
 1.XSSFWorkbook    --- workbook
 2.XSSFSheet   -- sheet
 3.XSSFRow   - row
 4.XSSFCell  -- cell

1) reading data from excel- from the cell
2) writing data in to excel- from the cell

 */
public class ReadingintoExcel {

	public static void main(String[] args) throws IOException {
//Excel File--->Workbook--->Sheets--->Rows----Cells

	//Step 1: Open the excel in reading mode
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Test Data\\data1.xlsx");  //return the current project dir path and contantact with testdata
	
    //step 2: get the workbook from file
		XSSFWorkbook workbook=new XSSFWorkbook(file);
	
    //step 3: get the sheet
	    XSSFSheet sheet=workbook.getSheet("Sheet1");  //extract sheet from workbook
		//XSSFSheet sheet=workbook.getSheetAt(0);  //we can used index-0= firstsheet in the workbook

	//steps 4: calculate no of rows & cells
		int totalrows=sheet.getLastRowNum();  //get the last row no of the sheet
	
	  //capturing cells from the rows
		int totalCells=sheet.getRow(0).getLastCellNum();
	
	 //printing no of rows & cells
		System.out.println("No of rows: "+totalrows);  //4  Rows are counting from 0
		System.out.println("No of cols: "+totalCells); //3  Cells are counting from 1

	//Step 5: Reading the rows & cells
		for(int r=0; r<=totalrows; r++)        //outer for loop represent rows. In Java rows start from 0
		{
			XSSFRow currentRow=sheet.getRow(r);         //getting the current rows
			
			for(int c=0; c<totalCells; c++)    ////inner forloop represent cells/column. In Java column start from 0
			{
			XSSFCell cell=currentRow.getCell(c);    //from current row will get current cell 
			System.out.print(cell.toString()+"\t");
			}
			
		  System.out.println();  //to print to nextline	
		}
		  workbook.close(); 
		  file.close();
		}
	}



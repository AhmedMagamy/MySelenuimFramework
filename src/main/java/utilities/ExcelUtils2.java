package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils2 {

	
	
	public  FileInputStream fis =null; 
    public 	FileOutputStream fileOut = null;
	private String projpath =null; 
	private static XSSFWorkbook workbook =null;
	private static XSSFSheet sheet =null;
	private static XSSFRow row = null; 
	private static XSSFCell cell = null; 
	String path = null; 
	
	
	//Constructor
	public 	ExcelUtils2 (String filename)
	{
		try{
			
			path = System.getProperty("user.dir") +"\\Excel\\"+filename ; 
			fis = new FileInputStream(path);

			//step 1 create refrances of workbook (object )
			workbook = new XSSFWorkbook(fis) ; 
			//XSSFWorkbook workbook = new XSSFWorkbook("E:\\study\\java\\my java workspace\\Automation\\SeleniumJavaFramework\\Excel\\data.xlsx") ; 
			//step 2 create refrences for xssf sheet 
			sheet = workbook.getSheetAt(0);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	
	public static int getRowCount(String sheetName)
	{
		

		try{
			
			int index = workbook.getSheetIndex(sheetName);
			sheet = workbook.getSheetAt(index);
			
		}
		catch(Exception e )
		{
			System.out.println(e.getMessage()); ;
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		 return(sheet.getLastRowNum() + 1);

	}
	
	
	
	public static int getColCount(String sheetName )
	{
		


		try{
			//Provide total number of columns in sheet - testcase 
			  int index = workbook.getSheetIndex(sheetName); 
			  sheet = workbook.getSheetAt(index); 
			  row = sheet.getRow(0); 
			   
			
			

		}
		catch(Exception e )
		{
			System.out.println(e.getMessage()); ;
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		return(row.getLastCellNum());

	}

	
	
	
	

	public static String getCellDataString(String sheetName,int rowNum , int colNum)
	{


		try{
			
			
			int index = workbook.getSheetIndex(sheetName); 
			  sheet = workbook.getSheetAt(index); 
			  row = sheet.getRow(rowNum); 
			  cell = row.getCell(colNum); 





		}
		catch(Exception e )
		{
			System.out.println(e.getMessage()); ;
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		  return(cell.getStringCellValue()); 

	}
	
	
	
	
	
	public static int getCellDataNumber(String sheetName,int rowNum , int colNum)
	{

		int cellData = (int) 0.0 ;
		try{
			int index = workbook.getSheetIndex(sheetName); 
			  sheet = workbook.getSheetAt(index); 
			  row = sheet.getRow(rowNum); 
			  cell = row.getCell(colNum); 

			
		}
		catch(Exception e )
		{
			System.out.println(e.getMessage()); ;
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		cellData = (int) cell.getNumericCellValue() ;
		return cellData;

	}
}

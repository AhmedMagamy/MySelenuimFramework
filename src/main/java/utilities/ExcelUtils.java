package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static String projpath ; 
	static XSSFWorkbook workbook ;
	static XSSFSheet sheet ;

	
	public 	ExcelUtils (String excelPath , String sheetName )
	{
		try{

			//step 1 create refrances of workbook (object )
			workbook = new XSSFWorkbook(excelPath) ; 
			//XSSFWorkbook workbook = new XSSFWorkbook("E:\\study\\java\\my java workspace\\Automation\\SeleniumJavaFramework\\Excel\\data.xlsx") ; 
			//step 2 create refrences for xssf sheet 
			sheet = workbook.getSheet(sheetName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	
	public static int getRowCount()
	{
		
		int rowCount = 0 ;

		try{
			projpath = System.getProperty("user.dir") ;
			//step 1 create refrnces of workbook (ibject )
			workbook = new XSSFWorkbook(projpath+"\\Excel\\data.xlsx") ; 
			//XSSFWorkbook workbook = new XSSFWorkbook("E:\\study\\java\\my java workspace\\Automation\\SeleniumJavaFramework\\Excel\\data.xlsx") ; 
			//step 2 create refrences for xssf sheet 
			sheet = workbook.getSheet("Sheet1");

			//step 3 use the physical method to get the row count of the sheet 
			rowCount = sheet.getPhysicalNumberOfRows() ; 		
		}
		catch(Exception e )
		{
			System.out.println(e.getMessage()); ;
			System.out.println(e.getCause());
			e.printStackTrace();
		}

		return rowCount ;
	}
	
	
	
	public static int getColCount()
	{


		int colCount = 0 ;

		try{

			projpath = System.getProperty("user.dir") ;
			//step 1 create refrnces of workbook (ibject )
			workbook = new XSSFWorkbook(projpath+"\\Excel\\data.xlsx") ; 
			//XSSFWorkbook workbook = new XSSFWorkbook("E:\\study\\java\\my java workspace\\Automation\\SeleniumJavaFramework\\Excel\\data.xlsx") ; 
			//step 2 create refrences for xssf sheet 
			sheet = workbook.getSheet("Sheet1");

			//step 3 use the physical method to get the row count of the sheet 
			colCount = sheet.getRow(0).getPhysicalNumberOfCells() ;
		}
		catch(Exception e )
		{
			System.out.println(e.getMessage()); ;
			System.out.println(e.getCause());
			e.printStackTrace();

		}

		return colCount ;
	}

	
	
	
	

	public static String getCellDataString(int rowNum , int colNum)
	{


		String cellData = null ;
		try{



			//step 3 call function  to get cell data 
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();


		}
		catch(Exception e )
		{
			System.out.println(e.getMessage()); ;
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		return cellData  ;
	}
	
	
	
	
	
	public static double getCellDataNumber(int rowNum , int colNum)
	{

		double cellData = 0.0 ;
		try{
			//step 3 call function  to get cell data 
			cellData = sheet.getRow(rowNum ).getCell(colNum).getNumericCellValue();
		}
		catch(Exception e )
		{
			System.out.println(e.getMessage()); ;
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		return cellData ;

	}
}

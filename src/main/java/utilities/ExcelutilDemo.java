package utilities;

public class ExcelutilDemo {
	
	public static void main(String[] args) {
		String projpath = System.getProperty("user.dir") ;
		
		
		ExcelUtils excel = new ExcelUtils(projpath+"\\Excel\\data.xlsx","Sheet1" );
		
		excel.getRowCount(); 
		excel.getCellDataString(0,0);
	}

}

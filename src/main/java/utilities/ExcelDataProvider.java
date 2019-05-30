package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExcelDataProvider {

	static WebDriver driver =null  ;
	@BeforeSuite
	public void setUp()
	{

		String projPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projPath+"\\drivers\\chromedriver\\chromedriver.exe");
		//WebDriver driver = new FirefoxDriver();
		driver = new ChromeDriver() ;

	}

	@Test(dataProvider="testdata example")
	public void test1(String username , String Password) throws Exception
	{
		System.out.println(username+ "  |  " +Password);


		driver.get("https://www.luxgems.co.uk/owner/login");

		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[1]/input")).sendKeys(username);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[2]/input")).sendKeys(Password);
		Thread.sleep(2000);

	}

	@DataProvider(name="testdata example")
	public Object[][]  getData()
	{
		String excelpath = "E:\\study\\java\\my java workspace\\Automation\\SeleniumJavaFramework\\Excel\\data.xlsx" ; 

		Object data [][] = testData( excelpath ,  "Sheet1") ;
		return data ;
	}




	public Object[][] testData(String excelpath , String sheetName)
	{
		ExcelUtils excel = new ExcelUtils(excelpath, sheetName);

		int rowCount = excel.getRowCount(); 
		int colCount = excel.getColCount(); 


		Object data [] [] = new Object [rowCount-1][colCount] ;

		for(int i = 1 ; i<rowCount ; i++ )
		{
			for(int j = 0 ; j<colCount ; j++)
			{
				String cellData = excel.getCellDataString(i, j);
				data[i-1][j] = cellData ;
			}

		}


		return data ; 
	}


}

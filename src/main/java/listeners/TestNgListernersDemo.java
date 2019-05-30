package listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

// add annotaions  that make the listenesr work  that refer to the listeners class(added in xml file )
//@Listeners(listeners.TestNgListeners.class)

public class TestNgListernersDemo {
	
	
	@Test
	public void test1( )
	{
		System.out.println("this is test 1");
	}
	@Test
	public void test2( )
	{
		
		//get the project paht to genralize 
				String projPath = System.getProperty("user.dir");
				
				 
				//System.setProperty("webdriver.chrome.driver", projPath+"\\drivers\\chromedriver\\chromedriver.exe");
				//WebDriver driver = new FirefoxDriver();
				WebDriver driver = new ChromeDriver() ; 
		System.out.println("this is test 2");
		
	}
	@Test
	public void test3( )
	{
		System.out.println("this is test 3");
		
		throw new SkipException("this test is skiped") ; 
	}
	@Test
	public void test4( )
	{
		System.out.println("this is test 4");
	}
}

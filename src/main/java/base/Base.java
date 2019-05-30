package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.*;

public class Base {

	//public static Properties prop;

	
	//must be static as it will be common for all classes and all tests
	public static WebDriver driver ;


	
	
	public void intilaize(String browserName)
	{

		String projPath = System.getProperty("user.dir");
		if(browserName.equals("chrome")){
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", projPath+"\\drivers\\gekodriver\\geckodriver.exe");
			driver = new FirefoxDriver(); 
		}
	}








}

package automationpracticewebsiteTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import utilities.BrokenLinksFinder;
import utilities.ExcelUtils2;
import automationPracticeWebsitepages.*;

//listeners 
@Listeners(listeners.TestNgListeners.class)
public class SigninPageTests extends Base{


	/*Here define objects of utlites to be used */

	String browserName ="chrome";
	SignInPage signin = new SignInPage();
	ExcelUtils2 excel = new ExcelUtils2("apdata.xlsx");
	@BeforeTest
	public void setUp(){
		intilaize(browserName);
		driver.manage().window().maximize();

	}




	@Test(priority=1 , dataProvider="logindata")
	public void loginTests(String email , String password ,String testcase) throws InterruptedException, MalformedURLException, IOException
	{
		
		driver.navigate().to("http://automationpractice.com/index.php?controller=authentication");
		signin.login(email,password);

		if(testcase.equals("valid"))
		{
			assertTrue(driver.getTitle().equals("My account - My Store"));
			
			//remember to replace this with home.logout
			driver.findElement(By.linkText("Sign out")).click();
		}
		else if(testcase.equals("validusernameivalidpassword"))
		{
			assertTrue(signin.geterrmsag().equals("Authentication failed."));
		}
		else if(testcase.equals("invalidusernameandpassword"))
		{
			assertTrue(signin.geterrmsag().equals("Invalid email address."));
		}
	}





	@DataProvider
	public Object[][] logindata(){
		Object[][] logindata = new Object [3][3] ;


		for (int row = 0; row < logindata.length; row++) {
			for (int col = 0; col < logindata[row].length; col++) {
				logindata[row][col] = excel.getCellDataString("login", row, col);
			}
		}
		return logindata ;
	}
	
	
	
	@AfterTest
	public void end() throws InterruptedException{
		driver.close();

	}







}

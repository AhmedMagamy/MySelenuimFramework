package automationpracticewebsiteTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import utilities.BrokenLinksFinder;
import automationPracticeWebsitepages.*;

//listeners 
@Listeners(listeners.TestNgListeners.class)
public class SigninPageTests extends Base{
	
	
	/*Here define objects of utlites to be used */
	
	String browserName ="chrome";
	SignInPage signin = new SignInPage();
@BeforeTest
public void setUp(){
	intilaize(browserName);
	driver.manage().window().maximize();

}

@Test(priority=1)
public void login() throws InterruptedException, MalformedURLException, IOException
{
	driver.navigate().to("http://automationpractice.com/index.php?controller=authentication");
	signin.login("ahmed", "ahmed");

}

@AfterTest
public void end() throws InterruptedException{
	Thread.sleep(2000);
	driver.close();

}







}

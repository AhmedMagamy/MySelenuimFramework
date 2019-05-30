package automationPracticeWebsitepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class SignInPage extends Base{
	
	
	
	
	 By emailaddress = By.id("email");
	 By password = By.id("passwd");
	 By loginbutton = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Forgot your password?'])[1]/following::span[1]");
	 By errmsg = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[1]/ol/li");
	
	 
	

	 
	 
	 
	 
	 
	 public void fillemail(String email){
		 driver.findElement(emailaddress).sendKeys(email);
	 }
	 
	 public void fillpassword(String pass){
		 driver.findElement(password).sendKeys(pass);
	 }
	 
	 public void clickloginbutton(){
		 driver.findElement(loginbutton).click();
	 }
	 public String geterrmsag(){
		 return  driver.findElement(errmsg).getText();
	 }
	 public void login(String email ,String password)
	 {
		 fillemail(email);
		 fillpassword(password);
		 clickloginbutton();	 
	 }
	 
	 

}

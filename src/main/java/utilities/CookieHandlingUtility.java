package utilities;

import java.io.BufferedWriter;		
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;

import java.io.BufferedReader;		
import java.io.File;		
import java.io.FileReader;		
import java.util.Date;		
import java.util.StringTokenizer;		
import org.openqa.selenium.Cookie;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;

import base.Base;

public class CookieHandlingUtility extends Base {

	/*
	 * 				Selenium Query Commands for cookies
	 * 
	 * driver.manage().getCookies();   // Return The List of all Cookies
	driver.manage().getCookieNamed(arg0);  //Return specific cookie according to name
	driver.manage().addCookie(arg0);   //Create and add the cookie
	driver.manage().deleteCookie(arg0);  // Delete specific cookie
	driver.manage().deleteCookieNamed(arg0); // Delete specific cookie according Name
	driver.manage().deleteAllCookies();  // Delete all cookies*/


	public void StoreCokieInfo()
	{
		File file = new File("Cookies.data");	
		try		
		{	  
			// Delete old file if exists
			file.delete();		
			file.createNewFile();			
			FileWriter fileWrite = new FileWriter(file);							
			BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
			// loop for getting the cookie information 		

			// loop for getting the cookie information 		
			for(Cookie ck : driver.manage().getCookies())							
			{			
				Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									
				Bwrite.newLine();             
			}			
			Bwrite.close();			
			fileWrite.close();	

		}
		catch(Exception ex)					
		{		
			ex.printStackTrace();			
		}		


	}


	@SuppressWarnings("deprecation")
	public void CookieWrite() throws IOException
	{
		try{			

			File file = new File("Cookies.data");							
			FileReader fileReader = new FileReader(file);							
			BufferedReader Buffreader = new BufferedReader(fileReader);							
			String strline;			
			while((strline=Buffreader.readLine())!=null){									
				StringTokenizer token = new StringTokenizer(strline,";");									
				while(token.hasMoreTokens()){					
					String name = token.nextToken();					
					String value = token.nextToken();					
					String domain = token.nextToken();					
					String path = token.nextToken();					
					Date expiry = null;					

					String val;			
					if(!(val=token.nextToken()).equals("null"))
					{		
						expiry = new Date(val);					
					}		
					Boolean isSecure = new Boolean(token.nextToken()).								
							booleanValue();		
					Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);			
					System.out.println(ck);
					driver.manage().addCookie(ck); // This will add the stored cookie to your current session					
				}		
			}		
		}catch(Exception ex ){	

			ex.printStackTrace();			
		}	



	}





}

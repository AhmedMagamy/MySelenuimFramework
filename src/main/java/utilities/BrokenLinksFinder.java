package utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Base;
import utilities.*;

public class BrokenLinksFinder extends Base {




	public boolean findBrokenLinks(String fileName) throws MalformedURLException, IOException
	{

		String projPath = System.getProperty("user.dir");
		//Step 1 : get the list of all elements of a and img 
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		linkslist.addAll(driver.findElements(By.tagName("img")));
		System.out.println("the size of all links = " + linkslist.size());
		//step 2 : iterate linklist : exclude all the links/images which doessn't have href

		List<WebElement> activelinks  = new ArrayList<WebElement>() ;
		List<WebElement> badlinks  = new ArrayList<WebElement>()    ;


		for(int i = 0 ; i<linkslist.size(); i++)
		{	
			if(linkslist.get(i).getAttribute("href") !=null && (!linkslist.get(i).getAttribute("href").contains("javascript")) &&( linkslist.get(i).getAttribute("href").contains("http")))
			{		
				activelinks.add(linkslist.get(i)) ;
			}			
		}


		//get the size of active links 

		System.out.println("the size of active links = " + activelinks.size());
		
		for(int i = 0; i <activelinks.size();i++)
		{
			System.out.println(activelinks.get(i).getAttribute("href"));

		}


		//3:check href url with httpcollection api 
		//200 >> ok
		//404>> not found
		//500 >> internal error 
		//400>>bad request 
List<String> messages = new  ArrayList<String>();
		for(int i = 0 ; i<activelinks.size(); i++)
		{	

			HttpURLConnection connection =(HttpURLConnection)new URL(activelinks.get(i).getAttribute("href")).openConnection();
			//HttpsURLConnection connection =(HttpsURLConnection)new URL(activelinks.get(i).getAttribute("href")).openConnection();
		//	connection.setRequestMethod("POST");

			connection.connect();
			String x =connection.getRequestMethod();
			String connectionmessage =connection.getResponseMessage();
			int responsecode = connection.getResponseCode() ;
			connection.disconnect();
			System.out.println(activelinks.get(i).getAttribute("href")+" ------->"+connectionmessage+responsecode+x);
			if(!connectionmessage.equals("OK"))
			{
				badlinks.add(activelinks.get(i));
				messages.add(connectionmessage+"  "+responsecode);
			}

		} 	


		if(!badlinks.isEmpty())
		{
			
			
			FileWriter write = new FileWriter( projPath+"\\Reoprts\\"+fileName+".txt", true);
			PrintWriter print_line = new PrintWriter( write );
			//int x =excelobj.getRowCount("Sheet1");
			System.out.println();
			System.out.println("the report of broken links");

			for(int i = 0 ; i<badlinks.size();i++)
			{
				String str =badlinks.get(i).getAttribute("href") ;
				String msg =messages.get(i);
				System.out.println(str+" ------>"+msg);
				print_line.println(str+"            "+msg);

			}
			print_line.close();

			return false ;
		}
		else
		{
			return true ;
		}

	}

}

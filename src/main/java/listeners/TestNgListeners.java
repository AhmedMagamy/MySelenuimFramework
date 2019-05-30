package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Base;




public class TestNgListeners extends Base implements ITestListener{
	ExtentHtmlReporter htmlReporter = null ;
	ExtentReports extent = new ExtentReports() ;
	ExtentTest test1 =null ;


	public void onFinish(ITestContext result) {
		System.out.println("test is completed  : "+result.getName());
		test1.info("Automated tests run is finished ");
		extent.flush();


	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		try
		{
			
			String filename= result.getStartDate().toString().replaceAll(":","-");
			String projPath = System.getProperty("user.dir");
			htmlReporter = new ExtentHtmlReporter(projPath+"\\Reoprts\\"+filename+".html");
			extent.attachReporter(htmlReporter);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

		test1.fail(result.getName()+"TestFailedButWithinSuccessPercentage");

	}

	public void onTestFailure(ITestResult result) {


		System.out.println("test is failed : "+result.getName());
		test1.fail("test is failed : "+result.getName());
		test1.fail(result.getThrowable());
		String projPath = System.getProperty("user.dir");
		String  screenshotPath=projPath+"\\screenshots\\"+result.getName()+".jpg" ;
		// now copy the screenshot to desired location using copyFile //method
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File(screenshotPath));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		try {
			test1.addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("test is skipped : "+result.getName());
		test1.fail("test is skipped : "+result.getName());

	}

	public void onTestStart(ITestResult result) {
		System.out.println("test started : "+result.getName());	
		test1 = extent.createTest(result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("test is sucessful : "+result.getName());
		test1.pass("test is sucessful : "+result.getName());


	}












}

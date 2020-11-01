package TestRunner;





import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;


import util.ReadConfig;

public class Base {
	Logger logger;
	WebDriver driver;
	
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports report;
	static ExtentTest test;
	   static ReadConfig rc = new ReadConfig();
	   
	   public static String url = rc.getUrl();

	   @BeforeTest
	   public void setExtentReport()
	   {
		   htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		   
		   htmlReporter.config().setDocumentTitle("Automation Report");
		   
		   report = new ExtentReports();
		   report.attachReporter(htmlReporter);
		   
	   }
	
	//Logger logger;
	@BeforeMethod
	public void lunchbrowser() throws InterruptedException
	{
		 
		logger=LogManager.getLogger(RunTest.class);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mahendran\\eclipse-workspace\\AutomationPractice\\chromedriver\\chromedriver.exe");
	driver = new ChromeDriver();
	
	//logger = LogManager.getLogger(RunTest.class);	
		
	}
	
	
@AfterMethod
public void tear(ITestResult result) throws Exception

{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		test.log(Status.FAIL, "Test Case Failed"+" "+result.getName());
		
String screenimage = RunTest.takeSnapShot(driver, "C:\\Users\\Mahendran\\eclipse-workspace\\AutomationPractice\\test-output\\fail.png");
	test.addScreenCaptureFromPath(screenimage);
	}
	else if(result.getStatus()==ITestResult.SUCCESS) {
		test.log(Status.PASS, "Test case passes"+" "+result.getName());
	}
	driver.quit();
	
}

@AfterTest
public static void endTest()
{

report.flush();
}


public static String takeSnapShot(WebDriver driver,String fileWithPath) throws Exception{

    //Convert web driver object to TakeScreenshot

    TakesScreenshot scrShot =((TakesScreenshot)driver);

    //Call getScreenshotAs method to create image file

            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
String destination = fileWithPath;
            File DestFile=new File(destination);

            //Copy file at destination

            FileUtils.copyFile(SrcFile, DestFile);
            return destination;
            

}
}

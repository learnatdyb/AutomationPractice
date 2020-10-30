package TestRunner;





import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import util.ReadConfig;

public class Base {
	Logger logger;
	WebDriver driver;
	
	static ExtentReports report;
	static ExtentTest test;
	   static ReadConfig rc = new ReadConfig();
	   
	   public static String url = rc.getUrl();

	   @BeforeTest
	   public void setExtentReport()
	   {
		   report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		   test = report.startTest("AutomationPracticeWebSite");
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
public void tear(ITestResult result)

{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		test.log(LogStatus.FAIL, "Test Case Failed"+" "+result.getName());
	}
	else if(result.getStatus()==ITestResult.SUCCESS) {
		test.log(LogStatus.PASS, "Test case passes"+" "+result.getName());
	}
	driver.quit();
	
}

@AfterTest
public static void endTest()
{
report.endTest(test);
report.flush();
}
}

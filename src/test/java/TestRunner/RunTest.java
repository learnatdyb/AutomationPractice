package TestRunner;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestDefenition.AutoPracticeFunctions;

public class RunTest extends Base {
	
	@Test(priority =1)
		public void launchwebsite() throws InterruptedException
	{	 
	
		AutoPracticeFunctions a= new AutoPracticeFunctions(driver);
		
		a.launchsite();
		logger.info("Website luanched successfully");
		
	Assert.assertEquals(driver.getTitle(), "My Store");
	
	logger.info("Title verified successfully");
		

		

	}
	@Test(priority=2)
	public void verify_tabs_text() throws InterruptedException
	{
	
		AutoPracticeFunctions b= new AutoPracticeFunctions(driver);
		b.launchsite();
		Assert.assertEquals(b.verifytabs().get(0).getText(), "WOMEN");
logger.info("First Tab text verified successfully");

	}
	
	@Test(retryAnalyzer=util.RetryAnalyzer.class)
	public void three()
	{
		Assert.assertTrue(true);
	}

}

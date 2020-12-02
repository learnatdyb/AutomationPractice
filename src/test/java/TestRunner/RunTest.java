package TestRunner;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.ObjectRepo;
import TestDefenition.AutoPracticeFunctions;

public class RunTest extends Base {
	
	@Test(priority =1)
		public void launchwebsite() throws InterruptedException
	{	 
		test = report.createTest("launchwebsite");
		AutoPracticeFunctions a= new AutoPracticeFunctions(driver);
		
		a.launchsite();
		logger.info("Website luanched successfully");
		
	Assert.assertEquals(driver.getTitle(), "My Store");
	
	logger.info("Title verified successfully");
		

		

	}
	@Test(priority=2)
	public void verify_tabs_text() throws InterruptedException
	{
		test = report.createTest("verify_tabs_text");
		AutoPracticeFunctions b= new AutoPracticeFunctions(driver);
		b.launchsite();
		Assert.assertEquals(b.verifytabs().get(0).getText(), "WOMEN");
logger.info("First Tab text verified successfully");

	}
	
	@Test(retryAnalyzer=util.RetryAnalyzer.class)
	public void click_on_women_tab() throws InterruptedException
	{
		test = report.createTest("click on women tab");
		AutoPracticeFunctions c= new AutoPracticeFunctions(driver);
		c.launchsite();
		c.clickwomentab();
		logger.info("Clicked on Women Tab successfully");
		c.clickblouses();
		logger.info("Clicked on Blouses successfully");
		
	}
	
	@Test
public void assertionofblouseitems() throws InterruptedException
{
	
	test = report.createTest("click on women tab");
	AutoPracticeFunctions d= new AutoPracticeFunctions(driver);
	d.launchsite();
	d.clickwomentab();
	d.clickblouses();
	d.numberofblouses();
	
}
	@Test
public void assert_product() throws InterruptedException
{
	test = report.createTest("Assert");
	AutoPracticeFunctions d= new AutoPracticeFunctions(driver);
	d.launchsite();
	d.clickwomentab();
	d.clickblouses();
	d.numberofblouses();
Assert.assertTrue(d.product_available());
}	
}

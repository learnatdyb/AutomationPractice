package TestDefenition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ObjectRepository.ObjectRepo;
import TestRunner.Base;


public class AutoPracticeFunctions {
	
	WebDriver driver;
	 int i;
	
	public AutoPracticeFunctions(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void launchsite() throws InterruptedException
	{
		
		driver.get(Base.url);
		Thread.sleep(5000);
		
	}
	
	public List<WebElement> verifytabs()
	{
		List<WebElement> tabs = driver.findElements(ObjectRepo.Htabs);

System.out.println(tabs.size());

return tabs;
			
}		
		
		

	
	}



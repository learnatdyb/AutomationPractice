package TestDefenition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		List<WebElement> tabs = driver.findElements(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li"));

System.out.println(tabs.size());

return tabs;
			
}		
		
		

	
	}



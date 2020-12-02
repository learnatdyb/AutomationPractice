package TestDefenition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import ObjectRepository.ObjectRepo;
import TestRunner.Base;


public class AutoPracticeFunctions {
	
	WebDriver driver;
	 int i;
	 int items_count; 
	 WebElement productavailable;
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
		
	public void clickwomentab()
	{
		
		Actions act = new Actions(driver);
		
		act.moveToElement(driver.findElement(ObjectRepo.womentab)).build().perform();
	}

	
	public void clickblouses()
	{
		driver.findElement(ObjectRepo.blouses).click();
	}
	public void numberofblouses() throws InterruptedException
	{
	List<WebElement> item =  driver.findElements(ObjectRepo.items);	
	
	 items_count = item.size();
	 Thread.sleep(3000);
	 
	 productavailable = driver.findElement(By.xpath("//h1[@class='page-heading product-listing']//span[text()='There is "+items_count+" product.']"));

	System.out.println("xpath:"+productavailable);
		}
	public boolean product_available()
	{
		productavailable.isDisplayed();
		return true;
	}
	
	}



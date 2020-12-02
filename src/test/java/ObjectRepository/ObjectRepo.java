package ObjectRepository;

import org.openqa.selenium.By;

public class ObjectRepo {
	
	public static By Htabs = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li");
    public static By womentab = By.cssSelector("a[title='Women']");
    public static By blouses = By.cssSelector("a[title='Blouses']");
    public static By items = By.xpath("//ul[@class='product_list grid row']//li//div[@class='left-block']");
    
   // public static By productlistmessage = By.xpath("//h1[@class='page-heading product-listing']//span[text()='There is 1 product.']");
}

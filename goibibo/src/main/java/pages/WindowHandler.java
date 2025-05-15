package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Base;

public class WindowHandler extends Base{
	private WebDriver driver;

	private WebDriverWait wait;

public WindowHandler() {
	initialise(); 
    this.driver = super.driver;
    this.wait =  super.wait;
    PageFactory.initElements(driver, this);
	
}
	public void WindowHandler() {
		try {
            WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='logSprite icClose']")));
            closePopup.click();
        } catch (Exception e) {
            System.out.println("Popup not found or already closed.");
        }
        
        WebElement window2 = driver.findElement(By.xpath("//a[@href=\"/giholidays/\"]"));
       window2.click();
      
       
       Set<String> tabs = driver.getWindowHandles();
       
       Iterator<String> itr = tabs.iterator();
       
       String tab1 = itr.next();
       
       String tab2 = null;
       
       if (itr.hasNext()) {
    	   tab2 = itr.next();
    	   
    	   driver.switchTo().window(tab2);
    	   
    	   WebElement search = driver.findElement(By.id("search_button"));
    	   
    	   search.click();
    	   
    	   driver.switchTo().window(tab1);
    	   
    	   driver.close();
    	   
    	   
       }
       
       driver.quit();
         
	}
	
}
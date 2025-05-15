package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hover extends Base {
	private WebDriver driver;

	private WebDriverWait wait;

public Hover() {
	initialise(); 
    this.driver = super.driver;
    this.wait =  super.wait;
    PageFactory.initElements(driver, this);
	
}

	public void hoverTest() {
   	 WebDriverManager.chromedriver().setup();
       
        try {
            WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='logSprite icClose']")));
            closePopup.click();
        } catch (Exception e) {
            System.out.println("Popup not found or already closed.");
        }
        WebElement hover = driver.findElement(By.xpath("//a[@href=\"/travelhistory\"]"));
        
        Actions action = new Actions(driver);
        
        action.moveToElement(hover).perform();
        
        WebElement onHover = driver.findElement(By.xpath("(//p[@class=\"sc-imWYAI pQYto\"])[1]"));
        
        Assert.assertEquals(true, onHover.isDisplayed());
        
        driver.quit();
   	
   }

   }


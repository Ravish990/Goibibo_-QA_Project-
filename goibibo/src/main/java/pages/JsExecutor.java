package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JsExecutor extends Base {
	private WebDriver driver;

	private WebDriverWait wait;

public JsExecutor() {
	initialise(); 
    this.driver = super.driver;
    this.wait =  super.wait;
    PageFactory.initElements(driver, this);
	
}
	public void jsExecutor() {
    	
        try {
            WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='logSprite icClose']")));
            closePopup.click();
        } catch (Exception e) {
            System.out.println("Popup not found or already closed.");
        }
        JavascriptExecutor js;
        js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(arguments[0], arguments[1]); console.log('scroll down');", 0,1000);
	
		js.executeScript("window.scrollBy(arguments[0], arguments[1]); console.log('scroll up')", 0,-500);
		
		js.executeScript("document.body.style.zoom='170%'; console.log('zoomed in')");
		
		js.executeScript("document.body.style.zoom='40%';console.log('zoomed up')");
		
		js.executeScript("window.scrollBy(0, document.body.scrollHeight); console.log('scrolled down')");
		
		driver.quit();
		   
    }

}

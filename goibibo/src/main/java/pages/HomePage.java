package pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

public class HomePage extends Base {
	 private WebDriver driver;

		private WebDriverWait wait;

	public HomePage() {
		initialise(); 
        this.driver = super.driver;
        this.wait =  super.wait;
        PageFactory.initElements(driver, this);
		
	}

	public void testHomePageElements() {
       
        try {
            driver.get("https://www.goibibo.com/");

            // Wait for the page to load and close any popups if present
            try {
                WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='logSprite icClose']")));
                closePopup.click();
            } catch (Exception e) {
                System.out.println("Popup not found or already closed.");
            }

            // Check visibility and interactability of tabs (Flights, Hotels, Trains, etc.)
            
            String[] xpaths = {
                "//a[@href='/flights/']",
                "//a[@href='/hotels/']",
                "//a[@href='/trains/']",
                "//a[@href='/cars/']",
                "//a[@href='/bus/']",
                "//a[@href='https://tripmoney.goibibo.com/partners/gi/forex/listing?utm_source=header_goibibo&utm_medium=desktop']",
                "//a[@href='/giholidays/']",
                "//a[@href='/insurance?cmp=desktop_header']",
                "//a[@href='/travelhistory']",
                
               
            };

            for (int i = 0; i < xpaths.length; i++) {
                try {
                    WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpaths[i])));
                    if (el.isDisplayed() && el.isEnabled()) {
                        System.out.println(" " + el.getText() + " tab is visible and clickable.");
                    } else {
                        System.out.println(" " + el.getText() + " tab is not interactable.");
                    }
                } catch (Exception e) {
                    System.out.println(" " + xpaths[i] + " tab failed due to: " + e.getMessage());
                }
            }

            // Check Login button
            try {
                WebElement loginBtn = driver.findElement(By.id("get_sign_in"));
                if (loginBtn.isDisplayed()) {
                    System.out.println(" Login button is visible.");
                } else {
                    System.out.println(" Login button is not visible.");
                }
            } catch (Exception e) {
                System.out.println(" Login button is not visible: " + e.getMessage());
            }

         

            // Check footer links
            try {
                List<WebElement> footerLinks = driver.findElements(By.xpath("//footer//a"));
                System.out.println(" Footer contains " + footerLinks.size() + " links.");
            } catch (Exception e) {
                System.out.println(" Footer links check failed: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(" Homepage elements test failed due to: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
        
	}
        

}

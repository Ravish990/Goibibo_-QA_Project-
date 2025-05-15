package pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Base;
import utilities.DataReader;

public class LoginPage extends Base {

    private WebDriver driver;

	private WebDriverWait wait;

    public LoginPage() {
        initialise(); 
        this.driver = super.driver;
        this.wait =  super.wait;
        PageFactory.initElements(driver, this);
    }
    


   public void Login() {
	
	// Wait for the page to load and close any popups if present
       try {
           WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='logSprite icClose']")));
           closePopup.click();
       } catch (Exception e) {
           System.out.println("Popup not found or already closed.");
       }
  	
  	WebElement login = driver.findElement(By.xpath("//div[@data-id=\"user-info-tab\"]"));
  	
  	Actions action = new Actions(driver);
  	action.moveToElement(login).click().perform();

  	
  	WebElement loginAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class=\"loginCont__input\"]")));
  	loginAccount.click();
  	
  	
  	
  	loginAccount.sendKeys(DataReader.get("phone"));
  	
  	WebElement button = driver.findElement(By.xpath("//button[text() = \"Continue\"]"));
  	
  	button.click();
  	
  	driver.quit();
   }
}

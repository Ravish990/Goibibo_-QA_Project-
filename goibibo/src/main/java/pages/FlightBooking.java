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

import Base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FlightBooking extends Base {
	private WebDriver driver;

	private WebDriverWait wait;

public FlightBooking() {
	initialise(); 
    this.driver = super.driver;
    this.wait =  super.wait;
    PageFactory.initElements(driver, this);
	
}

	public void bookFlight(String fromCity, String toCity) {
      
        try {
            driver.get("https://www.goibibo.com/flights/");

            // Close popup if present
            try {
                WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='logSprite icClose']")));
                closePopup.click();
            } catch (Exception e) {
                System.out.println("Popup not found or already closed.");
            }

            WebElement fromField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sc-12foipm-2 eTBlJr fswFld '])[1]")));
            fromField.click();

            WebElement fromInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='sc-12foipm-24 bDSkOK'])/div/input")));
            fromInput.sendKeys(fromCity);

            WebElement fromSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[@class='sc-12foipm-33 kUcHKT'])[1]")));
            fromSuggestion.click();

            WebElement toInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-12foipm-25 fbAAhv']/input")));
            toInput.sendKeys(toCity);

            WebElement toSuggestion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='sc-12foipm-29 gEpyDY'])[1]")));
            toSuggestion.click();
            
            WebElement dateField = driver.findElement(By.xpath("(//p[@class=\"sc-12foipm-4 czGBLf fswWidgetTitle\"])[3]"));

//             action 
            
            Actions action = new Actions(driver);
            
            action.moveToElement(dateField).click().perform();
            
            

            WebElement dateSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[@class=\"fsw__date\"])[30]")));
            dateSelect.click();
            
            
            
            WebElement userSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[@class=\"sc-12foipm-4 czGBLf fswWidgetTitle\"])[4]")));
            userSelect.click();
           

    
         WebElement addUser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='sc-12foipm-51 kZvHQU'])[2]")));
         WebElement checkLimit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='sc-12foipm-52 jueHCN'])[1]")));

         while (true) {
             String beforeText = checkLimit.getText();
             addUser.click();
             checkLimit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='sc-12foipm-52 jueHCN'])[1]")));
             String afterText = checkLimit.getText();

             if (afterText.equals(beforeText)) {
                 break;
             }
         }


         WebElement deleteUser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='sc-12foipm-51 kZvHQU'])[1]")));

      
         while (true) {
             String beforeText = checkLimit.getText();
             deleteUser.click();
             
             checkLimit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='sc-12foipm-52 jueHCN'])[1]")));
             String afterText = checkLimit.getText();

             if (afterText.equals(beforeText)) {
                 break;
             }
         }
  WebElement iframe = driver.findElement(By.id("webpush-onsite"));
         
         driver.switchTo().frame(iframe);
         
          WebElement deny = driver.findElement(By.id("deny"));
         
         deny.click();
         
         driver.switchTo().defaultContent();
         
        
         WebElement done = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Done']")));
         done.click();
         
         
         
         WebElement radio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class=\"sc-12foipm-91 biWUTl\"])[1]")));
         
         radio.click();
        
         
         WebElement radio1 = driver.findElement(By.xpath("(//div[@class=\"sc-12foipm-91 biWUTl\"])[2]"));
         radio1.click();
         
         WebElement radio2 = driver.findElement(By.xpath("(//div[@class=\"sc-12foipm-91 biWUTl\"])[3]"));
         radio2.click();
         
         WebElement radio3 = driver.findElement(By.xpath("(//div[@class=\"sc-12foipm-91 biWUTl\"])[4]"));
         radio3.click();
         
         
         radio3.click();
         
            WebElement searchFlights = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = \"SEARCH FLIGHTS\"]")));
            searchFlights.click();
            
            WebElement gotIt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = \"GOT IT\"]")));
            
            gotIt.click();
            WebElement viewFares = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='VIEW FARES'])[1]")));
            viewFares.click();

            WebElement bookNow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='lato-black button buttonPrimary buttonBig fontSize14'][1]")));
            bookNow.click();

            System.out.println(" Flight booking test passed for: " + fromCity + " to " + toCity);

        } catch (Exception e) {
            System.out.println(" Flight booking failed for: " + fromCity + " to " + toCity);
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

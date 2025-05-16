package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public void initialise() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.goibibo.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
             wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }
    }


}

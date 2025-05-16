package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Screenshot implements ITestListener {
	WebDriver driver;
	
	@Override
	public void onStart(ITestContext result) {
		System.out.println("Started");
	}
	
	@Override 
	public void onFinish(ITestContext result) {
		System.out.println("Finished");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Success");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("failed Test : " + result.getName());
		
		ITestContext context = result.getTestContext();
		
		WebDriver driver = (WebDriver)context.getAttribute("driver");
		
		if (driver != null) {
			takeScreenshots(driver, result.getName());
		}
		else {
			System.out.println("Driver is null");
		}
	
	}
	
	public void takeScreenshots(WebDriver driver, String testName) {
		
		try {
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()); 
			String screenshotName = "screenshots/" + testName + "_" + timestamp + ".png";
			new File("Screenshots").mkdirs();
			
			FileHandler.copy(screenshot, new File(screenshotName)); 
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}	
	}
}
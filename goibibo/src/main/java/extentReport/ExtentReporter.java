package extentReport;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExtentReporter implements IReporter {  

    private ExtentReports extent;

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        // Setup Extent Spark Reporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(outputDirectory + "/ExtentReport.html");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Goibibo Test Execution");

        // Attach reporter to ExtentReports
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Add environment/system info
        extent.setSystemInfo("Tester", "Ravish");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome");

        // Process each suite and its results
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult result : suiteResults.values()) {
                ITestContext context = result.getTestContext();
                buildTestNodes(context.getPassedTests(), Status.PASS);
                buildTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
            }
        }

        // Write everything to the report
        extent.flush();
    }

    private void buildTestNodes(IResultMap tests, Status status) {
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                ExtentTest test = extent.createTest(result.getMethod().getMethodName());

                for (String group : result.getMethod().getGroups()) {
                    test.assignCategory(group);
                }

                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));

                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }

               
                if (status == Status.FAIL) {
                    String screenshotPath = System.getProperty("user.dir") +
                            "/screenshots/" + result.getMethod().getMethodName() + ".png";

                    File screenshotFile = new File(screenshotPath);
                    if (screenshotFile.exists()) {
                        try {
                            test.addScreenCaptureFromPath(screenshotPath);
                        } catch (Exception e) {
                            test.warning("Screenshot could not be attached: " + e.getMessage());
                        }
                    } else {
                        test.warning("Screenshot not found at: " + screenshotPath);
                    }
                }
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}

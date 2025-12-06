package base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseTest {
	protected WebDriver driver; 
	protected static ExtentReports extent; 
	protected static ExtentTest test;

	@BeforeSuite
	public void setupReport() {
		String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		String reportPath = System.getProperty("user.dir") + "/reports/AutomationReport_" + timeStamp + ".html"; 
		
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		spark.config().setReportName("Ecommerce Automation Test Report");
		spark.config().setDocumentTitle("Ecommerce Test Report");
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Billa");
		extent.setSystemInfo("Project", "Online HealthCare Automation");
		
	}
	
	@AfterSuite 
	public void tearDownReport() {
		if(extent != null) {
			extent.flush();
		}
	}
	
	@BeforeMethod
	public void setUp(Method method) {
		String browser = ConfigReader.getProperty("browser"); 
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions(); 
			options.addArguments("--incognito");
			
			driver = new ChromeDriver(options); 
		} else {
			throw new RuntimeException("Browser not supported: " + browser);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		String url = ConfigReader.getProperty("baseUrl"); 
		driver.get(url);
		
		test = extent.createTest(method.getName()); 
	}
	
	@AfterMethod 
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.pass("Test Passed");
		
		} else if(result.getStatus() == ITestResult.SKIP) {
			test.skip("Test Skipped"); 
		
		} else if(result.getStatus() == ITestResult.FAILURE) {
			test.fail("Test Failed");
			String screenshotPath = takeScreenshot(result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		}
		
		if(driver != null) {
			driver.close();
		}
	}
	
	public String takeScreenshot(String testName) throws IOException {
		File srcPath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
		String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		String destPath = System.getProperty("user.dir") + "//screenshots" + testName + "_" + timeStamp + ".png";
		
		File destFile = new File(destPath); 
		FileUtils.copyFile(srcPath, destFile);
		
		return destPath; 
		
	}
	
}

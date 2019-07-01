package com.qa.base;
import java.io.IOException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.qa.actions.UserActions;
import com.qa.extentreports.ExtentReporterNG;
import com.qa.utils.TestUtils;

import org.apache.log4j.Logger;

/**
 * This class creates WebDriver sessions.
 * @author varun.prakash.patil
 *
 */

public class TestBase {
	
	Logger log = Logger.getLogger(TestBase.class);
	private WebDriver driver;
	public TestBase(){
		//Load Property file and set the name of the browser. Either from jenkins
		//or manually.
	}
	
	public WebDriver initDriver() throws InterruptedException, IOException {
		
		// browser name value passed from Jenkins
		String browserName = "chrome";
		System.out.println("---------------------"+browserName);
		
		
		
		
		if(browserName.equalsIgnoreCase("Firefox")){
			System.out.println("before");
			System.setProperty("webdriver.chrome.driver", "browserdrivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		else if(browserName.equalsIgnoreCase("chrome") || browserName.isEmpty()){
				System.setProperty("webdriver.chrome.driver", "browserdrivers\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.manage().window().maximize();
			}
		
		return driver;
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.FAILURE) {
			Reporter.log("Test Case Failed || Test Case ID: "+result.getMethod());
			Reporter.log("Test Case Failed || Test Case ID: "+result.getThrowable());
			ExtentReporterNG.screenPath=TestUtils.getScreenshot(driver, result.getTestName());
		}
		driver.quit();
	}
	
}


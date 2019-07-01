package com.qa.base;
import java.io.IOException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;

/**
 * This class creates WebDriver sessions.
 * @author varun.prakash.patil
 *
 */

public class TestBaseWithThreadLocal {
	
	Logger log = Logger.getLogger(TestBaseWithThreadLocal.class);
	
	private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	
	
	@BeforeMethod
	public void webDriver() throws InterruptedException, IOException {
		
		// browser name value passed from Jenkins
		String browserName = System.getProperty("browser");
		System.out.println("---------------------"+browserName);
		DesiredCapabilities capability = new DesiredCapabilities();
		
		if (browserName == null)
			browserName = "chrome";
		
		else if(browserName.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.chrome.driver", "browserdrivers\\geckodriver.exe");
			capability.setBrowserName("Firefox");
			capability.setPlatform(Platform.WIN10);
			webDriver.set(new FirefoxDriver());
		}
		
		else if(browserName.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "browserdrivers\\chromedriver.exe");
				capability.setBrowserName("Chrome");
				capability.setPlatform(Platform.WIN10);
				webDriver.set(new ChromeDriver());
			}
		
		getWebDriver().manage().window().maximize();
	}
	
	/**
	 * @return the WebDriver for the current thread
	 */
	public WebDriver getWebDriver() {
		System.out.println("WebDriver: " + webDriver.get());
		return webDriver.get();
	}
	
	
	@AfterMethod
	public void tearDown() {
		getWebDriver().quit();
	}
	
}


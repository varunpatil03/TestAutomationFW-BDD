package com.qa.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LandingPage extends TestBase{
	Logger log = Logger.getLogger(LoginPage.class);
	private WebDriver driver;
	
	//Page Factory - OR:
	@FindBy(xpath="//aside//span[@title='TestAutomationFW-POM']")
	WebElement myname;	
	
	//Initializing the Page Objects:
	public LandingPage(WebDriver driver) throws InterruptedException, IOException{
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	//Actions:
	
	
	
}

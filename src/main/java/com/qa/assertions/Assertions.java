package com.qa.assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.base.TestBase;

public class Assertions extends TestBase {
	private WebDriver driver;
	public Assertions(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public boolean compareText(WebElement element, String expected) {
		
		if(element.getText().equals(expected))
			return true;
		else
			return false;
		
	}

}

package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.constants.Browser;

public abstract class BrowserUtility {
	
	private WebDriver driver;  
	//instance varibale -> Heap Memory
	
	public WebDriver getDriver() {
		return driver;
	}



	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver;  //initialize instance varibale driver using constructor!!
	}
		
	public BrowserUtility(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")){
			driver=new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("edge")){
			driver=new EdgeDriver();
			}
	else {
		System.err.print("Invalid browser name...Select chrome or edge only!!");
	}
	}
	
	public BrowserUtility(Browser browserName) {
		if(browserName==Browser.CHROME){
			driver=new ChromeDriver();
		}
		
		else if (browserName==Browser.EDGE){
			driver=new EdgeDriver();
			}
	else {
		System.err.print("Invalid browser name...Select chrome or edge only!!");
	}
	}

	public void goToWebsite(String url) {
		driver.get(url);
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void clickOn(By locator) { 
		WebElement element=driver.findElement(locator);
		element.click();
	}
	
	public void enterText(By locator, String textToEnter) {
		WebElement element=driver.findElement(locator);
		element.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By locator) {
		WebElement element = driver.findElement(locator);
		return element.getText();				
	}


}

package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.constants.Browser;

public abstract class BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();  //If using threadLocal then we need to use get and set methods to access the driver variable.
	//instance varibale -> Heap Memory
	
	public WebDriver getDriver() {
		return driver.get();
	}



	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);  //initialize instance varibale driver using constructor!!
	}
		
	public BrowserUtility(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")){
			driver.set(new ChromeDriver());
		}
		
		else if (browserName.equalsIgnoreCase("edge")){
			driver.set(new EdgeDriver());
			}
	else {
		System.err.print("Invalid browser name...Select chrome or edge only!!");
	}
	}
	
	public BrowserUtility(Browser browserName) {
		if(browserName==Browser.CHROME){
			driver.set(new ChromeDriver());
		}
		
		else if (browserName==Browser.EDGE){
			driver.set(new EdgeDriver());
			}
	else {
		System.err.print("Invalid browser name...Select chrome or edge only!!");
	}
	}
	
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		if(browserName==Browser.CHROME){
			if(isHeadless){
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old"); //headless
				options.addArguments("--window-size=1920,1080"); //window size
				driver.set(new ChromeDriver(options));
			}
			else {
				driver.set(new ChromeDriver());
			}
		}
		
		else if (browserName==Browser.EDGE){
			if(isHeadless){
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old"); //headless
				options.addArguments("disable-gpu"); 
				driver.set(new EdgeDriver(options));
			}
			else {
			driver.set(new EdgeDriver());
			}
		}
	else {
		System.err.print("Invalid browser name...Select chrome or edge only!!");
	}
	}

	public void goToWebsite(String url) {
		logger.info("Navigating to URL: " + url);
		driver.get().get(url);
	}
	
	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) { 
		logger.info("Clicking on element located by: " + locator.toString());
		WebElement element=driver.get().findElement(locator);
		element.click();
	}
	
	public void enterText(By locator, String textToEnter) {
		logger.info("Entering text '" + textToEnter + "' into element located by: " + locator.toString());
		WebElement element=driver.get().findElement(locator);
		element.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By locator) {
		logger.info("Getting visible text from element located by: " + locator.toString());
		WebElement element = driver.get().findElement(locator);
		return element.getText();				
	}
	
	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timestamp = format.format(date);
		String path=System.getProperty("user.dir") + "//screenshots//" + name + " - " + timestamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		
	}



}

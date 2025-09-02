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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {// parent class marked with Abstract keyword, cannot create object of this class

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}

//	public BrowserUtility(String browserName) {
//		logger.info("Launching the Browser fro " + browserName);
//		if (browserName.equalsIgnoreCase("chrome")) {
//			driver.set(new ChromeDriver()); // Launch the browser window
//		} else if (browserName.equalsIgnoreCase("edge")) {
//			driver.set(new EdgeDriver());
//		} else {
//			logger.error("Invalid browser name...Please select chrome or Edge");
//			System.err.println("Invalid browser name...Please select chrome or Edge");
//		}
//	}
//
//	public BrowserUtility(Browser browserName) {
//		logger.info("Launching the Browser fro " + browserName);
//		if (browserName == browserName.CHROME) {
//			driver.set(new ChromeDriver()); // Launch the browser window
//		} else if (browserName == browserName.EDGE) {
//			driver.set(new EdgeDriver());
//		} else if (browserName == browserName.FIREFOX) {
//			driver.set(new FirefoxDriver());
//		}
//	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching the Browser fro " + browserName);
		if (browserName == browserName.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless"); // Headless
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options)); // Launch the browser window
			} else {
				driver.set(new ChromeDriver());
			}
		} else if (browserName == browserName.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));

			} else {
				driver.set(new EdgeDriver());
			}
		} else if (browserName == browserName.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				driver.set(new FirefoxDriver(options));

			} else {
				driver.set(new FirefoxDriver());
			}
		}
	}

	public void goToWebsite(String url) {
		logger.info("Visiting the website " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding the WebElement with the locator " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Elment is found and now performing click operation ");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		WebElement element = driver.get().findElement(locator);
		logger.info("Element is found and entering the text " + locator);
		element.sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		logger.info("Element is found and now returning the visible " + element.getText());
		return element.getText();
	}

	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);

		//String path = System.getProperty("user.dir") + "//Screenshots//" + name + " " + timeStamp + ".png";
		String path = "./Screenshots/" + name + " " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public void quit() {
		driver.get().quit();
	}
}
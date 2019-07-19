package com.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class BaseTestCase {

	public static WebDriver driver;
	private Properties props;
	public static Logger log = LogManager.getLogger(BaseTestCase.class.getName());
	
	public String getProperty(String key) {
		return props.getProperty(key);
	}
	
	public WebDriver initializeDriver() throws IOException {
		log.debug("Entering method initializeDriver");
		String file = System.getProperty("user.dir") + "\\src\\test\\resources\\test.properties";
		FileInputStream fis;
		fis = new FileInputStream(file);
		props = new Properties();
		props.load(fis);
		System.out.println("Browser selected: " + props.getProperty("browser"));
		fis.close();
		log.debug("Exiting method initializeDriver");
		return getDriver(props.getProperty("browser"));
	}

	public WebDriver getDriver(String browser) {
		log.debug("Entering method getDriver");
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "D:\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver = new ChromeDriver();
			break;
		default:
			System.out.println("Unsupported driver , aborting");
			System.exit(1);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.debug("Exiting method getDriver");
		return driver;
	}
	
	public static void getScreenshot(String result) throws IOException {
		log.debug("Entering method getScreenshot");
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("D:\\Selenium-Automation-Course-Rahul Shetty\\screenshot-"+result+".png"));
		log.debug("Exiting method getScreenshot");
	}

	public static void main(String[] arg) {
		BaseTestCase test = new BaseTestCase();
		try {
			test.initializeDriver();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

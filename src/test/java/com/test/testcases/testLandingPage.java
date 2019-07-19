package com.test.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.base.BaseTestCase;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;

public class testLandingPage extends BaseTestCase {

	@BeforeMethod
	public void setup() throws IOException {
		log.debug("Entering method - driver initialization");
		driver = initializeDriver();	
		log.debug("Exiting method - driver initialization");
	}

	@AfterMethod
	public void tearDown() {
		log.debug("Entering method - driver tear down");
		driver.close();
		log.debug("Exiting method - driver tear down");
	}

	@Test
	public void loadlandingPage() throws IOException {
		log.debug("Entering method loadlandingPage");
		HomePage hp = new HomePage(driver);
		hp.loadHomePage(driver);
		hp.getloginPage(driver).click();
		Assert.assertEquals(driver.getTitle(), "QaClickAcademy", "Verification of the login page");
		log.debug("Exiting method loadlandingPage");
	}
	
	@Test
	public void checkBannerOnLandingPage() {
		log.debug("Entering method checkBannerOnLandingPage");
		HomePage hp = new HomePage(driver);
		hp.loadHomePage(driver);
		Assert.assertTrue(hp.getBannerOnPage(driver).isDisplayed());
		log.debug("Exiting method checkBannerOnLandingPage");
	}

}

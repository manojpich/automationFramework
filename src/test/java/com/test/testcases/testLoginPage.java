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

public class testLoginPage extends BaseTestCase {

	@BeforeMethod
	public void setup() throws IOException {
		driver = initializeDriver();
		log.info("Driver initialization complete");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		log.info("Driver tear down complete");
	}

	@Test(dataProvider="getData")
	public void loadloginPage(String user,String password) throws IOException {
		log.info("Entering method loadloginPage");
		LoginPage lp = new LoginPage(driver);
		lp.loadLoginPage(driver);
		lp.getUserID(driver).sendKeys(user);
		lp.getUserPassword(driver).sendKeys(password);
		lp.getLoginButon(driver).click();
		Assert.assertEquals(lp.getAlertMessage(driver).getText(),"Invalid email or password.","Verification of error message on login with wrong credentials");
		log.info("Exiting method loadloginPage");
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] obj;
		obj = new Object[][] {{"authorized@xyz.com","password1"},{"unauthorized@xyz.com","passwordunauth"}};
		return obj;
	}

}
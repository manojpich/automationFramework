package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	By Login = By.cssSelector("a[href*='sign_in']");
	By Banner = By.cssSelector("ul.nav.navbar-nav.navbar-right");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void loadHomePage(WebDriver driver){
		driver.get("http://www.qaclickacademy.com/");
	}
	
	public WebElement getloginPage(WebDriver driver) {
		return driver.findElement(Login);
	}
		
	public WebElement getBannerOnPage(WebDriver driver) {
		return driver.findElement(Banner);
	}
}
